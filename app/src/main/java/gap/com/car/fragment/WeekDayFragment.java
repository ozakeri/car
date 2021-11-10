package gap.com.car.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.rahatarmanahmed.cpv.CircularProgressView;

import org.greenrobot.eventbus.EventBus;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.Months;
import org.joda.time.Years;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import gap.com.car.R;
import gap.com.car.adapter.CarDailyEventListAdapter;
import gap.com.car.adapter.CommentListAdapter;
import gap.com.car.adapter.HalfPathListAdapter;
import gap.com.car.app.CarApplication;
import gap.com.car.common.Constants;
import gap.com.car.database.entity.Driver;
import gap.com.car.gapcalendar.customweekview.CommonMethod;
import gap.com.car.gapcalendar.customweekview.DateConvertor;
import gap.com.car.gapcalendar.customweekview.PersianCalendar;
import gap.com.car.gapcalendar.customweekview.PersianDate;
import gap.com.car.gapcalendar.customweekview.Roozh;
import gap.com.car.model.CarDailyEventList;
import gap.com.car.model.EventBusModel;
import gap.com.car.model.SalaryAttribute;
import gap.com.car.model.ServerDateTimeResponseBean;
import gap.com.car.model.carinvoice.DailyEventList;
import gap.com.car.model.carinvoice.HalfPathInfoList;
import gap.com.car.model.carinvoice.SuccessResponseCarInvoice;
import gap.com.car.model.carprofile.CarSACommentList;
import gap.com.car.model.driverprofile.DriverProfileModel;
import gap.com.car.model.update.ReportListResponseBean;
import gap.com.car.model.update.UpdateVersionResponseBean;
import gap.com.car.services.ServerCoordinator;
import gap.com.car.util.DateUtils;
import gap.com.car.util.Globals;
import gap.com.car.util.JalaliCalendarUtil;
import gap.com.car.util.Util;
import gap.com.car.util.Utils;
import gap.com.car.widget.CircularProgress;
import gap.com.car.widget.MyValueFormatter;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by GapCom on 01/08/2018.
 */

public class WeekDayFragment extends Fragment {

    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;

    private Calendar calendar = Calendar.getInstance();
    private PersianCalendar persianCalendar = new PersianCalendar();
    private int day;
    private int month;
    private int year;
    private String monthName;
    private Roozh roozh = new Roozh();
    private PersianDate persianDate;
    private Globals sharedData;
    private TextView txt_driverStatus, txt_null, showEmptyMessage, txt_halfPathAcpt, txt_timeMinWorkInLine, txt_kmInLineFV, txt_kmAll, txt_countEtPass, txt_priceEtPass, txt_countEtCash, txt_priceEtCash, txt_etCardNo, txt_priceEtSumFV, txt_priceSubDF_2, txt_showEmpty1, txt_showEmpty2;
    private ImageView img_change1, img_change2, img_change3, img_change4, img_status, img_fab1, img_fab2, img_fab3, img_back, btnListFab;
    private RelativeLayout relativeLayout22, relativeLayout33, disable_layout, disable_right_layout;
    private LinearLayout end_layout, start_layout, bottom_layout, linearLayout3, linearLayout1, linearLayout2;
    private String str_processStatus;
    private CircularProgress progressbar;
    private DateFormat sdf;
    private SalaryAttribute salaryAttribute;
    private boolean relativeLayout22_status, relativeLayout33_status, relativeLayout44_status = false;
    private ArrayList<CarDailyEventList> carDailyEventList;
    private List<DailyEventList> dailyEventLists;
    private List<HalfPathInfoList> gpsHalfPathInfoList;
    private ScrollView main_layout;
    private CardView shift_layout, changeShift_layout, relativeLayout44, card_left, card_right;
    private boolean showCaseViewFirFirst = false;
    private ImageView img_progress;
    private RecyclerView event_recyclerView, halfPath_recyclerView, recycler_view;
    private BarChart chart;
    private BarData barData;
    private DateConvertor dateConvertor = new DateConvertor();
    private CircularProgressView waitProgress;
    private int carDailyInfoId = 0;
    private Driver driver;
    private List<CarSACommentList> carSACommentList;

    public WeekDayFragment() {

    }

    @SuppressLint("NewApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup rootView, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dayview_layout_test, rootView, false);

        persianDate = new PersianDate();
        sharedData = Globals.getInstance();

        sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        EventBus.getDefault().post(new EventBusModel("WeekDayFragment"));

        CarApplication application = (CarApplication) getActivity().getApplication();
        driver = application.getCurrentUser();
        // if (sharedData.getSelectedMenuItem() != null && sharedData.getSelectedMenuItem().equals(Constant.ACTION_DAY)) {

        if (sharedData.getYear() != 0 && sharedData.getMonth() != 0 && sharedData.getDay() != 0) {
            year = sharedData.getYear();
            month = sharedData.getMonth();
            day = sharedData.getDay();

        } else {
            year = dateConvertor.getIranianYear();
            month = dateConvertor.getIranianMonth();
            day = dateConvertor.getIranianDay();

            sharedData.setYear(year);
            sharedData.setMonth(month);
            sharedData.setDay(day);
        }

           /* if (!CarApplication.getInstance().getSharedPreferences().getBoolean(Constants.PREF_GOTO_SETTING, false)) {
                Fragment fragment = new PrivacyFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                Util.recognizeSelectedItems(Constant.RECOGNIZE, "PrivacyFragment");
            }*/


        img_status = view.findViewById(R.id.img_status);
        card_right = view.findViewById(R.id.card_right);
        card_left = view.findViewById(R.id.card_left);
        img_back = view.findViewById(R.id.img_back);
        img_progress = view.findViewById(R.id.img_progress);
        chart = view.findViewById(R.id.chart);
        btnListFab = view.findViewById(R.id.btnListFab);

        Glide.with(this)
                .load(R.raw.myanimation)
                .into(img_progress);

        RelativeLayout relativeLayout2 = view.findViewById(R.id.relativeLayout2);
        RelativeLayout relativeLayout3 = view.findViewById(R.id.relativeLayout3);
        RelativeLayout relativeLayout4 = view.findViewById(R.id.relativeLayout4);
        relativeLayout22 = view.findViewById(R.id.relativeLayout22);
        relativeLayout33 = view.findViewById(R.id.relativeLayout33);
        relativeLayout44 = view.findViewById(R.id.relativeLayout44);
        disable_layout = view.findViewById(R.id.disable_layout);
        disable_right_layout = view.findViewById(R.id.disable_right_layout);
        main_layout = view.findViewById(R.id.main_layout);
        bottom_layout = view.findViewById(R.id.bottom_layout);
        linearLayout1 = view.findViewById(R.id.linearLayout1);
        linearLayout2 = view.findViewById(R.id.linearLayout2);
        linearLayout3 = view.findViewById(R.id.linearLayout3);
        event_recyclerView = view.findViewById(R.id.event_recyclerView);
        event_recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        halfPath_recyclerView = view.findViewById(R.id.halfPath_recyclerView);
        halfPath_recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        main_layout.setVisibility(GONE);
        bottom_layout.setVisibility(GONE);


        shift_layout = view.findViewById(R.id.shift_layout);
        changeShift_layout = view.findViewById(R.id.changeShift_layout);
        showEmptyMessage = view.findViewById(R.id.showEmpty_txt);

        txt_halfPathAcpt = view.findViewById(R.id.txt_halfPathAcpt);
        txt_timeMinWorkInLine = view.findViewById(R.id.txt_timeMinWorkInLine);
        txt_kmInLineFV = view.findViewById(R.id.txt_kmInLineFV);
        txt_kmAll = view.findViewById(R.id.txt_kmAll);
        txt_countEtPass = view.findViewById(R.id.txt_countEtPass);
        txt_priceEtPass = view.findViewById(R.id.txt_priceEtPass);
        txt_countEtCash = view.findViewById(R.id.txt_countEtCash);
        txt_priceEtCash = view.findViewById(R.id.txt_priceEtCash);
        txt_etCardNo = view.findViewById(R.id.txt_etCardNo);
        txt_priceEtSumFV = view.findViewById(R.id.txt_priceEtSumFV);
        txt_priceSubDF_2 = view.findViewById(R.id.txt_priceSubDF_2);
        txt_showEmpty1 = view.findViewById(R.id.txt_showEmpty1);
        txt_showEmpty2 = view.findViewById(R.id.txt_showEmpty2);
        txt_driverStatus = view.findViewById(R.id.txt_driverStatus);

        img_change1 = view.findViewById(R.id.img_change1);
        img_change2 = view.findViewById(R.id.img_change2);
        img_change3 = view.findViewById(R.id.img_change3);
        img_change4 = view.findViewById(R.id.img_change4);


        img_fab1 = view.findViewById(R.id.img_fab1);
        img_fab2 = view.findViewById(R.id.img_fab2);
        img_fab3 = view.findViewById(R.id.img_fab3);
        progressbar = view.findViewById(R.id.progressbar);

        isDeviceDateTimeValid(this.year, this.month, this.day);

        /*
         * set date for current day
         * */
        Date date = new Date();
        roozh.PersianToGregorian(year, month, day);
        calendar.set(roozh.getYear(), roozh.getMonth(), roozh.getDay() +1);
        calendar.add(Calendar.MONTH, -1);
        Date date12 = calendar.getTime();

        if (Util.compareDates(date, date12) == 0) {
            TextView showDateName = (TextView) ((Activity) getContext()).findViewById(R.id.showDateName_txt);
            showDateName.setText("امروز" + " , " + persianDate.dayName(year, month, day));
        } else {
            TextView showDateName = (TextView) ((Activity) getContext()).findViewById(R.id.showDateName_txt);
            showDateName.setText(persianDate.dayName(year, month, day));
        }

        gap.com.car.gapcalendar.persianweekview.PersianCalendar persianCalendar1 =
                new gap.com.car.gapcalendar.persianweekview.PersianCalendar(roozh.getYear(), roozh.getMonth(), roozh.getDay());

        int day = persianCalendar1.getIranianDay();
        int month = persianCalendar1.getIranianMonth();
        String monthName = CommonMethod.convertLessThanOneThousand(month);
        int year = persianCalendar1.getIranianYear();
        sharedData.setDayMenuTitle(day + " " + monthName + " " + year);
        TextView txtView = ((Activity) getContext()).findViewById(R.id.spinner_txt);
        txtView.setText(Util.faToEn(day + " " + monthName + " " + year));


        relativeLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!relativeLayout22_status) {
                    relativeLayout22.setVisibility(VISIBLE);
                    relativeLayout22_status = true;
                    img_fab1.setBackgroundResource(R.drawable.arrow_up);

                } else {

                    relativeLayout22.setVisibility(GONE);
                    relativeLayout22_status = false;
                    img_fab1.setBackgroundResource(R.drawable.arrow_down);
                }
            }
        });

        relativeLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!relativeLayout33_status) {
                    relativeLayout33.setVisibility(VISIBLE);
                    relativeLayout33_status = true;
                    img_fab2.setBackgroundResource(R.drawable.arrow_up);

                } else {
                    relativeLayout33.setVisibility(GONE);
                    relativeLayout33_status = false;
                    img_fab2.setBackgroundResource(R.drawable.arrow_down);
                }
            }
        });

        relativeLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!relativeLayout44_status) {
                    relativeLayout44.setVisibility(VISIBLE);
                    //loadChart();
                    relativeLayout44_status = true;
                    img_fab3.setBackgroundResource(R.drawable.arrow_up);

                } else {
                    relativeLayout44.setVisibility(GONE);
                    relativeLayout44_status = false;
                    img_fab3.setBackgroundResource(R.drawable.arrow_down);
                }
            }
        });


        card_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previousCalendarDate();
                getActivity().overridePendingTransition(R.anim.left_in, R.anim.right_out);
            }
        });


        card_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextCalendarDate();
                getActivity().overridePendingTransition(R.anim.left_out, R.anim.right_in);
            }
        });


        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMonthlyFragment();
            }
        });


        btnListFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("carDailyInfoId=====" + carDailyInfoId);
                showDetailDialog();
            }
        });

        return view;
    }


    public void showDetailDialog() {
        final Dialog dialog_wait = new Dialog(getActivity(), R.style.Theme_Dialog);
        dialog_wait.setContentView(R.layout.custom_dialog_description_list);
        dialog_wait.show();
        dialog_wait.setCancelable(false);
        Window window = dialog_wait.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        window.setGravity(Gravity.CENTER);

        LinearLayout layout_add = dialog_wait.findViewById(R.id.layout_add);
        ImageView img_close = dialog_wait.findViewById(R.id.img_close);
        waitProgress = dialog_wait.findViewById(R.id.waitProgress);
        txt_null = dialog_wait.findViewById(R.id.txt_null);
        recycler_view = dialog_wait.findViewById(R.id.recycler_view);

        // getComments();

        layout_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (carDailyInfoId != 0) {
                    showAddDialog();
                }
            }
        });

        img_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_wait.dismiss();
            }
        });

        recycler_view.setLayoutManager(new LinearLayoutManager(getActivity()));
        //recycler_view.setAdapter();
    }


    public void showAddDialog() {
        final Dialog dialog_wait = new Dialog(getActivity(), R.style.Theme_Dialog);
        dialog_wait.setContentView(R.layout.show_add_dialog);
        dialog_wait.show();
        dialog_wait.setCancelable(false);
        Window window = dialog_wait.getWindow();
        window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.CENTER);

        final EditText comment = dialog_wait.findViewById(R.id.comment);
        TextView btn_send = dialog_wait.findViewById(R.id.btn_send);
        ImageView img_close = dialog_wait.findViewById(R.id.img_close);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!comment.getText().toString().isEmpty()) {

                    System.out.println("driver====" + driver.getUsername());
                    System.out.println("driver====" + driver.getPassword());
                    System.out.println("carDailyInfoId====" + carDailyInfoId);
                    if (driver == null)
                        return;

                    ServerCoordinator.getInstance().saveCarSAComment(driver.getUsername(), driver.getPassword(), carDailyInfoId, comment.getText().toString(),
                            new Response.Listener<UpdateVersionResponseBean>() {
                                @Override
                                public void onResponse(UpdateVersionResponseBean response) {
                                    if (response.getsUCCESS() != null) {
                                        Utils.showToast(getActivity(), R.string.success_comment_sent, false);
                                        // getComments();
                                        dialog_wait.dismiss();
                                    } else {
                                        Utils.showToast(getActivity(), R.string.error_unknown, false);
                                    }

                                }

                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Utils.showErrors(getActivity(), error);
                                }
                            });
                } else {
                    Utils.showToast(getActivity(), R.string.label_comment_editText_warning, false);
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

    private void loadChart() {
        ArrayList NoOfEmp = new ArrayList();

        NoOfEmp.add(new BarEntry(5f, 0));
        NoOfEmp.add(new BarEntry(1f, 1));
        NoOfEmp.add(new BarEntry(2f, 2));
        NoOfEmp.add(new BarEntry(6f, 3));
        NoOfEmp.add(new BarEntry(12f, 4));
        NoOfEmp.add(new BarEntry(15f, 5));
        NoOfEmp.add(new BarEntry(20f, 6));
        NoOfEmp.add(new BarEntry(8f, 7));
        NoOfEmp.add(new BarEntry(21f, 8));
        NoOfEmp.add(new BarEntry(10f, 9));
        NoOfEmp.add(new BarEntry(8f, 10));
        NoOfEmp.add(new BarEntry(7f, 11));
        NoOfEmp.add(new BarEntry(9f, 12));
        NoOfEmp.add(new BarEntry(5f, 13));
        NoOfEmp.add(new BarEntry(6f, 14));
        NoOfEmp.add(new BarEntry(3f, 15));
        NoOfEmp.add(new BarEntry(5f, 16));

        ArrayList year1 = new ArrayList();

        year1.add("07:00");
        year1.add("08:00");
        year1.add("09:00");
        year1.add("10:00");
        year1.add("11:00");
        year1.add("12:00");
        year1.add("13:00");
        year1.add("14:00");
        year1.add("15:00");
        year1.add("16:00");
        year1.add("17:00");
        year1.add("18:00");
        year1.add("19:00");
        year1.add("20:00");
        year1.add("21:00");
        year1.add("22:00");
        year1.add("23:00");

        BarDataSet bardataset = new BarDataSet(NoOfEmp, "");
        chart.animateY(3000);
        chart.getLegend().setEnabled(false);
        XAxis xAxis = chart.getXAxis();
        xAxis.setTypeface(CarApplication.getInstance().getPersianTypeFace());
        xAxis.setTextColor(getResources().getColor(R.color.colorPrimary));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setLabelRotationAngle(-90f);
        xAxis.setTextSize(14f);
        xAxis.setDrawGridLines(false);
        xAxis.setAxisLineColor(getResources().getColor(android.R.color.transparent));
        xAxis.setSpaceBetweenLabels(1);

        YAxis yAxis = chart.getAxisLeft();
        YAxis rightYAxis = chart.getAxisRight();
        rightYAxis.setEnabled(false);
        yAxis.setEnabled(false);
        yAxis.setTypeface(CarApplication.getInstance().getPersianTypeFace());
        yAxis.setTextColor(getResources().getColor(R.color.colorPrimary));
        yAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        yAxis.setGridColor(getResources().getColor(R.color.colorPrimary));
        yAxis.setDrawGridLines(false);
        yAxis.setTextSize(14f);
        yAxis.setZeroLineColor(getResources().getColor(android.R.color.transparent));

        bardataset.setColor(getResources().getColor(R.color.light_green));
        BarData data = new BarData(year1, bardataset);
        data.setValueFormatter(new MyValueFormatter());
        data.setValueTypeface(CarApplication.getInstance().getPersianTypeFace());
        data.setValueTextSize(12f);
        chart.setDescription("");
        chart.setData(data);
    }

    public void getComments() {

        if (waitProgress != null) {
            waitProgress.setVisibility(VISIBLE);
        }

        carSACommentList = new ArrayList<>();

        if (driver == null)
            return;

        System.out.println("driver.getUsername()" + driver.getUsername());
        System.out.println("driver.getUsername()" + driver.getPassword());
        System.out.println("getCommentscarDailyInfoId" + carDailyInfoId);

        ServerCoordinator.getInstance().getCarSACommentList(driver.getUsername(), driver.getPassword(), String.valueOf(carDailyInfoId),
                new Response.Listener<DriverProfileModel>() {
                    @Override
                    public void onResponse(DriverProfileModel response) {
                        if (waitProgress != null) {
                            waitProgress.setVisibility(View.GONE);
                        }

                        carSACommentList = response.getrESULT().driverSACommentList;
                        if (carSACommentList != null) {
                            recycler_view.setAdapter(new CommentListAdapter(driver, carSACommentList, getActivity(), WeekDayFragment.this));
                            if (carSACommentList.size() == 0) {
                                txt_null.setVisibility(VISIBLE);
                                // btnListFab.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.empty_list));
                                btnListFab.setBackgroundResource(R.drawable.empty_list);
                            } else {
                                txt_null.setVisibility(View.GONE);
                                //  btnListFab.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.full_list));
                                btnListFab.setBackgroundResource(R.drawable.full_list);
                            }

                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (waitProgress != null) {
                            waitProgress.setVisibility(View.GONE);
                        }

                    }
                });
    }


    public void getCommentsCopy() {

        carSACommentList = new ArrayList<>();

        if (driver == null)
            return;

        System.out.println("driver.getUsername()" + driver.getUsername());
        System.out.println("driver.getUsername()" + driver.getPassword());
        System.out.println("carDailyInfoId" + carDailyInfoId);

        ServerCoordinator.getInstance().getCarSACommentList(driver.getUsername(), driver.getPassword(), String.valueOf(carDailyInfoId),
                new Response.Listener<DriverProfileModel>() {
                    @Override
                    public void onResponse(DriverProfileModel response) {

                        carSACommentList = response.getrESULT().driverSACommentList;
                        if (carSACommentList != null) {
                            if (carSACommentList.size() == 0) {
                                btnListFab.setBackgroundResource(R.drawable.empty_list);
                            } else {
                                btnListFab.setBackgroundResource(R.drawable.full_list);
                            }

                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
    }


    /*
     *
     * previous date
     * */
    private void previousCalendarDate() {

        calendar.add(Calendar.DAY_OF_MONTH, -1);

        Date date12 = calendar.getTime();
        Date date = new Date();
        System.out.println("changeDay=" + date);
        System.out.println("changeDay=" + date12);
        Util.compareDates(date, date12);

        day = persianCalendar.getPersianDayOfMonth(calendar.getTime());
        month = persianCalendar.getPersianMonth(calendar.getTime());
        monthName = CommonMethod.convertLessThanOneThousand(month);
        year = persianCalendar.getPersianYear(calendar.getTime());
        sharedData.setDayMenuTitle(day + " " + monthName + " " + year);
        TextView txtView = ((Activity) getContext()).findViewById(R.id.spinner_txt);
        txtView.setText(Util.faToEn(day + " " + monthName + " " + year));
        sharedData.setYear(year);
        sharedData.setMonth(month);
        sharedData.setDay(day);

        if (Util.compareDates(getYesterdayDate(date), date12) == 0) {
            TextView showDateName = (TextView) ((Activity) getContext()).findViewById(R.id.showDateName_txt);
            showDateName.setText("دیروز" + " , " + persianDate.dayName(year, month, day));

        } else if (Util.compareDates(getTomorrowDate(date), date12) == 0) {
            TextView showDateName = (TextView) ((Activity) getContext()).findViewById(R.id.showDateName_txt);
            showDateName.setText("فردا" + " , " + persianDate.dayName(year, month, day));
        } else if (Util.compareDates(date, date12) == 0) {
            TextView showDateName = (TextView) ((Activity) getContext()).findViewById(R.id.showDateName_txt);
            showDateName.setText("امروز" + " , " + persianDate.dayName(year, month, day));
        } else {
            TextView showDateName = (TextView) ((Activity) getContext()).findViewById(R.id.showDateName_txt);
            showDateName.setText(persianDate.dayName(year, month, day));
        }

        isDeviceDateTimeValid(this.year, this.month, this.day);
    }


    /*
     *
     * next date
     * */
    private void nextCalendarDate() {

        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date date12 = calendar.getTime();
        Date date = new Date();
        System.out.println("changeDay=" + date);
        System.out.println("changeDay=" + date12);
        day = persianCalendar.getPersianDayOfMonth(calendar.getTime());
        month = persianCalendar.getPersianMonth(calendar.getTime());
        int dayName = persianCalendar.getPersianMonth(calendar.getTime());
        monthName = CommonMethod.convertLessThanOneThousand(month);
        year = persianCalendar.getPersianYear(calendar.getTime());
        sharedData.setDayMenuTitle(day + " " + monthName + " " + year);
        TextView txtView = ((Activity) getContext()).findViewById(R.id.spinner_txt);
        txtView.setText(Util.faToEn(day + " " + monthName + " " + year));
        sharedData.setYear(year);
        sharedData.setMonth(month);
        sharedData.setDay(day);

        if (Util.compareDates(getYesterdayDate(date), date12) == 0) {
            TextView showDateName = (TextView) ((Activity) getContext()).findViewById(R.id.showDateName_txt);
            showDateName.setText("دیروز" + " , " + persianDate.dayName(year, month, day));

        } else if (Util.compareDates(getTomorrowDate(date), date12) == 0) {
            TextView showDateName = (TextView) ((Activity) getContext()).findViewById(R.id.showDateName_txt);
            showDateName.setText("فردا" + " , " + persianDate.dayName(year, month, day));
        } else if (Util.compareDates(date, date12) == 0) {
            TextView showDateName = (TextView) ((Activity) getContext()).findViewById(R.id.showDateName_txt);
            showDateName.setText("امروز" + " , " + persianDate.dayName(year, month, day));
        } else {
            TextView showDateName = (TextView) ((Activity) getContext()).findViewById(R.id.showDateName_txt);
            showDateName.setText(persianDate.dayName(year, month, day));
        }

        isDeviceDateTimeValid(this.year, this.month, this.day);
    }

    // Method to get Yesterday Date
    public static Date getYesterdayDate(Date date) {

        Date yesterdayDate = null;

        if (date != null) {

            Calendar c = Calendar.getInstance();

            c.setTime(date); // Setting the today date

            c.add(Calendar.DATE, -1); // Decreasing 1 day

            yesterdayDate = c.getTime();
        }

        return yesterdayDate;
    }

    /*
     * Method to get tomorrow Date
     * */
    public static Date getTomorrowDate(Date date) {

        Date tomorrowDate = null;

        if (date != null) {

            Calendar c = Calendar.getInstance();

            c.setTime(date); // Setting the today date

            c.add(Calendar.DATE, 1); // Increasing 1 day

            tomorrowDate = c.getTime();

        }

        return tomorrowDate;
    }


    /*
     * navigation bottom button in day fragment
     * */
    /*public void init_persistent_bottomsheet() {
        persistentbottomSheet = coordinatorLayout.findViewById(R.id.bottomsheet);
        iv_trigger = (ImageView) persistentbottomSheet.findViewById(R.id.iv_fab);
        relativeLayout = (RelativeLayout) persistentbottomSheet.findViewById(R.id.relativeLayout);
        linearLayout = (LinearLayout) persistentbottomSheet.findViewById(R.id.linearLayout);
        final BottomSheetBehavior behavior = BottomSheetBehavior.from(persistentbottomSheet);


        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (behavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    linearLayout.setBackgroundResource(R.color.glass_white);
                } else {
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });

        if (behavior != null)
            behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                @Override
                public void onStateChanged(@NonNull View bottomSheet, int newState) {
                    //showing the different states
                    switch (newState) {
                        case BottomSheetBehavior.STATE_HIDDEN:
                            break;
                        case BottomSheetBehavior.STATE_EXPANDED:
                            iv_trigger.setBackgroundResource(R.drawable.negative_icon);
                            linearLayout.setBackgroundResource(R.color.glass_white);
                            break;
                        case BottomSheetBehavior.STATE_COLLAPSED:
                            iv_trigger.setBackgroundResource(R.drawable.plus_icon);
                            linearLayout.setBackgroundResource(0);
                            break;
                        case BottomSheetBehavior.STATE_DRAGGING:
                            linearLayout.setBackgroundResource(R.color.glass_white);
                            break;
                        case BottomSheetBehavior.STATE_SETTLING:
                            break;
                    }
                }

                @Override
                public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                    // React to dragging events

                }
            });
    }*/

    /*
     * get invalid date time and call monthly salary attribute with type 0
     * */
    private void isDeviceDateTimeValid(final int year, final int month, final int day) {
        final Roozh roozh = new Roozh();
        roozh.PersianToGregorian(year, month, day);

        // System.out.println("response=====" + response);
        /*int maxLogSize = 100000;
        for (int i = 0; i <= response.length() / maxLogSize; i++) {
            int start = i * maxLogSize;
            int end = (i + 1) * maxLogSize;
            end = end > response.length() ? response.length() : end;
            Log.v("response=====", response.substring(start, end));
        }*/

        EventBus.getDefault().post(new EventBusModel("WeekDayFragment"));

        if (driver != null) {
            final String username = driver.getUsername();
            final String password = driver.getPassword();
            final String fromDate = roozh.getYear() + "-" + roozh.getMonth() + "-" + roozh.getDay();
            System.out.println("fromDate=======" + fromDate);
            System.out.println("fromDate=======" + persianDate.getGrgYear()+"-"+persianDate.getGrgMonth()+"-"+persianDate.getGrgDay());
            progressbar.setVisibility(VISIBLE);
            img_progress.setVisibility(VISIBLE);
            main_layout.setVisibility(GONE);
            bottom_layout.setVisibility(GONE);

            showEmptyMessage.setVisibility(GONE);
            sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            //final String toDate = "";
            //final DriverProfileResponseBean driverProfileResponseBean = sharedData.getResponse();
            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATE_TIME_FORMAT);

            ServerCoordinator.getInstance().getServerDateTime(new Response.Listener<ServerDateTimeResponseBean>() {
                @Override
                public void onResponse(ServerDateTimeResponseBean response) {
                    progressbar.setVisibility(GONE);
                    img_progress.setVisibility(GONE);
                    try {
                        Date serverDateTime = simpleDateFormat.parse(response.getRESULT().getServerDateTime());
                        if (DateUtils.isValidDateDiff(new Date(), serverDateTime, Constants.VALID_SERVER_AND_DEVICE_TIME_DIFF)) {
                            progressbar.setVisibility(VISIBLE);
                            img_progress.setVisibility(VISIBLE);
                            main_layout.setVisibility(GONE);
                            bottom_layout.setVisibility(GONE);
                            disable_right_layout.setVisibility(GONE);
                            disable_layout.setVisibility(GONE);
                            card_right.setEnabled(true);
                            card_left.setEnabled(true);
                            ServerCoordinator.getInstance().getCarDailyInfo(username, password, String.valueOf(driver.getCarId()), fromDate,
                                    new Response.Listener<SuccessResponseCarInvoice>() {
                                        @RequiresApi(api = Build.VERSION_CODES.O)
                                        @SuppressLint("SetTextI18n")
                                        @Override
                                        public void onResponse(SuccessResponseCarInvoice response) {

                                            int currentMonth = persianDate.getShMonth();
                                            int currentDay = persianDate.getShDay();
                                            int count = 0;
                                            System.out.println("currentMonth1======" + currentMonth);
                                            System.out.println("currentMonth2======" + month);

                                            if (currentMonth == month && currentDay == day) {
                                                disable_layout.setVisibility(VISIBLE);
                                                card_left.setEnabled(false);
                                            }
                                            for (int i = month; i < currentMonth; i++) {
                                                count++;
                                            }
                                            System.out.println("count======" + count);

                                            LocalDate jamesBirthDay = new LocalDate(roozh.getYear(), roozh.getMonth(), roozh.getDay());
                                            LocalDate now = new LocalDate(persianDate.getGrgYear(), persianDate.getGrgMonth(), persianDate.getGrgDay());

                                            int monthsBetween = Months.monthsBetween(jamesBirthDay, now).getMonths();
                                            int yearsBetween = Years.yearsBetween(jamesBirthDay, now).getYears();
                                            int dayBetween = Days.daysBetween(jamesBirthDay, now).getDays();

                                            System.out.println("monthsBetween==" + monthsBetween);
                                            System.out.println("yearsBetween==" + yearsBetween);
                                            System.out.println("dayBetween==" + dayBetween);

                                            if (monthsBetween == 6){
                                                card_right.setEnabled(false);
                                                disable_right_layout.setVisibility(VISIBLE);
                                            }

                                            if (response.getCarDailyInfo() != null) {

                                                //getCommentsCopy();

                                                showEmptyMessage.setVisibility(GONE);
                                                progressbar.setVisibility(GONE);
                                                img_progress.setVisibility(GONE);
                                                main_layout.setVisibility(VISIBLE);
                                                bottom_layout.setVisibility(VISIBLE);

                                                // carDailyInfoId = response.getCarDailyInfo().getId();

                                                System.out.println("getCarDailyInfo=====" + response.getCarDailyInfo().getHalfPathAcpt());
                                                if (response.getCarDailyInfo().getHalfPathAcpt() != null) {
                                                    txt_halfPathAcpt.setText(response.getCarDailyInfo().getHalfPathAcpt() + "");
                                                } else {
                                                    txt_halfPathAcpt.setText("-");
                                                }

                                                if (response.getCarDailyInfo().getTimeMinWorkInLine() != null) {
                                                    txt_timeMinWorkInLine.setText(Util.formatHoursAndMinutes(Integer.parseInt(response.getCarDailyInfo().getTimeMinWorkInLine())) + " ساعت ");
                                                } else {
                                                    txt_timeMinWorkInLine.setText("-");
                                                }

                                                if (response.getCarDailyInfo().getKmInLineFV() != null) {
                                                    txt_kmInLineFV.setText(response.getCarDailyInfo().getKmInLineFV() + "");
                                                } else {
                                                    txt_kmInLineFV.setText("-");
                                                }

                                                if (response.getCarDailyInfo().getKmAll() != null) {
                                                    txt_kmAll.setText(response.getCarDailyInfo().getKmAll() + "");
                                                } else {
                                                    txt_kmAll.setText("-");
                                                }

                                                if (response.getCarDailyInfo().getCountEtPass() != null) {
                                                    txt_countEtPass.setText(response.getCarDailyInfo().getCountEtPass() + "");
                                                } else {
                                                    txt_countEtPass.setText("-");
                                                }


                                                if (response.getCarDailyInfo().getPriceEtPass() != null) {
                                                    txt_priceEtPass.setText(Util.addCommasToNumericString(response.getCarDailyInfo().getPriceEtPass()));
                                                } else {
                                                    txt_priceEtPass.setText(0 + "");
                                                }

                                                if (response.getCarDailyInfo().getCountEtCash() != null) {
                                                    txt_countEtCash.setText(response.getCarDailyInfo().getCountEtCash() + "");
                                                } else {
                                                    txt_countEtCash.setText("-");
                                                }


                                                if (response.getCarDailyInfo().getPriceEtCash() != null) {
                                                    txt_priceEtCash.setText(Util.addCommasToNumericString(response.getCarDailyInfo().getPriceEtCash()));
                                                } else {
                                                    txt_priceEtCash.setText("-");
                                                }

                                                if (response.getCarDailyInfo().getEtCardNo() != null) {
                                                    txt_etCardNo.setText(response.getCarDailyInfo().getEtCardNo() + "");
                                                } else {
                                                    txt_etCardNo.setText("-");
                                                }


                                                if (response.getCarDailyInfo().getPriceEtSumFV() != null) {
                                                    txt_priceEtSumFV.setText(Util.addCommasToNumericString(response.getCarDailyInfo().getPriceEtSumFV()));
                                                } else {
                                                    txt_priceEtSumFV.setText(0 + "");
                                                }

                                                if (response.getCarDailyInfo().getPriceSubDF_2() != null) {
                                                    txt_priceSubDF_2.setText(Util.addCommasToNumericString(response.getCarDailyInfo().getPriceSubDF_2()));
                                                } else {
                                                    txt_priceSubDF_2.setText("-");
                                                }

                                                if (response.getCarDailyInfo().getDailyEventList() != null) {
                                                    dailyEventLists = response.getCarDailyInfo().getDailyEventList();
                                                    System.out.println("=====size=======" + dailyEventLists.size());
                                                    if (dailyEventLists != null) {
                                                        event_recyclerView.setAdapter(new CarDailyEventListAdapter(getActivity(), (ArrayList<DailyEventList>) dailyEventLists));
                                                        txt_showEmpty1.setVisibility(GONE);
                                                    } else {
                                                        txt_showEmpty1.setVisibility(VISIBLE);
                                                    }
                                                }

                                                if (response.getCarDailyInfo().getProcessStatus_text() != null) {
                                                    txt_driverStatus.setText(response.getCarDailyInfo().getProcessStatus_text());
                                                }


                                                if (response.getCarDailyInfo().getGpsHalfPathInfoList() != null) {
                                                    gpsHalfPathInfoList = response.getCarDailyInfo().getGpsHalfPathInfoList();
                                                    if (gpsHalfPathInfoList != null) {
                                                        halfPath_recyclerView.setAdapter(new HalfPathListAdapter(getActivity(), (ArrayList<HalfPathInfoList>) gpsHalfPathInfoList));
                                                        txt_showEmpty2.setVisibility(GONE);
                                                    } else {
                                                        txt_showEmpty2.setVisibility(VISIBLE);
                                                    }
                                                }


                                            }

                                            showEmptyMessage.setVisibility(GONE);
                                            progressbar.setVisibility(GONE);
                                            img_progress.setVisibility(GONE);
                                            main_layout.setVisibility(VISIBLE);
                                            bottom_layout.setVisibility(VISIBLE);
                                            txt_showEmpty2.setVisibility(GONE);
                                            txt_showEmpty2.setVisibility(GONE);

                                            showCaseViewFirFirst = CarApplication.getInstance().getSharedPreferences().getBoolean(Constants.WDF_SHOW_CASE_VIEW_FOR_FIRST, false);
                                            if (showCaseViewFirFirst) {
                                                SharedPreferences.Editor editor = CarApplication.getInstance().getSharedPreferences().edit();
                                                editor.putBoolean(Constants.WDF_SHOW_CASE_VIEW_FOR_FIRST, false);
                                                editor.apply();
                                                backShowcaseView(getActivity(), img_back);
                                            }

                                            // txt_showEmpty1.setVisibility(View.GONE);
                                            //txt_showEmpty2.setVisibility(View.GONE);

                                    /*        progressbar.setVisibility(View.GONE);
                                            img_progress.setVisibility(View.GONE);
                                            main_layout.setVisibility(VISIBLE);
                                            bottom_layout.setVisibility(VISIBLE);

                                            salaryAttribute = response.getSalaryAttribute();
                                            if (salaryAttribute != null) {

                                                showEmptyMessage.setVisibility(View.GONE);


                                                if (salaryAttribute.getDriverDailyActivity() != null) {


                                                    // txt_showEmpty1.setVisibility(View.GONE);
                                                    //txt_showEmpty2.setVisibility(View.GONE);
                                                }

                                                if (salaryAttribute.getDriverDailyActivity() != null) {

                                                    carDailyEventList = (ArrayList<CarDailyEventList>) salaryAttribute.getDriverDailyActivity().getCarDailyEventList();
                                                    recyclerView1.setAdapter(new CarDailyEventListAdapter(getActivity(), carDailyEventList));

                                                    dailyEventListOlds = (ArrayList<DailyEventListOld>) salaryAttribute.getDriverDailyActivity().getDailyEventListOld();
                                                    recyclerView2.setAdapter(new DriverDailyActivityListAdapter(getActivity(), dailyEventListOlds));

                                                    if (dailyEventListOlds != null) {
                                                        txt_showEmpty1.setVisibility(View.GONE);
                                                    } else {
                                                        txt_showEmpty1.setVisibility(VISIBLE);
                                                    }

                                                    if (carDailyEventList != null) {
                                                        txt_showEmpty2.setVisibility(View.GONE);
                                                    } else {
                                                        txt_showEmpty2.setVisibility(VISIBLE);
                                                    }

                                                    DriverDailyActivity driverDailyActivity = salaryAttribute.getDriverDailyActivity();

                                                    txt_company.setText(driverDailyActivity.getCompanyProfit().getNameFv());

                                                    if (driverDailyActivity.isCompanyIsChangedFV()) {
                                                        txt_companyChanged.setVisibility(VISIBLE);
                                                        // img_change1.setVisibility(VISIBLE);
                                                        txt_companyChanged.setText(driverDailyActivity.getCompanyChangedFV().getName());
                                                    } else {
                                                        txt_companyChanged.setVisibility(View.INVISIBLE);
                                                        img_change1.setVisibility(View.INVISIBLE);
                                                    }

                                                    int shiftType = driverDailyActivity.getShiftTypeEn();
                                                   *//* switch (shiftType) {
                                                        case 0:
                                                            //str_shiftType = getResources().getString(R.string.label_shiftType_Morning);
                                                            break;

                                                        case 1:
                                                            //str_shiftType = getResources().getString(R.string.label_shiftType_Afternoon);
                                                            break;

                                                        case 2:
                                                            //str_shiftType = getResources().getString(R.string.label_shiftType_Night);
                                                            break;

                                                        case 3:
                                                            //str_shiftType = getResources().getString(R.string.label_shiftType_Other);
                                                            break;

                                                        case 4:
                                                            // str_shiftType = getResources().getString(R.string.label_shiftType_General);
                                                            break;

                                                        case 5:
                                                            //str_shiftType = getResources().getString(R.string.label_shiftType_MidDay);
                                                            break;
                                                    }*//*
                                                    txt_shift.setText(driverDailyActivity.getDriverShiftPlanStrFV());

                                                    if (driverDailyActivity.isDriverShiftPlanIsChangedFV()) {
                                                        txt_shiftChanged.setVisibility(VISIBLE);
                                                        //img_change2.setVisibility(VISIBLE);
                                                        txt_shiftChanged.setText(driverDailyActivity.getDriverShiftChangedStrFV());
                                                    } else {
                                                        txt_shiftChanged.setVisibility(View.INVISIBLE);
                                                        img_change2.setVisibility(View.INVISIBLE);
                                                    }


                                                    txt_car.setText(driverDailyActivity.getCarPlanStrFV());
                                                    if (driverDailyActivity.isCarPlanIsChangedFV()) {
                                                        txt_carChanged.setVisibility(VISIBLE);
                                                        //img_change3.setVisibility(VISIBLE);
                                                        txt_carChanged.setText(driverDailyActivity.getCarChangedStrFV());
                                                    } else {
                                                        txt_carChanged.setVisibility(View.INVISIBLE);
                                                        img_change3.setVisibility(View.INVISIBLE);
                                                    }


                                                    txt_line.setText(driverDailyActivity.getLinePlanStrFV());
                                                    if (driverDailyActivity.isLinePlanIsChangedFV() && !driverDailyActivity.getLineChangedStrFV().equals("---")) {
                                                        txt_lineChanged.setVisibility(VISIBLE);
                                                        //img_change4.setVisibility(VISIBLE);
                                                        txt_lineChanged.setText(driverDailyActivity.getLineChangedStrFV());
                                                    } else {
                                                        txt_lineChanged.setVisibility(View.INVISIBLE);
                                                        img_change4.setVisibility(View.INVISIBLE);
                                                    }

                                                    List<DriverEDAList> driverEDALists = new ArrayList<>();
                                                    if (driverDailyActivity.getDriverEDAList() != null) {
                                                        for (DriverEDAList driverEDAList : driverDailyActivity.getDriverEDAList()) {
                                                            if (driverEDAList != null) {
                                                                driverEDALists.add(driverEDAList);
                                                                shift_layout.setVisibility(VISIBLE);
                                                            }
                                                        }

                                                        recycler_view.setAdapter(new DriverShiftListAdapter(getActivity(), driverEDALists));
                                                    } else {
                                                        shift_layout.setVisibility(View.GONE);
                                                    }

                                                    List<DriverChangedEDAList> driverChangedEDALists = new ArrayList<>();
                                                    if (driverDailyActivity.getDriverChangedEDALists() != null) {
                                                        for (DriverChangedEDAList driverChangedEDAList : driverDailyActivity.getDriverChangedEDALists()) {
                                                            if (driverChangedEDAList != null) {
                                                                driverChangedEDALists.add(driverChangedEDAList);
                                                                changeShift_layout.setVisibility(VISIBLE);
                                                            }
                                                        }

                                                        changeRecycler_view.setAdapter(new DriverChangeShiftListAdapter(getActivity(), driverChangedEDALists));
                                                    } else {
                                                        changeShift_layout.setVisibility(View.GONE);
                                                    }

                                                    int driverJobType = driverDailyActivity.getDriverJobTypeEn();
                                                   *//* switch (driverJobType) {
                                                        case 0:
                                                            //str_driverJobType = getResources().getString(R.string.label_driverJobTypeEn_DetermineCarForDriver);
                                                            break;

                                                        case 1:
                                                            //str_driverJobType = getResources().getString(R.string.label_driverJobTypeEn_RotatoryDriverInLine);
                                                            break;

                                                        case 2:
                                                            // str_driverJobType = getResources().getString(R.string.label_driverJobTypeEn_DriverInParking);
                                                            break;

                                                        case 3:
                                                            // str_driverJobType = getResources().getString(R.string.label_driverJobTypeEn_RescuerSOS);
                                                            break;

                                                        case 4:
                                                            // str_driverJobType = getResources().getString(R.string.label_driverJobTypeEn_AssistantRescuerSOS);
                                                            break;

                                                        case 5:
                                                            //str_driverJobType = getResources().getString(R.string.label_driverJobTypeEn_WorkOnContract);
                                                            break;
                                                    }*//*

                                                    linearLayout1.setVisibility(VISIBLE);
                                                    linearLayout2.setVisibility(View.VISIBLE);
                                                    linearLayout3.setVisibility(View.VISIBLE);
                                                    disable_layout.setVisibility(View.GONE);
                                                    disable_right_layout.setVisibility(View.GONE);
                                                    card_left.setEnabled(true);
                                                    card_right.setEnabled(true);

                                                    int processStatus = driverDailyActivity.getProcessStatus();
                                                    boolean b = CarApplication.getInstance().getSharedPreferences().getBoolean("firstLogin", false);

                                                    SimpleDateFormat sdformat = new SimpleDateFormat("yyyy/MM/dd");
                                                    try {
                                                        Date d1 = sdformat.parse(sdformat.format(new Date()));
                                                        Date d2 = sdformat.parse(salaryAttribute.getDate());

                                                        String firstDate = CalendarUtil.convertPersianDateTime(d1, "yyyy/MM/dd");
                                                        String[] separated1 = firstDate.split("/");
                                                        String year1 = separated1[0];
                                                        String month1 = separated1[1];
                                                        String day1 = separated1[2];
                                                        System.out.println("=-=-=-=-=-=-" + year1 + "/" + month1 + "/" + day1);

                                                        String secondDate = CalendarUtil.convertPersianDateTime(d2, "yyyy/MM/dd");
                                                        String[] secondDate2 = secondDate.split("/");
                                                        String year2 = secondDate2[0];
                                                        String month2 = secondDate2[1];
                                                        String day2 = secondDate2[2];
                                                        System.out.println("=-=-=-=-=-=-" + year2 + "/" + month2 + "/" + day2);

                                                        if (Integer.parseInt(year1) == Integer.parseInt(year2) && (Integer.parseInt(month1) - Integer.parseInt(month2) == 2)
                                                                || Integer.parseInt(year1) > Integer.parseInt(year2) && (Integer.parseInt(month2) == 12) && Integer.parseInt(day2) == 1) {
                                                            card_right.setEnabled(false);
                                                            disable_right_layout.setVisibility(VISIBLE);
                                                        }

                                                        if (d1 != null && d1.compareTo(d2) == 0) {
                                                            // disable_layout.setVisibility(VISIBLE);
                                                            linearLayout3.setVisibility(View.GONE);
                                                            card_left.setEnabled(false);
                                                            if (processStatus != 9) {

                                                            }
                                                        }
                                                    } catch (ParseException e) {
                                                        e.printStackTrace();
                                                    }


                                                    start_layout.setVisibility(VISIBLE);
                                                    end_layout.setVisibility(VISIBLE);
                                                    try {
                                                        switch (processStatus) {
                                                            case 5:
                                                                str_processStatus = getResources().getString(R.string.label_ProcessStatus_State1);
                                                                linearLayout1.setVisibility(View.GONE);
                                                                linearLayout2.setVisibility(View.GONE);
                                                                break;

                                                            case 8:
                                                                str_processStatus = getResources().getString(R.string.label_ProcessStatus_State4);
                                                                start_layout.setVisibility(View.GONE);
                                                                end_layout.setVisibility(View.GONE);
                                                                linearLayout1.setVisibility(View.GONE);
                                                                linearLayout2.setVisibility(View.GONE);
                                                                break;

                                                            case 9:
                                                                str_processStatus = getResources().getString(R.string.label_ProcessStatus_State5);

                                                                break;

                                                            case 10:
                                                                str_processStatus = getResources().getString(R.string.label_ProcessStatus_State6);
                                                                linearLayout1.setVisibility(View.GONE);
                                                                linearLayout2.setVisibility(View.GONE);
                                                                break;

                                                            case 20:
                                                                str_processStatus = getResources().getString(R.string.label_ProcessStatus_State7);
                                                                linearLayout1.setVisibility(View.GONE);
                                                                linearLayout2.setVisibility(View.GONE);
                                                                break;

                                                            case 21:
                                                                str_processStatus = getResources().getString(R.string.label_ProcessStatus_State8);
                                                                break;

                                                            case 22:
                                                                str_processStatus = getResources().getString(R.string.label_ProcessStatus_State9);
                                                                break;

                                                            case 24:
                                                                str_processStatus = getResources().getString(R.string.label_ProcessStatus_State11);
                                                                start_layout.setVisibility(View.GONE);
                                                                end_layout.setVisibility(View.GONE);
                                                                linearLayout1.setVisibility(View.GONE);
                                                                linearLayout2.setVisibility(View.GONE);
                                                                break;

                                                            case 25:
                                                                str_processStatus = getResources().getString(R.string.label_ProcessStatus_State12);
                                                                linearLayout1.setVisibility(View.GONE);
                                                                linearLayout2.setVisibility(View.GONE);
                                                                break;

                                                            case 50:
                                                                str_processStatus = getResources().getString(R.string.label_ProcessStatus_State50);
                                                                linearLayout1.setVisibility(View.GONE);
                                                                linearLayout2.setVisibility(View.GONE);
                                                                break;

                                                            case 27:
                                                                str_processStatus = getResources().getString(R.string.label_ProcessStatus_EmployeeDuty);
                                                                linearLayout1.setVisibility(View.GONE);
                                                                linearLayout2.setVisibility(View.GONE);
                                                                break;
                                                        }
                                                    } catch (Exception e) {
                                                        e.getMessage();
                                                    }

                                                    if (str_processStatus != null) {
                                                        txt_driverStatus.setText(str_processStatus);
                                                    }

                                                   *//* if (salaryAttribute.getProcessStatus().equals(5)) {
                                                        //منتظر ورود
                                                        //txt_status.setText("منتظر ورود");
                                                        img_status.setBackgroundResource(R.drawable.waiting_driver_icon);
                                                    }

                                                    if (salaryAttribute.getProcessStatus().equals(10)) {
                                                        //عدم مراجعه
                                                        //txt_status.setText("عدم مراجعه");
                                                        //img_status.setBackgroundResource(R.drawable.deliverd);
                                                    }

                                                    if (salaryAttribute.getProcessStatus().equals(20)) {
                                                        //فاقد برنامه
                                                        //txt_status.setText("فاقد برنامه");
                                                        img_status.setBackgroundResource(R.drawable.deliverd);
                                                    }

                                                    if (salaryAttribute.getProcessStatus().equals(25)) {
                                                        //عدم ثبت تعرفهه
                                                        //txt_status.setText("عدم ثبت تعرفه");
                                                        img_status.setBackgroundResource(R.drawable.warning_icon);
                                                    }

                                                    if (salaryAttribute.getProcessStatus().equals(0)) {
                                                        //ثبت اولیه
                                                        //txt_status.setText("ثبت اولیه");
                                                        img_status.setBackgroundResource(R.drawable.pending);
                                                    }

                                                    if (salaryAttribute.getProcessStatus().equals(1)) {
                                                        //ثبت اولیه
                                                        //txt_status.setText("تایید");
                                                        img_status.setBackgroundResource(R.drawable.deliverd);
                                                    }*//*


                                                    Date startDateTime;
                                                    Date endDateTime;

                                                    try {
                                                        startDateTime = sdf.parse(driverDailyActivity.getStartTime());
                                                        endDateTime = sdf.parse(driverDailyActivity.getEndTime());

                                                        roozh.PersianToGregorian(year, month, day);
                                                        calendar.set(roozh.getYear(), roozh.getMonth(), roozh.getDay());
                                                        calendar.add(Calendar.MONTH, -1);
                                                        Date date = calendar.getTime();

                                                        if (Util.compareDates(date, date) == 0) {
                                                            startDate.setText(CalendarUtil.convertPersianDateTime(startDateTime, "HH:mm"));
                                                            endDate.setText(CalendarUtil.convertPersianDateTime(endDateTime, "HH:mm"));
                                                        } else {
                                                            startDate.setText(CalendarUtil.convertPersianDateTime(startDateTime, "yyyy/MM/dd - HH:mm"));
                                                            endDate.setText(CalendarUtil.convertPersianDateTime(endDateTime, "yyyy/MM/dd - HH:mm"));
                                                        }


                                                        if (salaryAttribute.getDriverDailyActivity().getEtCardDataVOListSumCountEt() != null) {
                                                            dailyWorkTypeEn.setText(String.valueOf(salaryAttribute.getDriverDailyActivity().getEtCardDataVOListSumCountEt()));
                                                        }

                                                        //====getDutyWork=====
                                                        int t = salaryAttribute.getDutyWork();
                                                        int hours = t / 60; //since both are ints, you get an int
                                                        int minutes = t % 60;
                                                        dutyWork.setText(hours + ":" + minutes);

                                                        //====getFractionPerform=====
                                                        t = salaryAttribute.getFractionPerform();
                                                        hours = t / 60; //since both are ints, you get an int
                                                        minutes = t % 60;
                                                        fractionPerform.setText(hours + ":" + minutes);

                                                        //====getOvertimeWorkReal=====
                                                        t = salaryAttribute.getOvertimeWorkReal();
                                                        hours = t / 60; //since both are ints, you get an int
                                                        minutes = t % 60;
                                                        overtimeWorkReal.setText(hours + ":" + minutes);

                                                        //====getHalfPathNoSum=====
                                                        if (driverDailyActivity.getHalfPathNoSum() != null) {
                                                            t = driverDailyActivity.getHalfPathNoSum();
                                                            hours = t / 60; //since both are ints, you get an int
                                                            minutes = t % 60;
                                                            timeInLine.setText(hours + ":" + minutes);
                                                        }


                                                        halfPathNoGps.setText(salaryAttribute.getHalfPathNo().toString());

                                                        //====getFractionWork=====
                                                        t = salaryAttribute.getFractionWork();
                                                        hours = t / 60; //since both are ints, you get an int
                                                        minutes = t % 60;
                                                        fractionWork.setText(hours + ":" + minutes);

                                                        t = salaryAttribute.getNightWork();
                                                        hours = t / 60; //since both are ints, you get an int
                                                        minutes = t % 60;
                                                        nightWork.setText(hours + ":" + minutes);
                                                    } catch (ParseException e) {
                                                        e.printStackTrace();
                                                    }

                                                    showCaseViewFirFirst = CarApplication.getInstance().getSharedPreferences().getBoolean(Constants.WDF_SHOW_CASE_VIEW_FOR_FIRST, false);
                                                    if (showCaseViewFirFirst) {
                                                        SharedPreferences.Editor editor = CarApplication.getInstance().getSharedPreferences().edit();
                                                        editor.putBoolean(Constants.WDF_SHOW_CASE_VIEW_FOR_FIRST, false);
                                                        editor.apply();
                                                        backShowcaseView(getActivity(), img_back);
                                                   }

                                                } else {
                                                    showEmptyMessage.setVisibility(VISIBLE);
                                                    main_layout.setVisibility(View.GONE);
                                                    bottom_layout.setVisibility(View.GONE);
                                                }


                                            } else {
                                                showEmptyMessage.setVisibility(VISIBLE);
                                                // persistentbottomSheet.setVisibility(View.GONE);
                                                main_layout.setVisibility(View.GONE);
                                                bottom_layout.setVisibility(View.GONE);
                                            }*/
                                        }

                                    },
                                    new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            progressbar.setVisibility(GONE);
                                            img_progress.setVisibility(GONE);
                                            main_layout.setVisibility(GONE);
                                            bottom_layout.setVisibility(GONE);
                                            //persistentbottomSheet.setVisibility(View.GONE);
                                            showEmptyMessage.setVisibility(VISIBLE);

                                        }
                                    });


                            System.out.println("fromDate====" + fromDate);
                            ServerCoordinator.getInstance().getEtCardDataTranSumStatisticallyReportList(username, password, String.valueOf(driver.getCarId()), fromDate,
                                    new Response.Listener<ReportListResponseBean>() {
                                        @SuppressLint("SetTextI18n")
                                        @Override
                                        public void onResponse(ReportListResponseBean response) {
                                            List<BarEntry> entries = new ArrayList<BarEntry>();
                                            final ArrayList<String> xVals = new ArrayList<>();
                                            int count = response.getrESULT().getTimeSeriesList().size();
                                            String xval = "";

                                            for (int i = 0; i < count; i++) {
                                                int balance = response.getrESULT().getTimeSeriesList().get(i).getCount();
                                                entries.add(new BarEntry(balance, i));
                                                String out = response.getrESULT().getTimeSeriesList().get(i).getDate();
                                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.getDefault());
                                                try {
                                                    Date date = simpleDateFormat.parse(out);
                                                    Calendar calendar = Calendar.getInstance();
                                                    calendar.setTime(date);
                                                    JalaliCalendarUtil jalaliCalendarUtil = new JalaliCalendarUtil(calendar);
                                                    xval = String.format(Locale.getDefault(), "%02d:%02d", calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
                                                    xVals.add(xval);
                                                    System.out.println("xval===" + xval);
                                                } catch (ParseException e) {
                                                    e.printStackTrace();
                                                }
                                            }

                                            BarDataSet bardataset = new BarDataSet(entries, "");
                                            chart.animateY(3000);
                                            chart.getLegend().setEnabled(false);
                                            XAxis xAxis = chart.getXAxis();
                                            xAxis.setTypeface(CarApplication.getInstance().getPersianTypeFace());
                                            xAxis.setTextColor(getResources().getColor(R.color.colorPrimary));
                                            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
                                            xAxis.setLabelRotationAngle(-90f);
                                            xAxis.setTextSize(14f);
                                            xAxis.setDrawGridLines(false);
                                            xAxis.setAxisLineColor(getResources().getColor(android.R.color.transparent));
                                            xAxis.setSpaceBetweenLabels(1);
                                            //-----------------------------
                                            YAxis yAxis = chart.getAxisLeft();
                                            YAxis rightYAxis = chart.getAxisRight();
                                            rightYAxis.setEnabled(false);
                                            yAxis.setEnabled(false);
                                            yAxis.setTypeface(CarApplication.getInstance().getPersianTypeFace());
                                            yAxis.setTextColor(getResources().getColor(R.color.colorPrimary));
                                            yAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
                                            yAxis.setGridColor(getResources().getColor(R.color.colorPrimary));
                                            yAxis.setDrawGridLines(false);
                                            yAxis.setTextSize(14f);
                                            yAxis.setZeroLineColor(getResources().getColor(android.R.color.transparent));
                                            bardataset.setColor(getResources().getColor(R.color.light_green));
                                            barData = new BarData(xVals, bardataset);
                                            barData.setValueFormatter(new MyValueFormatter());
                                            barData.setValueTypeface(CarApplication.getInstance().getPersianTypeFace());
                                            barData.setValueTextSize(12f);
                                            chart.setDescription("");
                                            chart.setData(barData);
                                        }

                                    },
                                    new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            progressbar.setVisibility(GONE);
                                            img_progress.setVisibility(GONE);
                                            main_layout.setVisibility(GONE);
                                            bottom_layout.setVisibility(GONE);
                                            //persistentbottomSheet.setVisibility(View.GONE);
                                            showEmptyMessage.setVisibility(VISIBLE);

                                        }
                                    });

                        } else {
                            Utils.showToast(getActivity(), R.string.message_toast_invalidDateTime, false);
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progressbar.setVisibility(GONE);
                    img_progress.setVisibility(GONE);
                    main_layout.setVisibility(GONE);
                    bottom_layout.setVisibility(GONE);
                    showEmptyMessage.setVisibility(VISIBLE);
                    Utils.showErrors(getActivity(), error);

                }
            });
        }

    }

    private void goToMonthlyFragment() {
        Fragment fragment = new MonthlyFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
        EventBus.getDefault().post(new EventBusModel("MonthlyFragment"));
    }

    public static void backShowcaseView(final Context context, View view) {

        String title = "برای رفتن به قسمت ماهانه ، از این دکمه استفاده کنید";
        String description = "";

        TapTargetView.showFor((Activity) context, TapTarget.forView(view, title, description)
                .cancelable(false)
                .drawShadow(false)
                .targetCircleColor(R.color.colorPrimary)
                .outerCircleColor(R.color.light_green_transparent)
                .textColor(R.color.white)
                .titleTextDimen(R.dimen.title_text_size)
                .tintTarget(false), new TapTargetView.Listener() {
            @Override
            public void onTargetClick(TapTargetView view) {
                super.onTargetClick(view);
                cardLeftShowcaseView(context);
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

    public static void cardLeftShowcaseView(final Context context) {
        String title = "برای رفتن به روزهای قبل و بعد ، از این قسمت استفاده کنید";
        String description = "";

        TapTargetView.showFor((Activity) context, TapTarget.forView(((Activity) context).findViewById(R.id.bottom_layout), title, description)
                .cancelable(false)
                .drawShadow(false)
                .targetCircleColor(R.color.light_green)
                .outerCircleColor(R.color.light_green_transparent)
                .textColor(R.color.white)
                .targetRadius(200)
                .titleTextDimen(R.dimen.title_text_size)
                .tintTarget(false), new TapTargetView.Listener() {
            @Override
            public void onTargetClick(TapTargetView view) {
                super.onTargetClick(view);
                //cardRightShowcaseView(context, title, description);
                calendarShowcaseView(context);
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

    public static void cardRightShowcaseView(final Context context, final String title, final String description) {

        TapTargetView.showFor((Activity) context, TapTarget.forView(((Activity) context).findViewById(R.id.card_right), title, description)
                .cancelable(false)
                .drawShadow(false)
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

    public static void calendarShowcaseView(final Context context) {
        String title = "برای انتخاب روز مورد نظر ، روی این دکمه ضربه بزنید";
        String description = "";

        Button button = ((Activity) context).findViewById(R.id.calendar_icon);
        TapTargetView.showFor((Activity) context, TapTarget.forView(button, title, description)
                .cancelable(false)
                .drawShadow(false)
                .targetCircleColor(R.color.light_green)
                .outerCircleColor(R.color.light_green_transparent)
                .textColor(R.color.white)
                .titleTextDimen(R.dimen.title_text_size)
                .tintTarget(false), new TapTargetView.Listener() {
            @Override
            public void onTargetClick(TapTargetView view) {
                super.onTargetClick(view);
                selectMonthShowcaseView(context);
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

    public static void selectMonthShowcaseView(Context context) {
        RelativeLayout relativeLayout = ((Activity) context).findViewById(R.id.relativeLayout_selectMonth);
        String title = "دسترسی به قسمت روزانه و ماهانه";
        String description = "";
        TapTargetView.showFor((Activity) context, TapTarget.forView(relativeLayout, title, description)
                .cancelable(false)
                .drawShadow(false)
                .targetRadius(100)
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

