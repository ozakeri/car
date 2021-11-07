package gap.com.car.activity;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import gap.com.car.R;
import gap.com.car.common.Constants;
import gap.com.car.model.ServerDateTimeResponseBean;
import gap.com.car.model.SuccessResponseBean;
import gap.com.car.services.ServerCoordinator;
import gap.com.car.util.DateUtils;
import gap.com.car.util.Globals;
import gap.com.car.util.Utils;
import gap.com.car.widget.CircularProgress;

//import com.google.firebase.analytics.FirebaseAnalytics;

public class RegistrationActivity extends AppCompatActivity {
    private static final String TAG = "RegistrationActivity";
    private static final int REQUEST_SIGNUP = 0;

    EditText input_personalCode;
    Button loginButton;
    String personalCode;
    private CircularProgress progressbar;
    private Globals globals = Globals.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //FirebaseAnalytics.getInstance(this);

        loginButton = (Button) findViewById(R.id.btn_login);
        input_personalCode = (EditText) findViewById(R.id.input_personalCode);

        progressbar = (CircularProgress) findViewById(R.id.progressbar);
        progressbar.setVisibility(View.GONE);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    public void register() {
        personalCode = input_personalCode.getText().toString();

        if (personalCode.isEmpty()) {
            input_personalCode.setError(getResources().getString(R.string.label_login_editText_warning));
        } else {
            isDeviceDateTimeValid();
        }
    }

    private void isDeviceDateTimeValid() {
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
                        ServerCoordinator.getInstance().sendCode(personalCode,
                                new Response.Listener<SuccessResponseBean>() {
                                    @Override
                                    public void onResponse(SuccessResponseBean response) {
                                        progressbar.setVisibility(View.GONE);
                                        globals.setMobileNo(response.getRESULT().getMobileNo());
                                        enter();
                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        progressbar.setVisibility(View.GONE);
                                        Utils.showErrors(RegistrationActivity.this, error);
                                    }
                                });

                    } else {
                        Utils.showToast(RegistrationActivity.this, R.string.message_toast_invalidDateTime, false);
                        progressbar.setVisibility(View.GONE);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Utils.showErrors(RegistrationActivity.this, error);
                System.out.println("ERROR====" + error.toString());
                progressbar.setVisibility(View.GONE);
            }
        });
    }

    public void enter() {
        Intent intent = new Intent(getApplicationContext(), ActivationActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // Disable going back to the
        moveTaskToBack(true);
    }
}
