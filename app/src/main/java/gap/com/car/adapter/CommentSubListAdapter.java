package gap.com.car.adapter;

import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import gap.com.car.R;
import gap.com.car.database.DataBaseClint;
import gap.com.car.database.entity.CommentBean;
import gap.com.car.gapcalendar.customweekview.PersianDate;
import gap.com.car.widget.BTextView;


public class CommentSubListAdapter extends RecyclerView.Adapter<CommentSubListAdapter.CustomView> {

    private List<CommentBean> commentBeanList = new ArrayList<>();
    private PersianDate persianDate = new PersianDate();
    private Context context;

    public CommentSubListAdapter(List<CommentBean> commentBeanList, Context context) {
        this.commentBeanList = commentBeanList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.items_comment_layout, viewGroup, false);
        return new CustomView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomView customView, int position) {

        final CommentBean commentBean = commentBeanList.get(position);


        String myString = commentBean.getCommentStr();
        myString = myString.replaceAll("\n", "");

        if (myString.length() > 30) {
            customView.txt_comment.setText(myString.substring(0, 30) + " ... ");
        } else {
            customView.txt_comment.setText(myString);
        }


        int type = commentBean.getCommentTypeEn();
        switch (type) {
            case 0:
                //customView.txt_commentType.setText("انتقاد");
                customView.img_commentType.setBackgroundResource(R.drawable.enteghad);
                break;

            case 1:
                // customView.txt_commentType.setText("پیشنهاد");
                customView.img_commentType.setBackgroundResource(R.drawable.pishnehad);
                break;

            case 2:
                //customView.txt_commentType.setText("گزارش مشکل");
                customView.img_commentType.setBackgroundResource(R.drawable.rafe_moshkel);
                break;
        }

        if (commentBean.getCommentDate() != null) {
            String currentString = commentBean.getCommentDate();
            String[] separated = currentString.split("/");
            int day = Integer.parseInt(separated[2]);
            customView.txt_dateCreation.setText(commentBean.getCommentDate());

            if (persianDate.getShDay() - day == 0) {
                customView.txt_dateCreation.setText(" امروز " + " ساعت " + commentBean.getCommentTime());

            } else if (persianDate.getShDay() - day == 1) {
                customView.txt_dateCreation.setText(" دیروز " + " ساعت " + commentBean.getCommentTime());
            } else {
                customView.txt_dateCreation.setText(currentString + " ساعت " + commentBean.getCommentTime());
            }

        }
        customView.img_status.setBackgroundResource(R.drawable.deliverd);

        customView.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCommentById(commentBean.getId());
            }
        });
    }



    @Override
    public int getItemCount() {
        return commentBeanList.size();
    }

    public class CustomView extends RecyclerView.ViewHolder {
        BTextView txt_comment;
        AppCompatImageView img_status, img_commentType;
        TextView txt_dateCreation;

        public CustomView(@NonNull View itemView) {
            super(itemView);
            txt_comment = itemView.findViewById(R.id.txt_comment);
            img_commentType = itemView.findViewById(R.id.img_commentType);
            img_status = itemView.findViewById(R.id.img_status);
            txt_dateCreation = itemView.findViewById(R.id.txt_dateCreation);
        }
    }

    private void getCommentById(final int id) {
        class GetAllComment extends AsyncTask<Void, Void, CommentBean> {

            @Override
            protected CommentBean doInBackground(Void... voids) {
                return DataBaseClint.getInstance(context).getAppDataBase().commentDao().getCommentBeanById(id);
            }

            @Override
            protected void onPostExecute(CommentBean commentBean) {
                super.onPostExecute(commentBean);
                showDetailDialog(commentBean.getCommentStr());
            }
        }
        new GetAllComment().execute();
    }


    public void showDetailDialog(String comment) {
        final Dialog dialog_wait = new Dialog(context, R.style.Theme_Dialog);
        dialog_wait.setContentView(R.layout.custom_dialog_comment_detail);
        dialog_wait.show();
        Window window = dialog_wait.getWindow();
        window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.CENTER);

        final BTextView txt_comment = dialog_wait.findViewById(R.id.comment);
        txt_comment.setHint(comment);
        ImageView btn_close = dialog_wait.findViewById(R.id.btn_close);

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_wait.dismiss();
            }
        });
    }
}
