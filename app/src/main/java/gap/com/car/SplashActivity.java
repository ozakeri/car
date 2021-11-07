package gap.com.car;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import gap.com.car.activity.MainActivity;
import gap.com.car.activity.RegistrationActivity;
import gap.com.car.app.CarApplication;
import gap.com.car.common.Constants;
import gap.com.car.database.DataBaseClint;
import gap.com.car.database.entity.Driver;
import gap.com.car.model.DriverProfileResponseBean;
import gap.com.car.model.ServerDateTimeResponseBean;
import gap.com.car.services.MyFirebaseMessagingService;
import gap.com.car.services.ServerCoordinator;
import gap.com.car.util.DateUtils;
import gap.com.car.util.Globals;
import gap.com.car.util.Utils;
import gap.com.car.widget.CircularProgress;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4000;
    private boolean isConnect = false;
    private CircularProgress progress_circular;
    private String token;
    private List<Driver> driverList;
    private Driver driver;
    private CarApplication application;
    private Globals sharedData = Globals.getInstance();
    private boolean stop = false;
    private boolean firstLogin = false;
    private AppCompatTextView txt_description;
    private Globals globals = Globals.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        txt_description = findViewById(R.id.txt_description);

        txt_description.setTypeface(CarApplication.getInstance().getTypeFaceSplash());
        SharedPreferences prefs = getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE);
        String name = prefs.getString("action", "No name defined");//"No name defined" is the default value.
        System.out.println("name====" + name);

        SharedPreferences.Editor editor1 = CarApplication.getInstance().getSharedPreferences().edit();
        editor1.putBoolean("firstLogin", false);
        editor1.apply();

        progress_circular = findViewById(R.id.progress_circular);
        progress_circular.setVisibility(View.GONE);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                callService();

                SharedPreferences.Editor editor = getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE).edit();
                editor.putString("action", null);
                editor.apply();
            }
        }, 3000);


    }

    private void callService() {
        if (Utils.isConnected(SplashActivity.this)) {

            token = MyFirebaseMessagingService.getToken();

            if (token == null || token.isEmpty()) {
                FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(new OnSuccessListener<InstanceIdResult>() {
                    @Override
                    public void onSuccess(InstanceIdResult instanceIdResult) {
                        // String token = instanceIdResult.getToken();
                        SharedPreferences.Editor editor = CarApplication.getInstance().getSharedPreferences().edit();
                        editor.putString(Constants.FIRE_BASE_TOKEN, instanceIdResult.getToken());
                        editor.apply();

                        token = instanceIdResult.getToken();
                        System.out.println("token111====" + token);

                        if (token != null) {
                            getToken(token);
                        }

                    }
                });
            } else {

                System.out.println("token222====" + token);
                if (token != null) {
                    getToken(token);
                }
            }

            getAll();


        } else {
            Utils.showToast(SplashActivity.this, R.string.error_noConnection, false);
        }
    }

    /*
     * get car info
     * */
    private void getDriverProfileInfo(final String userName, final String Password) {

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
                        ServerCoordinator.getInstance().getDriverProfileInfo(userName, Password,
                                new Response.Listener<DriverProfileResponseBean>() {
                                    @SuppressLint("SetTextI18n")
                                    @Override
                                    public void onResponse(DriverProfileResponseBean response) {

                                        if (response != null) {
                                            // jsonDate.setResponse(response);
                                            sharedData.setResponse(response);

                                            Intent i = new Intent(SplashActivity.this, MainActivity.class);
                                            i.putExtra("firstLogin", firstLogin);
                                            startActivity(i);
                                            finish();
                                        }
                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        Utils.showErrors(SplashActivity.this, error);
                                    }
                                });

                    } else {
                        Utils.showToast(SplashActivity.this, R.string.message_toast_invalidDateTime, false);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Utils.showErrors(SplashActivity.this, error);
            }
        });
    }

    /*
     * get all car from db
     * */
    private void getAll() {
        class GetAllDriver extends AsyncTask<Void, Void, List<Driver>> {

            @Override
            protected List<Driver> doInBackground(Void... voids) {
                driverList = DataBaseClint.getInstance(SplashActivity.this).getAppDataBase().driverDao().getAll();
                if (driverList.size() > 0) {
                    driver = driverList.get(0);
                    if (driver != null) {
                        application = (CarApplication) getApplication();
                        application.setCurrentUser(driver);
                        if (Utils.isConnected(SplashActivity.this)) {
                            Intent i = new Intent(SplashActivity.this, MainActivity.class);
                            i.putExtra("firstLogin", firstLogin);
                            startActivity(i);
                            finish();

                        } else {
                            Utils.showToast(SplashActivity.this, R.string.error_noConnection, false);
                        }
                    }
                } else {
                    Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
                    startActivity(intent);
                    finish();
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

    public void getToken(String token) {

        ServerCoordinator.getInstance().updateFirebaseTokenId(token, new Response.Listener() {
            @Override
            public void onResponse(Object response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }
}
