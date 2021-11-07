package gap.com.car.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import gap.com.car.R;
import gap.com.car.SplashActivity;
import gap.com.car.app.CarApplication;
import gap.com.car.common.Constants;
import gap.com.car.database.DataBaseClint;
import gap.com.car.database.entity.Driver;
import gap.com.car.enumtype.LoginStatusEn;
import gap.com.car.model.ServerDateTimeResponseBean;
import gap.com.car.model.VerifyCodeResponseBean;
import gap.com.car.services.ServerCoordinator;
import gap.com.car.util.Constant;
import gap.com.car.util.DateUtils;
import gap.com.car.util.Globals;
import gap.com.car.util.Util;
import gap.com.car.util.Utils;
import gap.com.car.widget.CircularProgress;

//import com.google.firebase.analytics.FirebaseAnalytics;

public class ActivationActivity extends AppCompatActivity {

    EditText _activationCode;
    Button _signupButton;
    private CircularProgress progressbar;
    private String code;
    private CarApplication application;
    private Driver driver;
    private Globals globals = Globals.getInstance();
    private boolean isForget;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //FirebaseAnalytics.getInstance(this);

        progressbar = (CircularProgress) findViewById(R.id.progressbar);
        progressbar.setVisibility(View.GONE);

        _activationCode = (EditText) findViewById(R.id.input_activationCode);
        _signupButton = (Button) findViewById(R.id.btn_signup);
        isForget = CarApplication.getInstance().getSharedPreferences().getBoolean(Constant.FORGOT_PASSWORD, false);

        showDialog();

        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                login();
            }
        });

    }

    public void login() {
        code = _activationCode.getText().toString();
        if (code.isEmpty()) {
            _activationCode.setError(getResources().getString(R.string.label_login_editText_warning));
            Toast toast = Toast.makeText(ActivationActivity.this, getResources().getString(R.string.label_login_clickOk_warning), Toast.LENGTH_SHORT);
            Util.showToast1(toast, false);
            toast.show();
            return;
        }

        if (isForget) {
            Intent intent = new Intent(ActivationActivity.this, PasswordCreationActivity.class);
            startActivity(intent);
            SharedPreferences.Editor editor = CarApplication.getInstance().getSharedPreferences().edit();
            editor.putBoolean(Constants.PREF_FORGOT_PASSWORD, false);
            editor.apply();
            return;
        }

        isDeviceDateTimeValid();

    }

    /*DateTimeValid and call verifyCode
     * */
    private void isDeviceDateTimeValid() {
        application = (CarApplication) getApplication();
        final String mobilNo = globals.getMobileNo();

        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATE_TIME_FORMAT);
        progressbar.setVisibility(View.VISIBLE);
        ServerCoordinator.getInstance().getServerDateTime(new Response.Listener<ServerDateTimeResponseBean>() {
            @Override
            public void onResponse(ServerDateTimeResponseBean response) {
                progressbar.setVisibility(View.GONE);
                try {
                    Date serverDateTime = simpleDateFormat.parse(response.getRESULT().getServerDateTime());
                    if (DateUtils.isValidDateDiff(new Date(), serverDateTime, Constants.VALID_SERVER_AND_DEVICE_TIME_DIFF)) {
                        progressbar.setVisibility(View.VISIBLE);
                        ServerCoordinator.getInstance().verifyCode(mobilNo, code,
                                new Response.Listener<VerifyCodeResponseBean>() {
                                    @Override
                                    public void onResponse(VerifyCodeResponseBean response) {
                                        progressbar.setVisibility(View.GONE);

                                        if (response != null) {

                                            Gson gson = new Gson();
                                            String json = gson.toJson(response);

                                            SharedPreferences.Editor editor = CarApplication.getInstance().getSharedPreferences().edit();
                                            editor.putString(Constants.licence, response.getRESULT().getDriverProfileVO().getLicence().getExpireDate());
                                            editor.putString(Constants.RESPONSE, json);
                                            editor.apply();

                                            insertDriver(response);
                                            application.setCurrentUser(driver);
                                        }
                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        progressbar.setVisibility(View.GONE);
                                        Utils.showErrors(ActivationActivity.this, error);
                                    }
                                });

                    } else {
                        Utils.showToast(ActivationActivity.this, "تاریخ دستگاه نامعتبر است", false);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Utils.showErrors(ActivationActivity.this, error);

            }
        });
    }


    /*
     * showDialog for show phone number
     * */
    public void showDialog() {
        final Dialog alert = new Dialog(ActivationActivity.this);
        alert.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alert.setContentView(R.layout.custom_dialog_activation);

        TextView txt_mobileNo = alert.findViewById(R.id.txt_mobileNo);
        String s = globals.getMobileNo();
        System.out.println("sssssss====" + s.substring(s.length() - 4));
        txt_mobileNo.setText(" کد فعالسازی برای شماره " + s.substring(s.length() - 4) + "*******" + " ارسال شده است ");
        alert.findViewById(R.id.layout_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.dismiss();
            }
        });

        alert.show();
    }

    /*
     * insertDriver from response
     * */
    public void insertDriver(final VerifyCodeResponseBean response) {
        class InsertDriver extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                Driver driver = new Driver();
                driver.setServerUserId(Integer.valueOf(response.getRESULT().getDriverId()));
                driver.setName(response.getRESULT().getName());
                driver.setFamily(response.getRESULT().getFamily());
                driver.setUsername(response.getRESULT().getUsername());
                driver.setPassword(response.getRESULT().getPassword());
                driver.setCompanyName(response.getRESULT().getCompanyName());
                driver.setDriverCode(response.getRESULT().getDriverCode());
                driver.setCarId(Integer.valueOf(response.getRESULT().getCarId()));
                driver.setLoginStatus(LoginStatusEn.PasswordCreation.ordinal());
                DataBaseClint.getInstance(ActivationActivity.this).getAppDataBase().driverDao().insertDriver(driver);


                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);

                //startActivity(new Intent(ActivationActivity.this, WelcomeActivity.class));
                startActivity(new Intent(ActivationActivity.this, SplashActivity.class));
                SharedPreferences.Editor editor = CarApplication.getInstance().getSharedPreferences().edit();
                editor.putBoolean(Constants.WDF_SHOW_CASE_VIEW_FOR_FIRST, true);
                editor.putBoolean(Constants.PRIVACY_SHOW_CASE_VIEW_FOR_FIRST, true);
                editor.putBoolean(Constants.REPORT_SHOW_CASE_VIEW_FOR_FIRST, true);
                editor.apply();
                finish();
            }
        }

        new InsertDriver().execute();
    }

}