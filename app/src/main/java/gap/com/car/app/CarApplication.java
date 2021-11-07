package gap.com.car.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.preference.PreferenceManager;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.RequiresApi;

import com.android.volley.RequestQueue;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Locale;

import gap.com.car.database.DataBaseClint;
import gap.com.car.database.entity.Driver;
import gap.com.car.enumtype.LoginStatusEn;
import gap.com.car.util.Utils;

/**
 * Created by GapCom on 12/05/2017.
 */
public class CarApplication extends Application {
    private static CarApplication instance;
    private final static String TAG = CarApplication.class.getCanonicalName();
    private int back_count = 0;
    public boolean isFirstTime = true;
    private Typeface typeFaceNormal = null;
    private Typeface typeFacePersian = null;
    private Typeface typeFaceSplash = null;
    private InputMethodManager inputMethodManager;
    private Driver currentDriver;
    private WindowManager windowManager;
    private ClipboardManager clipboardManager;
    private LocationManager locationManager;
    private static final String sBuildModel = Build.MODEL.toLowerCase();
    private RequestQueue requestQueue;
    private List<Driver> driverList;
    private Resources resources;

    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
    private Thread.UncaughtExceptionHandler handler = new Thread.UncaughtExceptionHandler() {
        @Override
        public void uncaughtException(Thread thread, Throwable throwable) {
            try {
                StringWriter errors = new StringWriter();
                throwable.printStackTrace(new PrintWriter(errors));
                String error = errors.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
            uncaughtExceptionHandler.uncaughtException(thread, throwable);
        }
    };


    public String getVersionName() {

        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return "0.0";
    }


    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        //MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        Locale.setDefault(new Locale("fa", "IR"));
        super.onCreate();
        instance = this;

        uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(handler);


        clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);

        Utils.printLogs("Build.MODEL = " + sBuildModel);
        Utils.printLogs("Build.VERSION.SDK = " + Build.VERSION.SDK_INT);
    }


    public static synchronized CarApplication getInstance() {
        return instance;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }


    public WindowManager getWindowManager() {
        return windowManager;
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public SharedPreferences getSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(this);
    }

    public static Context getContext() {
        return instance.getApplicationContext();
    }

    public void resetBackCount() {
        back_count = 0;
    }

    public int getBackCount() {
        return back_count;
    }

    public void increaseBackCount() {
        back_count++;
    }

    public String monthNameNum(String monthName) {
        return monthName
                .replace("فروردین", "01")
                .replace("اردیبهشت", "02")
                .replace("خرداد", "03")
                .replace("تیر", "04")
                .replace("مرداد", "05")
                .replace("شهریور", "06")
                .replace("مهر", "07")
                .replace("آبان", "08")
                .replace("آذر", "09")
                .replace("دی", "10")
                .replace("بهمن", "11")
                .replace("اسفند", "12");
    }

    public Typeface getNormalTypeFace() {
        if (typeFaceNormal == null) {
            typeFaceNormal = Typeface.createFromAsset(getContext().getAssets(), "YekanBakhBold.ttf");
        }

        return typeFaceNormal;
    }

    public Typeface getPersianTypeFace() {
        if (typeFacePersian == null) {
            typeFacePersian = Typeface.createFromAsset(getContext().getAssets(), "IRANSans(FaNum)_Light.ttf");
        }

        return typeFacePersian;
    }

    public Typeface getTypeFaceSplash() {
        if (typeFaceSplash == null) {
            typeFaceSplash = Typeface.createFromAsset(getContext().getAssets(), "EntezarC3_v2.0.1.ttf");
        }

        return typeFaceSplash;
    }

    public InputMethodManager getInputMethodManager() {
        return inputMethodManager;
    }


    public Driver getCurrentUser() {
        if (currentDriver == null) {
            getAll();
            Driver driver = null;
            if (driverList != null) {
                driver = driverList.get(0);
                if (driver.getLoginStatus().equals(LoginStatusEn.Registered.ordinal())) {
                    setCurrentUser(driver);
                }
            }
        }
        return currentDriver;
    }


    public void setCurrentUser(Driver currentDriver) {
        this.currentDriver = currentDriver;
    }


    private void getAll() {
        class GetAllDriver extends AsyncTask<Void, Void, List<Driver>> {

            @Override
            protected List<Driver> doInBackground(Void... voids) {
                driverList = DataBaseClint.getInstance(getContext()).getAppDataBase().driverDao().getAll();
                return driverList;
            }

            @Override
            protected void onPostExecute(List<Driver> personTimeOffs) {
                super.onPostExecute(personTimeOffs);


            }
        }
        new GetAllDriver().execute();
    }
    @RequiresApi(api = Build.VERSION_CODES.Q)
    public static boolean appIsRunning(Context ctx) {
        ActivityManager activityManager = (ActivityManager) ctx.getSystemService(Context.ACTIVITY_SERVICE);

        List<ActivityManager.RunningTaskInfo> tasks = activityManager.getRunningTasks(Integer.MAX_VALUE);

        for (ActivityManager.RunningTaskInfo task : tasks) {
            if (ctx.getPackageName().equalsIgnoreCase(task.baseActivity.getPackageName()))
                return true;
        }
        return false;
    }
}
