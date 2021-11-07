package gap.com.car.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import gap.com.car.R;
import gap.com.car.database.DataBaseClint;
import gap.com.car.database.entity.CommentBean;
import gap.com.car.database.entity.Driver;
import gap.com.car.fragment.MonthlyFragment;
import gap.com.car.fragment.WeekDayFragment;
import gap.com.car.gapcalendar.customweekview.PersianDate;
import gap.com.car.model.carprofile.CarSACommentList;
import gap.com.car.model.update.UpdateVersionResponseBean;
import gap.com.car.services.ServerCoordinator;
import gap.com.car.util.JalaliCalendarUtil;
import gap.com.car.util.Utils;
import gap.com.car.widget.BTextView;

public class CommentListAdapter extends RecyclerView.Adapter<CommentListAdapter.CustomView> {

    private List<CarSACommentList> carSACommentLists = new ArrayList<>();
    private PersianDate persianDate = new PersianDate();
    private Context context;
    private Driver driver;
    private CarSACommentList carSACommentList;
    private String fragmentName;
    private MonthlyFragment monthlyFragment;
    private WeekDayFragment weekDayFragment;
    private boolean isEdit = true;

    public CommentListAdapter(Driver driver, List<CarSACommentList> carSACommentLists, Context context, MonthlyFragment monthlyFragment) {
        this.carSACommentLists = carSACommentLists;
        this.context = context;
        this.driver = driver;
        this.monthlyFragment = monthlyFragment;
    }

    public CommentListAdapter(Driver driver, List<CarSACommentList> carSACommentLists, Context context, WeekDayFragment weekDayFragment) {
        this.carSACommentLists = carSACommentLists;
        this.context = context;
        this.driver = driver;
        this.weekDayFragment = weekDayFragment;
    }

    @NonNull
    @Override
    public CustomView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.items_description_layout, viewGroup, false);
        return new CustomView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomView customView, int position) {

        carSACommentList = carSACommentLists.get(position);

        if (carSACommentList != null) {

            final int id = carSACommentList.getId();
            final String commentStr = carSACommentList.getCommentText();

            String myString = carSACommentList.getCommentText();
            myString = myString.replaceAll("\n", "");

            if (myString.length() > 30) {
                customView.txt_comment.setText(myString.substring(0, 30) + " ... ");
            } else {
                customView.txt_comment.setText(myString);
            }

            if (carSACommentList.getDateCreation() != null) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
                try {
                    Date date = formatter.parse(carSACommentList.getDateCreation());
                    Calendar calender1 = Calendar.getInstance();
                    calender1.setTime(date);
                    JalaliCalendarUtil jalaliCalendarUtil = new JalaliCalendarUtil(calender1);

                    System.out.println("jalaliCalendarUtil=====" + jalaliCalendarUtil.getIranianDay());
                    System.out.println("jalaliCalendarUtil=====" + persianDate.getShDay());

                    if (persianDate.getShDay() - jalaliCalendarUtil.getIranianDay() == 0) {
                        customView.txt_dateCreation.setText(" امروز ");

                    } else if (persianDate.getShDay() - jalaliCalendarUtil.getIranianDay() == 1) {
                        customView.txt_dateCreation.setText(" دیروز ");
                    } else {
                        customView.txt_dateCreation.setText(jalaliCalendarUtil.getIranianDate3());
                    }

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }


            if (position%2 == 0){
                customView.main_layout.setBackgroundResource(R.color.colorAccent);
            }else {
                customView.main_layout.setBackgroundResource(R.color.light_green1);
            }
            customView.img_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //showMenu(v, id);
                    isEdit = true;
                    showAddDialog(id, commentStr);

                }
            });

            customView.img_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //showMenu(v, id);
                    showDeleteDialog(id);
                }
            });

            customView.main_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //showMenu(v, id);
                    isEdit = false;
                    showAddDialog(id, commentStr);

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return carSACommentLists.size();
    }

    public class CustomView extends RecyclerView.ViewHolder {
        TextView txt_comment, txt_dateCreation;
        AppCompatImageView img_delete, img_edit;
        RelativeLayout main_layout;

        public CustomView(@NonNull View itemView) {
            super(itemView);
            txt_comment = itemView.findViewById(R.id.txt_comment);
            txt_dateCreation = itemView.findViewById(R.id.txt_dateCreation);
            img_delete = itemView.findViewById(R.id.img_delete);
            img_edit = itemView.findViewById(R.id.img_edit);
            main_layout = itemView.findViewById(R.id.main_layout);
        }

    }


    /*public void editComments(int id, String s) {
        ServerCoordinator.getInstance().editDriverSAComment(driver.getUsername(), driver.getPassword(), id, s,
                new Response.Listener<UpdateVersionResponseBean>() {
                    @Override
                    public void onResponse(UpdateVersionResponseBean response) {

                        if (response.getsUCCESS() != null) {
                            Utils.showToast((Activity) context, R.string.success_comment_sent, false);
                            if (monthlyFragment != null) {
                                monthlyFragment.getComments(driver);
                            }

                            if (weekDayFragment != null) {
                                weekDayFragment.getComments();
                            }

                            *//*if (fragmentName.equals("MonthlyFragment")) {
                                monthlyFragment.getComments(driver);
                            }else if (fragmentName.equals("WeekDayFragment")){
                                weekDayFragment.getComments();
                            }*//*
                        } else {
                            Utils.showToast((Activity) context, R.string.error_unknown, false);
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
    }

    public void deleteComments(int id) {
        ServerCoordinator.getInstance().deleteDriverSAComment(driver.getUsername(), driver.getPassword(), id,
                new Response.Listener<UpdateVersionResponseBean>() {
                    @Override
                    public void onResponse(UpdateVersionResponseBean response) {

                        if (response.getsUCCESS() != null) {
                            Utils.showToast((Activity) context, R.string.success_comment_sent, false);
                            if (monthlyFragment != null) {
                                monthlyFragment.getComments(driver);
                            }

                            if (weekDayFragment != null) {
                                weekDayFragment.getComments();
                            }
                            *//*if (fragmentName.equals("MonthlyFragment")) {
                                monthlyFragment.getComments(driver);
                            }else if (fragmentName.equals("WeekDayFragment")){
                                weekDayFragment.getComments();
                            }*//*
                        } else {
                            Utils.showToast((Activity) context, R.string.error_unknown, false);
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
    }*/


    /*public void showMenu(View view, final int idddd) {
        PopupMenu menu = new PopupMenu(context, view);
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.action_edit:
                        System.out.println("action_edit");
                        System.out.println("idddd====" + idddd);
                        showAddDialog(idddd);
                        break;

                    case R.id.action_delete:
                        System.out.println("action_delete");
                        deleteComments(idddd);
                        break;

                }
                return true;
            }
        });
        menu.inflate(R.menu.edit_delete_menu);
        menu.show();
    }*/

    public void showAddDialog(final int id, String commentStr) {
        final Dialog dialog_wait = new Dialog(context, R.style.Theme_Dialog);
        dialog_wait.setContentView(R.layout.show_add_dialog);
        dialog_wait.show();
        dialog_wait.setCancelable(false);
        Window window = dialog_wait.getWindow();
        window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.CENTER);

        final EditText comment = dialog_wait.findViewById(R.id.comment);
        TextView btn_send = dialog_wait.findViewById(R.id.btn_send);
        ImageView img_close = dialog_wait.findViewById(R.id.img_close);

        if (!isEdit) {
            btn_send.setVisibility(View.GONE);
            comment.setEnabled(false);
        }


        comment.setText(commentStr);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!comment.getText().toString().isEmpty()) {
                    //editComments(id, comment.getText().toString());
                    dialog_wait.dismiss();
                } else {
                    Utils.showToast((Activity) context, R.string.label_comment_editText_warning, false);
                }
            }
        });

        img_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_wait.dismiss();
            }
        });
    }

    public void showDeleteDialog(final int id) {
        final Dialog dialog_wait = new Dialog(context, R.style.Theme_Dialog);
        dialog_wait.setContentView(R.layout.show_delete_dialog);
        dialog_wait.show();
        dialog_wait.setCancelable(false);
        Window window = dialog_wait.getWindow();
        window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.CENTER);

        TextView btn_yes = dialog_wait.findViewById(R.id.btn_yes);
        TextView btn_no = dialog_wait.findViewById(R.id.btn_no);
        ImageView img_close = dialog_wait.findViewById(R.id.img_close);

        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_wait.dismiss();
                //deleteComments(id);
            }
        });

        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_wait.dismiss();
            }
        });

        img_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_wait.dismiss();
            }
        });
    }
}
