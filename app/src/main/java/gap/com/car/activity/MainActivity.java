package gap.com.car.activity;


import static gap.com.car.R.id.content_frame;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import gap.com.car.BuildConfig;
import gap.com.car.R;
import gap.com.car.adapter.DrawerItemCustomAdapter;
import gap.com.car.app.CarApplication;
import gap.com.car.common.Constants;
import gap.com.car.database.DataBaseClint;
import gap.com.car.database.entity.Driver;
import gap.com.car.fragment.AboutFragment;
import gap.com.car.fragment.CarProfileFragment;
import gap.com.car.fragment.CommentFragment;
import gap.com.car.fragment.DriverProfileFragment;
import gap.com.car.fragment.ListLeaveFragment;
import gap.com.car.fragment.ListReportFragment;
import gap.com.car.fragment.MonthlyFragment;
import gap.com.car.fragment.PrivacyFragment;
import gap.com.car.fragment.SettingsFragment;
import gap.com.car.fragment.WeekDayFragment;
import gap.com.car.gapcalendar.customweekview.DateConvertor;
import gap.com.car.gapcalendar.customweekview.PersianDate;
import gap.com.car.model.DataModel;
import gap.com.car.model.EventBusModel;
import gap.com.car.model.ServerDateTimeResponseBean;
import gap.com.car.model.carprofile.CarProfileResultBean;
import gap.com.car.services.ServerCoordinator;
import gap.com.car.util.Constant;
import gap.com.car.util.DateUtils;
import gap.com.car.util.Globals;
import gap.com.car.util.JalaliCalendarUtil;
import gap.com.car.util.Util;
import gap.com.car.util.Utils;
import gap.com.datepicker.DatePicker;
import gap.com.datepicker.interfaces.DateSetListener;

//import com.google.firebase.analytics.FirebaseAnalytics;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private DateConvertor dateConvertor, tmpDateConvertor;
    private Fragment current;
    private RelativeLayout relativeLayout;
    private RelativeLayout calendarIconLayout;
    //private String recognize;
    private TextView spinner_txt, txt_version;
    private ImageView menuIcon;
    private CircleImageView img_profile;
    private Button calendarIcon;
    private Globals sharedData = Globals.getInstance();
    private PersianDate persianDate;
    private CarApplication application;
    private Driver driver;
    private FragmentManager fragmentManager;
    private boolean stop = false;
    private String currentPageName = "";
    private List<Driver> driverList;
    private boolean loginIs = false;
    private String token;
    boolean doubleBackToExitPressedOnce = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int activePass = CarApplication.getInstance().getSharedPreferences().getInt(Constant.SELECT_CONFIRM_LOCALPASS, 0);
        setContentView(R.layout.activity_main);
        init();
        sharedData.setSelectedMenuItem(Constant.ACTION_MONTh);
        closeDrawer();
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        final JalaliCalendarUtil jalaliCalendarUtil = new JalaliCalendarUtil(cal);
        spinner_txt.setText(jalaliCalendarUtil.getIranianDate3());


        //String udata = Util.faToEn(Util.Shamsi_Date());
        //SpannableString content = new SpannableString(udata);
        //content.setSpan(new UnderlineSpan(), 0, udata.length(), 0);//where first 0 shows the starting and udata.length() shows the ending span.if you want to span only part of it than you can change these values like 5,8 then it will underline part of it.
        //spinner_txt.setText(content);
        calendarIcon.setText(Util.faToEn(Util.Shamsi_Date()));


        img_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction(new DriverProfileFragment(), "DriverProfileFragment");
                EventBus.getDefault().post(new EventBusModel("DriverProfileFragment"));
                closeDrawer();
            }
        });

        findViewById(R.id.profileLinearLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction(new DriverProfileFragment(), "DriverProfileFragment");
                EventBus.getDefault().post(new EventBusModel("DriverProfileFragment"));
                closeDrawer();
            }
        });


        ////******relativeLayout for pop up menu*******////
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {

                // TODO Auto-generated method stub
                Context wrapper = new ContextThemeWrapper(getApplicationContext(), R.style.popupMenuStyle);
                PopupMenu popup = new PopupMenu(wrapper, relativeLayout);
                //popup.setGravity(Gravity.RIGHT);
                callMenu(popup);

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()) {

                            case R.id.action_today:
                                sharedData.setSelectedMenuItem(Constant.ACTION_DAY);
                                sharedData.setGridOnClick(Constant.ACTION_DAY);
                                fragmentTransaction(new WeekDayFragment(), "WeekDayFragment");
                                EventBus.getDefault().post(new EventBusModel("WeekDayFragment"));

                                break;
                            case R.id.action_week:
                  /*              sharedData.setSelectedMenuItem(Constant.ACTION_WEEK);
                                sharedData.setGridOnClick(Constant.ACTION_WEEK);
                                fragmentTransaction(new WeekDayFragment(), "WeekDayFragment");
                                EventBus.getDefault().post(new EventBusModel("WeekDayFragment"));*/
                                break;

                            case R.id.action_month:
                                sharedData.setSelectedMenuItem(Constant.ACTION_MONTh);
                                sharedData.setGridOnClick(Constant.ACTION_MONTh);
                                fragmentTransaction(new MonthlyFragment(), "MonthlyFragment");
                                EventBus.getDefault().post(new EventBusModel("MonthlyFragment"));
                                break;
                        }

                        return true;
                    }
                });

                popup.show();
            }
        });


        ////******calendar Icon toolbar click*******////
        calendarIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context wrapper = new ContextThemeWrapper(getApplicationContext(), R.style.popupMenuStyle);
                PopupMenu popup = new PopupMenu(wrapper, calendarIconLayout);
                popup.getMenu().add(1, R.id.action_today, 1, "امروز                   ");
                popup.getMenu().add(1, R.id.action_custom, 2, "برو به                   ");
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_today:
                                sharedData.setCurrentDay(dateConvertor.getIranianDay());
                                sharedData.setYear(dateConvertor.getIranianYear());
                                sharedData.setMonth(dateConvertor.getIranianMonth());
                                sharedData.setDay(dateConvertor.getIranianDay());

                                sharedData.setSelectedMenuItem(Constant.ACTION_DAY);
                                fragmentTransaction(new WeekDayFragment(), "WeekDayFragment");
                                EventBus.getDefault().post(new EventBusModel("WeekDayFragment"));

                               // spinner_txt.setText(jalaliCalendarUtil.getIranianDate3());

                               /* if (sharedData.getSelectedMenuItem() != null) {
                                    if (sharedData.getSelectedMenuItem().equals(Constant.ACTION_DAY)) {
                                        sharedData.setSelectedMenuItem(Constant.ACTION_DAY);
                                        fragmentTransaction(new WeekDayFragment(), "WeekDayFragment");
                                        EventBus.getDefault().post(new EventBusModel("WeekDayFragment"));

                                    } else if (sharedData.getSelectedMenuItem().equals(Constant.ACTION_WEEK)) {
                                       // sharedData.setSelectedMenuItem(Constant.ACTION_WEEK);
                                        //fragmentTransaction(new


                                        (), "WeekDayFragment");

                                    } else if (sharedData.getSelectedMenuItem().equals(Constant.ACTION_MONTh)) {
                                        sharedData.setSelectedMenuItem(Constant.ACTION_MONTh);
                                        fragmentTransaction(new MonthlyFragment(), "WeekDayFragment");
                                        EventBus.getDefault().post(new EventBusModel("WeekDayFragment"));
                                    }
                                }*/

                                break;

                            case R.id.action_custom:
                                sharedData.setLeavePage(false);
                                //Util.recognizeSelectedItems(Constant.RECOGNIZE, "MonthlyFragment");
                                Calendar minDate = Calendar.getInstance();
                                Calendar maxDate = Calendar.getInstance();
                                minDate.set(Calendar.MONTH, minDate.get(Calendar.MONTH) - 6);
                                new DatePicker.Builder()
                                        .id(1)
                                        .minDate(minDate)
                                        .maxDate(maxDate)
                                        .build(new DateSetListener() {
                                            @Override
                                            public void onDateSet(int id, @Nullable Calendar calendar, int day, int month, int year) {
                                                setDate(calendar);
                                            }
                                        })
                                        .show(getSupportFragmentManager(), "");
                                break;
                        }
                        return true;
                    }
                });
                popup.show();
            }
        });

        //**************************

        ////******custom slide menu*******////

        final DataModel[] drawerItem = new DataModel[5];
        drawerItem[0] = new DataModel(R.drawable.calendar_menu_icon, "مــاهــانه");
        drawerItem[1] = new DataModel(R.drawable.bus_icon, "خـــودرو");
        drawerItem[2] = new DataModel(R.drawable.report_icon, "پیشنهادات");
        drawerItem[3] = new DataModel(R.drawable.setting_icon, "تـنظیمـات");
        drawerItem[4] = new DataModel(R.drawable.about_us, "درباره مــا");
        //drawerItem[2] = new DataModel(R.drawable.report_icon, "ارسال گزارش");
        // drawerItem[3] = new DataModel(R.drawable.leave_icon, "درخواست مرخصی");
        // drawerItem[4] = new DataModel(R.drawable.news_icon, "اخبار و اعلانات");
        //drawerItem[5] = new DataModel(R.drawable.settings_icon, "تنظیمات");


        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.list_view_item_row, drawerItem);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ((DrawerLayout) findViewById(R.id.drawer_layout)).addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                // Whatever you want
                //Toast.makeText(getApplicationContext(),"onDrawerSlide",Toast.LENGTH_LONG).show();

                if (currentPageName.equals("MonthlyFragment")){
                    mDrawerList.getChildAt(0).setBackgroundColor(getResources().getColor(R.color.lightgray03));
                }else {
                    mDrawerList.getChildAt(0).setBackgroundColor(getResources().getColor(R.color.transparent));
                }

                if (currentPageName.equals("CarProfileFragment")){
                    mDrawerList.getChildAt(1).setBackgroundColor(getResources().getColor(R.color.lightgray03));
                }else {
                    mDrawerList.getChildAt(1).setBackgroundColor(getResources().getColor(R.color.transparent));
                }

                if (currentPageName.equals("CommentFragment")){
                    mDrawerList.getChildAt(2).setBackgroundColor(getResources().getColor(R.color.lightgray03));
                }else {
                    mDrawerList.getChildAt(2).setBackgroundColor(getResources().getColor(R.color.transparent));
                }

                if (currentPageName.equals("SettingsFragment")){
                    mDrawerList.getChildAt(3).setBackgroundColor(getResources().getColor(R.color.lightgray03));
                }else {
                    mDrawerList.getChildAt(3).setBackgroundColor(getResources().getColor(R.color.transparent));
                }

                if (currentPageName.equals("AboutFragment")){
                    mDrawerList.getChildAt(4).setBackgroundColor(getResources().getColor(R.color.lightgray03));
                }else {
                    mDrawerList.getChildAt(4).setBackgroundColor(getResources().getColor(R.color.transparent));
                }

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                // Whatever you want
                menuIcon.setBackgroundResource(R.mipmap.close_menu);
                System.out.println("======onDrawerOpened======");
            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
                // Whatever you want
                menuIcon.setBackgroundResource(R.mipmap.menu_icon);
                System.out.println("======currentPageName======" + currentPageName);
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                // Whatever you want
            }
        });


        // mDrawerLayout.setDrawerListener(mDrawerToggle);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeDrawer();
            }
        });

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            boolean loginIs = bundle.getBoolean("loginIs");
            boolean firstLogin = bundle.getBoolean("firstLogin");

            if (firstLogin) {
                fragmentTransaction(new PrivacyFragment(), "PrivacyFragment");
                closeDrawer();
                return;
            }

        }

        if (activePass == 1) {
            if (bundle != null) {
                boolean loginIs = bundle.getBoolean("loginIs");
                if (loginIs) {
                    //selectItem(0);
                    fragmentTransaction(new WeekDayFragment(), "WeekDayFragment");
                    EventBus.getDefault().post(new EventBusModel("WeekDayFragment"));
                    closeDrawer();
                    return;
                }
            }
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        } else {
            // selectItem(0);
            fragmentTransaction(new WeekDayFragment(), "WeekDayFragment");
            EventBus.getDefault().post(new EventBusModel("WeekDayFragment"));
            closeDrawer();
        }

        getInfo();
    }

    private void getJsonData() {

    }


    ////******pop up menu*******////
    private void callMenu(PopupMenu popup) {
        persianDate = new PersianDate();
        String dayNam = persianDate.dayName(sharedData.getYear(), sharedData.getMonth(), sharedData.getDay());
        String monthName = persianDate.monthName(sharedData.getMonth());
        String daily = dayNam + " " + sharedData.getDay() + " " + monthName;

        String weekly = sharedData.getWeekMenuDate();
        String monthly = String.valueOf(sharedData.getMonth());


        StringBuffer sbSpace = new StringBuffer();
        for (int i = 0; i <= daily.length(); i++) {
            sbSpace.append(" ");
        }

        String actionDay = "روزانه" + "         " + daily;
        // String actionWeek = "هفتگی" + "               " + Util.getWeek();
        String actionMonth = "ماهانه" + "        " + sbSpace + monthName;
        popup.getMenu().add(1, R.id.action_today, 1, Util.faToEn(actionDay));
        //popup.getMenu().add(1, R.id.action_week, 2, Util.faToEn(actionWeek));
        popup.getMenu().add(1, R.id.action_month, 3, Util.faToEn(actionMonth));
    }

  /*  public String getWeek() {

        int year = sharedData.getYear();
        int month = sharedData.getMonth();
        int day = sharedData.getDay();
        roozh.PersianToGregorian(year, month, day);
        calendar.set(roozh.getYear(), roozh.getMonth() - 1, roozh.getDay());
        NextPreWeekday = getWeekDay();
        firstDayOfWeek = CommonMethod.convertWeekDays(NextPreWeekday[0]);
        lastDayOfWeek = CommonMethod.convertWeekDays(NextPreWeekday[6]);
        TextView textViewDate = findViewById(R.id.textViewDate);
        return firstDayOfWeek + " " + CommonMethod.convertWeekDaysMouth(NextPreWeekday[0]) +
                "-" + lastDayOfWeek + " " + CommonMethod.convertWeekDaysMouth(NextPreWeekday[6]);}*/

/*    public String[] getWeekDay() {
        Calendar now = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String[] days = new String[7];

        selectStartWeek = CarApplication.getInstance().getSharedPreferences().getInt(Constant.SELECT_START_WEEKDAY, -1);

        switch (selectStartWeek) {
            case 1:
                delta = -calendar.get(GregorianCalendar.DAY_OF_WEEK);
                break;
            case 2:
                delta = -calendar.get(GregorianCalendar.DAY_OF_WEEK) + 1;
                break;
            case 3:
                delta = -calendar.get(GregorianCalendar.DAY_OF_WEEK) + 2;
                break;

            default:
                delta = -calendar.get(GregorianCalendar.DAY_OF_WEEK);
        }
        //calendar.add(Calendar.WEEK_OF_YEAR, -1);
        calendar.add(Calendar.DAY_OF_MONTH, delta);
        for (int i = 0; i < 7; i++) {
            days[i] = format.format(calendar.getTime());
            calendar.add(Calendar.DAY_OF_MONTH, 1);

        }
        return days;
    }*/



    /* init
     * */

    private void init() {
        String[] mNavigationDrawerItemTitles = getResources().getStringArray(R.array.nav_item_activity_titles);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        RelativeLayout relativeLayoutDrawer = (RelativeLayout) findViewById(R.id.RelativeLayout_drawer);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        menuIcon = (ImageView) findViewById(R.id.menuIcon_button);
        img_profile = findViewById(R.id.img_profile);
        calendarIcon = (Button) findViewById(R.id.calendar_icon);
        //spinner = (Spinner) findViewById(R.id.spinner);
        LinearLayout rLayout = (LinearLayout) findViewById(R.id.text);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout_selectMonth);
        calendarIconLayout = (RelativeLayout) findViewById(R.id.calendarIconLayout);
        spinner_txt = (TextView) findViewById(R.id.spinner_txt);
        txt_version = (TextView) findViewById(R.id.txt_version);
        TextView showDateName = (TextView) findViewById(R.id.showDateName_txt);

        dateConvertor = new DateConvertor();
        tmpDateConvertor = new DateConvertor();
        txt_version.setText(" شماره ورژن " + BuildConfig.VERSION_NAME);
        txt_version.setTextColor(Color.WHITE);
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
            //EventBus.getDefault().post(new EventBusModel("MonthlyFragment"));
        }
    }


    /*
     * select item for toolbar menu
     * */
    private void selectItem(int position) {

        //Spinner spinner;
        Fragment fragment = null;

        switch (position) {

            case 0:
                fragmentTransaction(new MonthlyFragment(), "MonthlyFragment");
                EventBus.getDefault().post(new EventBusModel("MonthlyFragment"));
                // Util.recognizeSelectedItems(Constant.RECOGNIZE, "ProfileFragment");
                break;

            case 1:
                fragmentTransaction(new CarProfileFragment(), "CarProfileFragment");
                EventBus.getDefault().post(new EventBusModel("CarProfileFragment"));
                // Util.recognizeSelectedItems(Constant.RECOGNIZE, "ProfileFragment");
                break;

            case 2:
                fragmentTransaction(new CommentFragment(), "CommentFragment");
                EventBus.getDefault().post(new EventBusModel("CommentFragment"));
                break;

            case 3:
                fragmentTransaction(new SettingsFragment(), "SettingsFragment");
                EventBus.getDefault().post(new EventBusModel("SettingsFragment"));
                break;

            case 4:
                fragmentTransaction(new AboutFragment(), "AboutFragment");
                EventBus.getDefault().post(new EventBusModel("AboutFragment"));
                break;
           /* case 1:
                fragmentTransaction(new ProfileFragment(), "ProfileFragment");
                EventBus.getDefault().post(new EventBusModel("ProfileFragment"));
                //Util.recognizeSelectedItems(Constant.RECOGNIZE, "CurrentFragment");
                break;

            case 2:
                fragmentTransaction(new ListReportFragment(), "ListReportFragment");
                EventBus.getDefault().post(new EventBusModel("ListReportFragment"));
                break;

            case 3:
                fragmentTransaction(new ListLeaveFragment(), "ListLeaveFragment");
                EventBus.getDefault().post(new EventBusModel("ListLeaveFragment"));
                break;

            case 4:
                fragmentTransaction(new NewsNotifyFragment(), "NewsNotifyFragment");
                EventBus.getDefault().post(new EventBusModel("NewsNotifyFragment"));
                //Util.recognizeSelectedItems(Constant.RECOGNIZE, "NewsNotifyFragment");
                break;

            case 5:
                fragmentTransaction(new SettingsFragment(), "SettingsFragment");
                EventBus.getDefault().post(new EventBusModel("SettingsFragment"));
                //Util.recognizeSelectedItems(Constant.RECOGNIZE, "SettingsFragment");
                break;
*/
        }
        //spinner.setSelection(0);
        closeDrawer();

    }

    private void closeDrawer() {
        if (mDrawerLayout.isDrawerOpen(Gravity.RIGHT)) {
            mDrawerLayout.closeDrawer(Gravity.RIGHT);

        } else {
            mDrawerLayout.openDrawer(Gravity.RIGHT);
        }
    }


    /*
     * method for goto fragment*/
    public void fragmentTransaction(Fragment fragment, final String subtitle) {
        if (fragment != null) {
            goToFragment(fragment);
        }
    }

    private void goToFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
        fragmentTransaction.replace(content_frame, fragment, fragment.getClass().getCanonicalName());
        fragmentTransaction.commit();
    }


    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(Gravity.RIGHT)) {
            mDrawerLayout.closeDrawer(Gravity.RIGHT);
            return;
        }

        if (currentPageName.equals("MonthlyFragment")) {

            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Util.showToast(MainActivity.this, R.string.exit_confirm, true);
            System.out.println("==Please click BACK again to exit==");

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);

        }

        System.out.println("currentPageName=====" + currentPageName);

        if (currentPageName.equals("")) {
            fragmentTransaction(new MonthlyFragment(), "MonthlyFragment");
            EventBus.getDefault().post(new EventBusModel("MonthlyFragment"));
            return;
        }

        if (currentPageName.equals("ReportFragment")) {
            fragmentTransaction(new ListReportFragment(), "ListReportFragment");
            EventBus.getDefault().post(new EventBusModel("ListReportFragment"));
            return;
        }

        if (currentPageName.equals("LeaveFragment")) {
            fragmentTransaction(new ListLeaveFragment(), "ListLeaveFragment");
            EventBus.getDefault().post(new EventBusModel("ListLeaveFragment"));
            return;
        }

        if (currentPageName.equals("CarProfileFragment")) {
            fragmentTransaction(new MonthlyFragment(), "MonthlyFragment");
            EventBus.getDefault().post(new EventBusModel("MonthlyFragment"));
            return;
        }

        if (currentPageName.equals("DriverProfileFragment")) {
            fragmentTransaction(new MonthlyFragment(), "MonthlyFragment");
            EventBus.getDefault().post(new EventBusModel("MonthlyFragment"));
            return;
        }

        if (currentPageName.equals("WeekDayFragment")) {
            fragmentTransaction(new MonthlyFragment(), "MonthlyFragment");
            EventBus.getDefault().post(new EventBusModel("MonthlyFragment"));
            return;
        }

        if (currentPageName.equals("CommentFragment")) {
            fragmentTransaction(new MonthlyFragment(), "MonthlyFragment");
            EventBus.getDefault().post(new EventBusModel("MonthlyFragment"));
            return;
        }

        if (currentPageName.equals("AboutFragment")) {
            fragmentTransaction(new MonthlyFragment(), "MonthlyFragment");
            EventBus.getDefault().post(new EventBusModel("MonthlyFragment"));
            return;
        }

        if (currentPageName.equals("SettingsFragment")) {
            fragmentTransaction(new MonthlyFragment(), "MonthlyFragment");
            EventBus.getDefault().post(new EventBusModel("MonthlyFragment"));
            return;
        }

        if (currentPageName.equals("PrivacyFragment")) {
            fragmentTransaction(new SettingsFragment(), "SettingsFragment");
            EventBus.getDefault().post(new EventBusModel("SettingsFragment"));
            return;
        }

        if (currentPageName.equals("UpdateFragment")) {
            fragmentTransaction(new SettingsFragment(), "SettingsFragment");
            EventBus.getDefault().post(new EventBusModel("SettingsFragment"));
            return;
        }

        if (currentPageName.equals("ZoomFragment")) {
            fragmentTransaction(new CarProfileFragment(), "CarProfileFragment");
            EventBus.getDefault().post(new EventBusModel("CarProfileFragment"));
            return;
        }
    }


    /*
     * set date for custom date piker
     * */
    private void setDate(final Calendar calendar) {
        if (calendar == null)
            return;

        JalaliCalendarUtil jalaliCalendarUtil = new JalaliCalendarUtil(calendar);
        sharedData.setYear(jalaliCalendarUtil.getIranianYear());
        sharedData.setMonth(jalaliCalendarUtil.getIranianMonth());
        sharedData.setDay(jalaliCalendarUtil.getIranianDay());
        sharedData.setSelectedMenuItem(Constant.ACTION_DAY);

        String checkClick = CarApplication.getInstance().getSharedPreferences().getString(Constants.checkClick, "");
        System.out.println("checkClick===" + checkClick);
        if (checkClick.equals("month")) {
            fragmentTransaction(new MonthlyFragment(), "MonthlyFragment");
            EventBus.getDefault().post(new EventBusModel("MonthlyFragment"));
        } else if (checkClick.equals("day")) {
            fragmentTransaction(new WeekDayFragment(), "WeekDayFragment");
            EventBus.getDefault().post(new EventBusModel("WeekDayFragment"));
        }


    }


    @Subscribe
    public void getEvent(EventBusModel model) {
        currentPageName = model.getCurrentPage();
        System.out.println("=========currentPageName=========" + currentPageName);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }


    private void getInfo() {


        String response = CarApplication.getInstance().getSharedPreferences().getString(Constants.RESPONSE, "");
        try {
            JSONObject resultJson = new JSONObject(response);
            if (!resultJson.isNull(Constants.SUCCESS_KEY)) {
                if (!resultJson.isNull(Constants.RESULT_KEY)) {
                    JSONObject resultJsonObject = resultJson.getJSONObject(Constants.RESULT_KEY);

                    if (!resultJsonObject.isNull("pictureBytes")) {
                        JSONArray pictureBytesJsonArray = resultJsonObject.getJSONArray("pictureBytes");
                        byte[] bytes = new byte[pictureBytesJsonArray.length()];
                        for (int i = 0; i < pictureBytesJsonArray.length(); i++) {
                            bytes[i] = Integer.valueOf(pictureBytesJsonArray.getInt(i)).byteValue();
                        }
                        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                        img_profile.setImageBitmap(bitmap);
                    } else {
                        img_profile.setBackgroundResource(R.drawable.driver_image_null);
                    }

                    TextView driverName_txt = findViewById(R.id.driverName);
                    TextView driverCode = findViewById(R.id.driverCode);

                    if (!resultJsonObject.isNull("driverProfileVO")) {
                        JSONObject driverProfileVOJsonObject = resultJsonObject.getJSONObject("driverProfileVO");
                        if (!driverProfileVOJsonObject.isNull("person")) {
                            JSONObject personJsonObject = driverProfileVOJsonObject.getJSONObject("person");
                            if (!personJsonObject.isNull("name")) {
                                driverName_txt.setText(personJsonObject.getString("name") + " " + personJsonObject.getString("family"));
                            }
                        }

                        if (!driverProfileVOJsonObject.isNull("driverCode")) {
                            driverCode.setText(driverProfileVOJsonObject.getString("driverCode"));
                        }

                        if (!driverProfileVOJsonObject.isNull("driverJob")) {
                            JSONObject driverJobJsonObject = driverProfileVOJsonObject.getJSONObject("driverJob");
                            if (!driverJobJsonObject.isNull("car")) {
                                JSONObject carJsonObject = driverJobJsonObject.getJSONObject("car");
                                if (!carJsonObject.isNull("propertyCode")) {
                                    System.out.println("propertyCode====" + carJsonObject.getString("propertyCode"));
                                    sharedData.setPropertyCode(carJsonObject.getString("propertyCode"));

                                    getAll(carJsonObject.getString("propertyCode"));
                                }
                            }
                        }

                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getCarInfo(final String propertyCode, final String userName, final String Password) {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATE_TIME_FORMAT);
        //progressbar.setVisibility(View.VISIBLE);
        ServerCoordinator.getInstance().getServerDateTime(new Response.Listener<ServerDateTimeResponseBean>() {
            @Override
            public void onResponse(ServerDateTimeResponseBean response) {
                //progressbar.setVisibility(View.GONE);
                try {
                    Date serverDateTime = simpleDateFormat.parse(response.getRESULT().getServerDateTime());
                    if (DateUtils.isValidDateDiff(new Date(), serverDateTime, Constants.VALID_SERVER_AND_DEVICE_TIME_DIFF)) {
                        //progressbar.setVisibility(View.VISIBLE);
                        ServerCoordinator.getInstance().getCarInfo(propertyCode, userName, Password,
                                new Response.Listener<CarProfileResultBean>() {
                                    @SuppressLint("SetTextI18n")
                                    @Override
                                    public void onResponse(CarProfileResultBean response) {

                                        if (response != null) {
                                            Gson gson = new Gson();
                                            String json = gson.toJson(response);
                                            sharedData.setCarInfo(json);
                                            System.out.println("=======json===========" + json);
                                        }
                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        Utils.showErrors(MainActivity.this, error);
                                    }
                                });

                    } else {
                        Utils.showToast(MainActivity.this, R.string.message_toast_invalidDateTime, false);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Utils.showErrors(MainActivity.this, error);
            }
        });
    }

    private void getAll(final String propertyCode) {
        class GetAllDriver extends AsyncTask<Void, Void, List<Driver>> {

            @Override
            protected List<Driver> doInBackground(Void... voids) {
                driverList = DataBaseClint.getInstance(MainActivity.this).getAppDataBase().driverDao().getAll();
                if (driverList.size() > 0) {
                    driver = driverList.get(0);
                    if (driver != null) {
                        getCarInfo(propertyCode, driver.getUsername(), driver.getPassword());
                    }
                }
                return driverList;
            }

            @Override
            protected void onPostExecute(List<Driver> drivers) {
                super.onPostExecute(drivers);
                System.out.println("drivers1111====" + drivers);

            }
        }
        new GetAllDriver().execute();
    }
}
