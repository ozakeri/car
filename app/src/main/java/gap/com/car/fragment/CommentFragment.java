package gap.com.car.fragment;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gap.com.car.R;
import gap.com.car.adapter.CommentListAdapter;
import gap.com.car.adapter.CommentSubListAdapter;
import gap.com.car.adapter.TypeSpinnerAdapter;
import gap.com.car.app.CarApplication;
import gap.com.car.common.Constants;
import gap.com.car.database.DataBaseClint;
import gap.com.car.database.entity.CommentBean;
import gap.com.car.database.entity.Driver;
import gap.com.car.gapcalendar.customweekview.PersianDate;
import gap.com.car.model.SendCommentResponseBean;
import gap.com.car.model.TypeBean;
import gap.com.car.services.ServerCoordinator;
import gap.com.car.util.RecyclerItemClickListener;
import gap.com.car.util.Utils;
import gap.com.car.widget.BSpinnerView;
import gap.com.car.widget.BTextView;
import gap.com.car.widget.CircularProgress;
import gap.com.car.widget.CustomTextViewTitle;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommentFragment extends Fragment {

    private RecyclerView recycler_view;
    private FloatingActionButton floatingActionButton;
    private CircularProgress progressbar;
    private CustomTextViewTitle txt_null;
    private List<CommentBean> commentBeanList = new ArrayList<>();
    private PersianDate persianDate;
    private boolean showCaseViewFirFirst = false;

    public CommentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_comment, container, false);
        showCaseViewFirFirst = CarApplication.getInstance().getSharedPreferences().getBoolean(Constants.REPORT_SHOW_CASE_VIEW_FOR_FIRST, false);
        recycler_view = view.findViewById(R.id.recycler_view);
        floatingActionButton = view.findViewById(R.id.floatingActionButton);
        progressbar = view.findViewById(R.id.progressbar);
        txt_null = view.findViewById(R.id.txt_null);
        progressbar.setVisibility(View.GONE);
        recycler_view.setLayoutManager(new LinearLayoutManager(getActivity()));
        getAll();
        persianDate = new PersianDate();

        if (showCaseViewFirFirst) {
            SharedPreferences.Editor editor = CarApplication.getInstance().getSharedPreferences().edit();
            editor.putBoolean(Constants.REPORT_SHOW_CASE_VIEW_FOR_FIRST, false);
            editor.apply();
            addReportShowcaseView(getActivity(), floatingActionButton);
        }
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        // recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
        recycler_view.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //CommentBean commentBean = commentBeanList.get(position);
                //getCommentById(commentBean.getId());
            }
        }));

        return view;

    }


    /*
     * show dialog for add comment
     * */
    public void showDialog() {
        final Dialog dialog_wait = new Dialog(getActivity(), R.style.Theme_Dialog);
        dialog_wait.setContentView(R.layout.custom_dialog_comment);
        dialog_wait.show();
        Window window = dialog_wait.getWindow();
        window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.CENTER);

        ImageView img_close = dialog_wait.findViewById(R.id.img_close);
        final BSpinnerView spinner = (BSpinnerView) dialog_wait.findViewById(R.id.comment_spinner);
        //spinner.setText("نوع گزارش");
        ArrayList<TypeBean> types = new ArrayList<TypeBean>();
        types.add(new TypeBean("انتقاد", 0));
        types.add(new TypeBean("پیشنهاد", 1));
        types.add(new TypeBean("گزارش مشکل", 2));
        TypeSpinnerAdapter typeSpinnerAdapter = new TypeSpinnerAdapter(getActivity(), types);
        spinner.setAdapter(typeSpinnerAdapter);
        spinner.setSelection(1);

        final EditText txt_comment = dialog_wait.findViewById(R.id.comment);
        txt_comment.setHint(getString(R.string.comment));
        txt_comment.setHintTextColor(getResources().getColor(R.color.iron));
        TextView btn_send = dialog_wait.findViewById(R.id.btn_send);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CarApplication application = (CarApplication) getActivity().getApplication();
                Driver driver = application.getCurrentUser();
                final String username = driver.getUsername();
                final String password = driver.getPassword();
                final String comment = txt_comment.getText().toString();

                if (!comment.isEmpty()) {
                    progressbar.setVisibility(View.VISIBLE);
                    final TypeBean typeBean = (TypeBean) spinner.getSelectedItem();

                    ServerCoordinator.getInstance().sendComment(username, password, comment, typeBean.getId(), new Response.Listener<SendCommentResponseBean>() {
                        @Override
                        public void onResponse(SendCommentResponseBean response) {
                            progressbar.setVisibility(View.GONE);
                            Utils.showToast(getActivity(), R.string.success_comment_sent, false);

                            saveComment(comment, typeBean.getId());

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            progressbar.setVisibility(View.GONE);
                            Utils.showToast(getActivity(), R.string.error_unknown, false);
                        }
                    });
                    dialog_wait.dismiss();
                } else {
                    Utils.showToast(getActivity(), R.string.label_comment_editText_warning, false);
                }


            }
        });

        img_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_wait.dismiss();
            }
        });

    }

    public void showDetailDialog(String comment) {
        final Dialog dialog_wait = new Dialog(getActivity(), R.style.Theme_Dialog);
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

    /*
     * show dialog for comment
     * */
    public void saveComment(final String commentStr, final int commentType) {


        @SuppressLint("StaticFieldLeak")
        class SaveComment extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                CommentBean commentBean = new CommentBean();
                commentBean.setCommentStr(commentStr);
                commentBean.setCommentTypeEn(commentType);
                commentBean.setCommentDate(persianDate.getShYear() + "/" + persianDate.getShMonth() + "/" + persianDate.getShDay());
                commentBean.setCommentTime(persianDate.getHour() + ":" + persianDate.getMinute());

                DataBaseClint.getInstance(getActivity()).getAppDataBase().commentDao().insertComment(commentBean);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);

                getAll();
            }
        }

        new SaveComment().execute();
    }


    /*
     * getAll Comment
     * */
    private void getAll() {
        class GetAllComment extends AsyncTask<Void, Void, List<CommentBean>> {

            @Override
            protected List<CommentBean> doInBackground(Void... voids) {
                commentBeanList = DataBaseClint.getInstance(getActivity()).getAppDataBase().commentDao().getAllComment();
                return commentBeanList;
            }

            @Override
            protected void onPostExecute(List<CommentBean> commentBeans) {
                super.onPostExecute(commentBeans);
                if (commentBeans.size() > 0) {
                    txt_null.setVisibility(View.GONE);
                }
                recycler_view.setAdapter(new CommentSubListAdapter(reverseListOrder(commentBeans), getActivity()));
            }
        }
        new GetAllComment().execute();
    }


    private void getCommentById(final int id) {
        class GetAllComment extends AsyncTask<Void, Void, CommentBean> {

            @Override
            protected CommentBean doInBackground(Void... voids) {
                return DataBaseClint.getInstance(getActivity()).getAppDataBase().commentDao().getCommentBeanById(id);
            }

            @Override
            protected void onPostExecute(CommentBean commentBean) {
                super.onPostExecute(commentBean);
                showDetailDialog(commentBean.getCommentStr());
            }
        }
        new GetAllComment().execute();
    }

    private List<CommentBean> reverseListOrder(List<CommentBean> status) {
        Iterator<CommentBean> it = status.iterator();
        List<CommentBean> destination = new ArrayList<>();
        while (it.hasNext()) {
            destination.add(0, it.next());
            it.remove();
        }
        return destination;
    }


    public static void addReportShowcaseView(final Context context, View view) {

        String title = "برای ثبت درخواست از این دکمه استفاده کنید";
        String description = "";

        TapTargetView.showFor((Activity) context, TapTarget.forView(view, title, description)
                .cancelable(false)
                .drawShadow(true)
                .targetCircleColor(R.color.light_green)
                .outerCircleColor(R.color.light_green_transparent)
                .textColor(R.color.white)
                .titleTextDimen(R.dimen.title_text_size)
                .tintTarget(false), new TapTargetView.Listener() {
            @Override
            public void onTargetClick(TapTargetView view) {
                super.onTargetClick(view);
            }

            @Override
            public void onOuterCircleClick(TapTargetView view) {
                super.onOuterCircleClick(view);
                Toast.makeText(view.getContext(), "You clicked the outer circle!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTargetDismissed(TapTargetView view, boolean userInitiated) {
                Log.d("TapTargetViewSample", "You dismissed me :(");
            }
        });
    }

}
