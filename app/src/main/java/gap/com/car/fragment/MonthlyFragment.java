package gap.com.car.fragment;

import static android.view.View.GONE;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.renderer.BarChartRenderer;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import org.greenrobot.eventbus.EventBus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import gap.com.car.R;
import gap.com.car.app.CarApplication;
import gap.com.car.common.Constants;
import gap.com.car.database.entity.Driver;
import gap.com.car.gapcalendar.adapter.CalendarAdapter;
import gap.com.car.gapcalendar.customweekview.DateConvertor;
import gap.com.car.gapcalendar.customweekview.PersianDate;
import gap.com.car.model.DriverProfileResponseBean;
import gap.com.car.model.EventBusModel;
import gap.com.car.model.ServerDateTimeResponseBean;
import gap.com.car.model.carinvoice.CarDailyInfoList;
import gap.com.car.model.carinvoice.SuccessResponseCarInvoice;
import gap.com.car.model.update.ReportListResponseBean;
import gap.com.car.services.ServerCoordinator;
import gap.com.car.util.Constant;
import gap.com.car.util.DateUtils;
import gap.com.car.util.Globals;
import gap.com.car.util.JalaliCalendarUtil;
import gap.com.car.util.OnSwipeTouchListener;
import gap.com.car.util.RecyclerItemClickListener;
import gap.com.car.util.Util;
import gap.com.car.util.Utils;
import gap.com.car.widget.CircularProgress;
import gap.com.car.widget.MyValueFormatter;
import gap.com.datepicker.DatePicker;
import gap.com.datepicker.interfaces.DateSetListener;

public class MonthlyFragment extends Fragment {

    private static final String tag = "WeekViewActivity";
    private int month, year, day = 0;
    private TextView txt_timeMinInLine, txt_fuelValue, txt_priceEtPass, txt_halfPathNO, txt_kmInLineFV, txt_countEtPass, txt_etCardNo, txt_priceEtSumFV, txt_dayActNo, txt_priceSubDF_2, txt_priceIncomeFV, txt_priceIncomeEstimateFV;
    private AppCompatTextView txt_selectedDate;
    private CalendarAdapter calendarAdapter;
    private RecyclerView recyclerView;
    private Fragment fragment;
    private int i = 0;
    private DateConvertor tmpDateConvertor;
    private FragmentManager fragmentManager;
    private int startSelectDate;
    private ArrayList<String> StringArray = new ArrayList<String>();
    private Globals sharedData = Globals.getInstance();
    private PersianDate persianDate;
    private ImageView iv_trigger, img_progress, img_graph, img_back;
    private CircularProgress progressbar;
    private ArrayList<CarDailyInfoList> arrayList = new ArrayList<>();
    private RelativeLayout relativeLayout;
    private CoordinatorLayout coordinatorLayout;
    private LinearLayout linearLayout, linearLayout_graph;
    private View persistentbottomSheet;
    private boolean isErrorListener;
    private CardView cardView;
    private SuccessResponseCarInvoice successResponseCarInvoice;
    private BarChart chart;
    private BottomSheetBehavior behavior;

    public MonthlyFragment() {

    }

    @SuppressLint("NewApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup view, Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.fragment_home, view, false);
        startSelectDate = CarApplication.getInstance().getSharedPreferences().getInt(Constant.SELECT_START_WEEKDAY, -1);

        progressbar = (CircularProgress) view1.findViewById(R.id.progressbar);
        img_progress = view1.findViewById(R.id.img_progress);
        img_graph = view1.findViewById(R.id.img_graph);
        img_back = view1.findViewById(R.id.img_back);
        cardView = view1.findViewById(R.id.cardView);
        progressbar.setVisibility(GONE);
        img_progress.setVisibility(GONE);
        coordinatorLayout = (CoordinatorLayout) view1.findViewById(R.id.coordinator);
        init_persistent_bottomsheet();
        init(view1);
        persianDate = new PersianDate();
        compareTo();
        sharedData.setLeavePage(true);

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        JalaliCalendarUtil jalaliCalendarUtil = new JalaliCalendarUtil(cal);
        txt_selectedDate.setText(jalaliCalendarUtil.getIranianWeekDayStr() + " " + jalaliCalendarUtil.getIranianDate3());

        Glide.with(this)
                .load(R.raw.myanimation)
                .into(img_progress);

        /*
         * select custom date in month fragment
         * */
        txt_selectedDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                Calendar minDate = Calendar.getInstance();
                Calendar maxDate = Calendar.getInstance();
                //maxDate.set(Calendar.MONTH, maxDate.get(Calendar.MONTH) + 1);
                minDate.set(Calendar.MONTH, minDate.get(Calendar.MONTH) - 2);
                new DatePicker.Builder()
                        .id(1)
                        .minDate(minDate)
                        .maxDate(maxDate)
                        .build(new DateSetListener() {
                            @Override
                            public void onDateSet(int id, @Nullable Calendar calendar, int day, int month, int year) {
                                if (calendar == null)
                                    return;

                                JalaliCalendarUtil jalaliCalendarUtil = new JalaliCalendarUtil(calendar);
                                txt_selectedDate.setText(jalaliCalendarUtil.getIranianWeekDayStr() + " " + jalaliCalendarUtil.getIranianDate3());
                                setDate(calendar);
                            }
                        })
                        .show(fm, "");
            }
        });


        /*
         * for swipe monthly calendar to next or before
         * */
        recyclerView.setOnTouchListener(new OnSwipeTouchListener() {

            @Override
            public boolean onSwipeLeft() {
                /*if (month == (persianDate.getShMonth() - 2) && year == persianDate.getShYear() || month == (persianDate.getShMonth() + 10) && year == persianDate.getShYear() - 1) {
                    return false;
                }*/

                if (month == persianDate.getShMonth() - 6) {
                    return false;
                }

                behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

                prevMethod();
                getActivity().overridePendingTransition(R.anim.left_out, R.anim.right_in);
                return true;
            }

            @Override
            public boolean onSwipeRight() {
                if (month == persianDate.getShMonth() && year == persianDate.getShYear()) {
                    return false;
                }

                behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

                nextMethod();
                getActivity().overridePendingTransition(R.anim.left_in, R.anim.right_out);
                return true;
            }

            @Override
            public boolean onSwipeBottom() {
                // TODO Auto-generated method stub
                return true;
            }

            @Override
            public boolean onSwipeTop() {
                // TODO Auto-generated method stub
                return true;
            }

        });


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                recyclerView.removeOnScrollListener(this);
            }
        });


        /*
         * click list and get id and pass to day fragment with bundle
         * */
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                // TODO Auto-generated method stub
                String id = (String) ((TextView) view.findViewById(R.id.id)).getText();
                String date = (String) ((TextView) view.findViewById(R.id.date)).getText();
                System.out.println("======date=========" + date);

                if (!date.trim().isEmpty()) {
                    String txt_day1 = ((TextView) view.findViewById(R.id.calendar_day_gridcell)).getText().toString();
                    String txt_day2 = ((TextView) view.findViewById(R.id.calendar_day_gridcell_1)).getText().toString();
                    String txt_day3 = ((TextView) view.findViewById(R.id.calendar_day_gridcell_2)).getText().toString();
                    String strDate = "";
                    if (!txt_day1.equals("")) {
                        strDate = txt_day1;
                    } else if (!txt_day2.equals("")) {
                        strDate = txt_day2;
                    } else if (!txt_day3.equals("")) {
                        strDate = txt_day3;
                    }

                    System.out.println("txt_day1=====" + txt_day1);
                    System.out.println("txt_day2=====" + txt_day2);
                    System.out.println("txt_day3=====" + txt_day3);

                    if (!strDate.equals("")) {
                        day = Integer.parseInt(strDate);
                        tmpDateConvertor.setGregorianDate(year, month, day);

                        sharedData.setYear(year);
                        sharedData.setMonth(month);
                        sharedData.setDay(day);

                        sharedData.setGridOnClick(Constant.ACTION_GRID_ONCLICK);
                        sharedData.setSelectedMenuItem(Constant.ACTION_DAY);
                        sharedData.setSalaryListItemId(id);


                        System.out.println("tmpDateConvertor1=====" + year);
                        System.out.println("tmpDateConvertor2=====" + month);
                        System.out.println("tmpDateConvertor3=====" + day);

                        System.out.println("tmpDateConvertor4=====" +year);
                        System.out.println("tmpDateConvertor4=====" + month);
                        System.out.println("tmpDateConvertor4=====" + day);
                    }

                    fragment = new WeekDayFragment();
                    fragmentManager = getActivity().getSupportFragmentManager();
                    Bundle args = new Bundle();
                    // args.putParcelable("getSalaryAttributeResponseBean", getSalaryAttributeResponseBean);
                    fragment.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                    Util.recognizeSelectedItems(Constant.RECOGNIZE, "WeekDayFragment");
                    EventBus.getDefault().post(new EventBusModel("WeekDayFragment"));

                    sharedData.setCurrentDate(true);
                    sharedData.setCurrentDay(day);

                } else {
                    Utils.showToast(getActivity(), R.string.message_toast_recyclerView_click, false);
                }

            }
        }));

        img_graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setVisibility(GONE);
                linearLayout_graph.setVisibility(View.VISIBLE);
            }
        });

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setVisibility(View.VISIBLE);
                linearLayout_graph.setVisibility(GONE);
            }
        });

        return view1;
    }


    /*
     *
     *init widget
     * */
    private void init(View view1) {
        DateConvertor dateConvertor = new DateConvertor();
        Calendar _calendar = Calendar.getInstance(Locale.getDefault());
        recyclerView = view1.findViewById(R.id.recyclerView);
        TextView txt_p1 = view1.findViewById(R.id.txt_p1);
        TextView txt_p2 = view1.findViewById(R.id.txt_p2);
        TextView txt_p3 = view1.findViewById(R.id.txt_p3);
        TextView txt_p4 = view1.findViewById(R.id.txt_p4);
        TextView txt_p5 = view1.findViewById(R.id.txt_p5);
        TextView txt_p6 = view1.findViewById(R.id.txt_p6);
        TextView txt_p7 = view1.findViewById(R.id.txt_p7);
        txt_selectedDate = view1.findViewById(R.id.txt_selectedDate);

        txt_timeMinInLine = view1.findViewById(R.id.txt_timeMinInLine);
        txt_fuelValue = view1.findViewById(R.id.txt_fuelValue);
        txt_priceEtPass = view1.findViewById(R.id.txt_priceEtPass);
        txt_halfPathNO = view1.findViewById(R.id.txt_halfPathNO);
        txt_kmInLineFV = view1.findViewById(R.id.txt_kmInLineFV);
        txt_countEtPass = view1.findViewById(R.id.txt_countEtPass);
        txt_etCardNo = view1.findViewById(R.id.txt_etCardNo);
        txt_priceEtSumFV = view1.findViewById(R.id.txt_priceEtSumFV);
        txt_dayActNo = view1.findViewById(R.id.txt_dayActNo);
        txt_priceSubDF_2 = view1.findViewById(R.id.txt_priceSubDF_2);
        txt_priceIncomeFV = view1.findViewById(R.id.txt_priceIncomeFV);
        txt_priceIncomeEstimateFV = view1.findViewById(R.id.txt_priceIncomeEstimateFV);


        ArrayValueAddFunction();
        /*txt_p1.append(StringArray.get(0));
        txt_p2.append(StringArray.get(1));
        txt_p3.append(StringArray.get(2));
        txt_p4.append(StringArray.get(3));
        txt_p5.append(StringArray.get(4));
        txt_p6.append(StringArray.get(5));
        txt_p7.append(StringArray.get(6));*/

        tmpDateConvertor = new DateConvertor();
        if (sharedData.getYear() != 0 && sharedData.getMonth() != 0 && sharedData.getDay() != 0) {
            this.year = sharedData.getYear();
            this.month = sharedData.getMonth();
            this.day = sharedData.getDay();

        } else {
            this.year = dateConvertor.getIranianYear();
            this.month = dateConvertor.getIranianMonth();
            this.day = dateConvertor.getIranianDay();

            sharedData.setYear(this.year);
            sharedData.setMonth(this.month);
            sharedData.setDay(this.day);
        }

        recyclerView.setHasFixedSize(true);
        //gridLayoutManager = new GridLayoutManager(getActivity(), 7);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 7));


        if (Utils.isConnected(getActivity())) {
            isDeviceDateTimeValid(this.year, this.month, 1);
        } else {
            Utils.showToast(getActivity(), R.string.error_noConnection, false);
        }

        calendarAdapter = new CalendarAdapter(getActivity(), this.year, this.month, this.day, arrayList);
        recyclerView.setAdapter(calendarAdapter);
    }

    /*
     * for select start from which day of month
     * */
    private void ArrayValueAddFunction() {

        switch (startSelectDate) {
            case 1:
                StringArray.add(getResources().getString(R.string.label_persian_p1));
                StringArray.add(getResources().getString(R.string.label_persian_p2));
                StringArray.add(getResources().getString(R.string.label_persian_p3));
                StringArray.add(getResources().getString(R.string.label_persian_p4));
                StringArray.add(getResources().getString(R.string.label_persian_p5));
                StringArray.add(getResources().getString(R.string.label_persian_p6));
                StringArray.add(getResources().getString(R.string.label_persian_p7));
                break;
            case 2:
                StringArray.add(getResources().getString(R.string.label_persian_p2));
                StringArray.add(getResources().getString(R.string.label_persian_p3));
                StringArray.add(getResources().getString(R.string.label_persian_p4));
                StringArray.add(getResources().getString(R.string.label_persian_p5));
                StringArray.add(getResources().getString(R.string.label_persian_p6));
                StringArray.add(getResources().getString(R.string.label_persian_p7));
                StringArray.add(getResources().getString(R.string.label_persian_p1));
                break;
            case 3:
                StringArray.add(getResources().getString(R.string.label_persian_p3));
                StringArray.add(getResources().getString(R.string.label_persian_p4));
                StringArray.add(getResources().getString(R.string.label_persian_p5));
                StringArray.add(getResources().getString(R.string.label_persian_p6));
                StringArray.add(getResources().getString(R.string.label_persian_p7));
                StringArray.add(getResources().getString(R.string.label_persian_p1));
                StringArray.add(getResources().getString(R.string.label_persian_p2));
                break;

            default:
                StringArray.add(getResources().getString(R.string.label_persian_p1));
                StringArray.add(getResources().getString(R.string.label_persian_p2));
                StringArray.add(getResources().getString(R.string.label_persian_p3));
                StringArray.add(getResources().getString(R.string.label_persian_p4));
                StringArray.add(getResources().getString(R.string.label_persian_p5));
                StringArray.add(getResources().getString(R.string.label_persian_p6));
                StringArray.add(getResources().getString(R.string.label_persian_p7));
        }
    }


    /*
     * set and init adapter for list view in month calendar
     * */
    private void setGridCellAdapterToDate() {

        sharedData.setYear(this.year);
        sharedData.setMonth(this.month);
        sharedData.setDay(this.day);

        recyclerView.setHasFixedSize(true);
        //gridLayoutManager = new GridLayoutManager(getActivity(), 7);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 7));

        calendarAdapter = new CalendarAdapter(getActivity(), this.year, this.month, this.day, arrayList);
        recyclerView.setAdapter(calendarAdapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    /*
     * goto next month
     * */
    @SuppressLint("SetTextI18n")
    public void nextMethod() {
        // TODO Auto-generated method stub
        if (isErrorListener) {
            Utils.showToast(getActivity(), "isErrorListener", false);
        } else {

            if (this.month > 11) {
                this.month = 1;
                this.year++;
            } else {
                this.month++;
            }

            Log.d(tag, "Setting Next Month in GridCellAdapter: "
                    + "Month: " + this.month + " Year: " + this.year);

            System.out.println("Setting Prev Month in GridCellAdapterout: " + "Month: " + this.month + " Year: " + this.year);
            //setGridCellAdapterToDate(this.month, year);
            compareTo();
        }

        if (Utils.isConnected(getActivity())) {
            isDeviceDateTimeValid(this.year, this.month, 1);
        } else {
            Utils.showToast(getActivity(), R.string.error_noConnection, false);
        }
    }


    /*
     * go to prev month
     * */
    @SuppressLint("SetTextI18n")
    public void prevMethod() {
        // TODO Auto-generated method stub

        if (isErrorListener) {
            Utils.showToast(getActivity(), "isErrorListener", false);
        } else {

            if (this.month <= 1) {
                this.month = 12;
                this.year--;
            } else {
                this.month--;
            }
            Log.d(tag, "Setting Prev Month in GridCellAdapter: "
                    + "Month: " + this.month + " Year: " + this.year);

            System.out.println("Setting Prev Month in GridCellAdapterout: " + "Month: " + this.month + " Year: " + this.year);
            //setGridCellAdapterToDate(this.month, this.year);
            compareTo();
        }

        if (Utils.isConnected(getActivity())) {
            isDeviceDateTimeValid(this.year, this.month, 1);
        } else {
            Utils.showToast(getActivity(), R.string.error_noConnection, false);
        }


    }


    /*
     * for recognize month such as befor and next on current month
     * */
    private void compareTo() {
        TextView showDateName = ((Activity) getContext()).findViewById(R.id.showDateName_txt);
        showDateName.setText("");

        if (month == (persianDate.getShMonth() - 1) && year == persianDate.getShYear() || month == (persianDate.getShMonth() + 11) && year == persianDate.getShYear() - 1) {

            showDateName.setText("ماه قبل");

        } else if (month == (persianDate.getShMonth() + 1) && year == persianDate.getShYear()) {
            showDateName.setText("ماه بعد");

        } else if (month == persianDate.getShMonth() && year == persianDate.getShYear()) {
            showDateName.setText("ماه جاری");

        }
    }


    /*
     * for navigation button in bottom page monthly
     * */
    public void init_persistent_bottomsheet() {
        persistentbottomSheet = coordinatorLayout.findViewById(R.id.bottomsheet);
        iv_trigger = (ImageView) persistentbottomSheet.findViewById(R.id.iv_fab);
        relativeLayout = (RelativeLayout) persistentbottomSheet.findViewById(R.id.relativeLayout);
        linearLayout = (LinearLayout) persistentbottomSheet.findViewById(R.id.linearLayout);
        linearLayout_graph = persistentbottomSheet.findViewById(R.id.linearLayout_graph);
        behavior = BottomSheetBehavior.from(persistentbottomSheet);
        persistentbottomSheet.setVisibility(GONE);
        chart = persistentbottomSheet.findViewById(R.id.chart);

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (behavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    //iv_trigger.setBackgroundResource(R.drawable.negative_icon);
                    linearLayout.setBackgroundResource(R.color.glass_white);
                } else {
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    // iv_trigger.setBackgroundResource(R.drawable.plus_icon);
                    //linearLayout.setBackgroundResource(0);
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

    }


    /*
     * get invalid date time and call monthly salary attribute with type 1
     * */
    private void isDeviceDateTimeValid(final int year, final int month, int day) {
        CarApplication application = (CarApplication) getActivity().getApplication();
        final Driver driver = application.getCurrentUser();
        //loadChart();
        if (driver != null) {
            final String username = driver.getUsername();
            final String password = driver.getPassword();

            final int type = 1;
            final String fromDate = year + "-" + month + "-" + day;
            final String etCardFromDate = year + "-" + month;

            //final String toDate = "";
            final DriverProfileResponseBean driverProfileResponseBean = sharedData.getResponse();
            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATE_TIME_FORMAT);
            progressbar.setVisibility(View.VISIBLE);
            img_progress.setVisibility(View.VISIBLE);
            cardView.setVisibility(GONE);
            ServerCoordinator.getInstance().getServerDateTime(new Response.Listener<ServerDateTimeResponseBean>() {
                @Override
                public void onResponse(ServerDateTimeResponseBean response) {
                    progressbar.setVisibility(GONE);
                    img_progress.setVisibility(GONE);
                    try {
                        Date serverDateTime = simpleDateFormat.parse(response.getRESULT().getServerDateTime());
                        if (DateUtils.isValidDateDiff(new Date(), serverDateTime, Constants.VALID_SERVER_AND_DEVICE_TIME_DIFF)) {
                            progressbar.setVisibility(View.VISIBLE);
                            img_progress.setVisibility(View.VISIBLE);
                            ServerCoordinator.getInstance().getCarInvoice(username, password, String.valueOf(driver.getCarId()), "4", fromDate,
                                    new Response.Listener<SuccessResponseCarInvoice>() {
                                        @SuppressLint("SetTextI18n")
                                        @Override
                                        public void onResponse(SuccessResponseCarInvoice response) {
                                            progressbar.setVisibility(GONE);
                                            img_progress.setVisibility(GONE);
                                            cardView.setVisibility(View.VISIBLE);
                                            relativeLayout.setVisibility(View.VISIBLE);
                                            isErrorListener = false;

                                            successResponseCarInvoice = response;
                                            if (response != null && response.getCarInvoice() != null) {
                                                System.out.println("getCarInvoice=====" + response);
                                                txt_timeMinInLine.setText(response.getCarInvoice().getTimeMinInLine() + "");
                                                txt_fuelValue.setText(response.getCarInvoice().getFuelValue() + "");
                                                txt_priceEtPass.setText(Util.addCommasToNumericString(String.valueOf(response.getCarInvoice().getPriceEtPass())));
                                                txt_halfPathNO.setText(response.getCarInvoice().getHalfPathNO() + "");
                                                txt_kmInLineFV.setText(response.getCarInvoice().getKmInLineFV() + "");
                                                txt_countEtPass.setText(Util.addCommasToNumericString(String.valueOf(response.getCarInvoice().getCountEtPass())));
                                                txt_etCardNo.setText(Util.addCommasToNumericString(String.valueOf(response.getCarInvoice().getEtCardNo())));
                                                txt_priceEtSumFV.setText(Util.addCommasToNumericString(String.valueOf(response.getCarInvoice().getPriceEtSumFV())));
                                                txt_dayActNo.setText(Util.addCommasToNumericString(String.valueOf(response.getCarInvoice().getDayActNo())));
                                                txt_priceSubDF_2.setText(Util.addCommasToNumericString(String.valueOf(response.getCarInvoice().getPriceSubDF_2())));
                                                txt_priceIncomeFV.setText(Util.addCommasToNumericString(String.valueOf(response.getCarInvoice().getPriceIncomeFV())));
                                                txt_priceIncomeEstimateFV.setText(Util.addCommasToNumericString(String.valueOf(response.getCarInvoice().getPriceIncomeEstimateFV())));

                                                persistentbottomSheet.setVisibility(View.VISIBLE);
                                                if (response.getCarInvoice().getCarDailyInfoList() != null) {
                                                    arrayList = (ArrayList<CarDailyInfoList>) response.getCarInvoice().getCarDailyInfoList();
                                                }
                                            } else {
                                                persistentbottomSheet.setVisibility(GONE);
                                            }
                                            setGridCellAdapterToDate();

                                        }
                                    },
                                    new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            relativeLayout.setVisibility(GONE);
                                            progressbar.setVisibility(GONE);
                                            img_progress.setVisibility(GONE);
                                            Utils.showErrors(getActivity(), error);
                                            isErrorListener = true;
                                        }
                                    });

                        } else {
                            Utils.showToast(getActivity(), R.string.message_toast_invalidDateTime, false);
                            progressbar.setVisibility(GONE);
                            img_progress.setVisibility(GONE);
                            isErrorListener = true;
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Utils.showErrors(getActivity(), error);
                    progressbar.setVisibility(GONE);
                    img_progress.setVisibility(GONE);
                    isErrorListener = true;

                }
            });

            System.out.println("fromDate====" + etCardFromDate);
            ServerCoordinator.getInstance().getEtCardDataTranSumStatisticallyReportList(username, password, String.valueOf(driver.getCarId()), etCardFromDate,
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
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss", Locale.getDefault());
                                try {
                                    Date date = simpleDateFormat.parse(out);
                                    Calendar calendar = Calendar.getInstance();
                                    calendar.setTime(date);
                                    JalaliCalendarUtil jalaliCalendarUtil = new JalaliCalendarUtil(calendar);
                                    xval = String.valueOf(i + 1);
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
                            BarData barData = new BarData(xVals, bardataset);
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
                        }
                    });
        }


    }

    /*
     * set date for get calendar value from date piker chooser
     * */

    private void setDate(final Calendar calendar) {
        if (calendar == null)
            return;

        JalaliCalendarUtil jalaliCalendarUtil = new JalaliCalendarUtil(calendar);
        this.year = jalaliCalendarUtil.getIranianYear();
        this.month = jalaliCalendarUtil.getIranianMonth();
        this.day = jalaliCalendarUtil.getIranianDay();

        sharedData.setYear(this.year);
        sharedData.setMonth(this.month);
        sharedData.setDay(this.day);
        sharedData.setSelectedMenuItem(Constant.ACTION_MONTh);


        if (Utils.isConnected(getActivity())) {
            System.out.println("======isDeviceDateTimeValid4=====");
            isDeviceDateTimeValid(this.year, this.month, 1);
        } else {
            Utils.showToast(getActivity(), R.string.error_noConnection, false);
        }

        //calendarAdapter = new CalendarAdapter(getActivity(), jalaliCalendarUtil.getIranianYear(),jalaliCalendarUtil.getIranianMonth(), jalaliCalendarUtil.getIranianDay(), arrayList);
        //recyclerView.setAdapter(calendarAdapter);

    }

    @Override
    public void onPause() {
        super.onPause();
        //sharedData.setMonthlyPage(false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //sharedData.setMonthlyPage(false);
    }

    @Override
    public void onStop() {
        super.onStop();
        //sharedData.setMonthlyPage(false);
    }
}
