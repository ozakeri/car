package gap.com.car.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import gap.com.car.R;
import gap.com.car.app.CarApplication;
import gap.com.car.common.Constants;
import gap.com.car.database.DataBaseClint;
import gap.com.car.database.entity.Driver;
import gap.com.car.util.Constant;
import gap.com.car.util.Globals;
import gap.com.car.util.Util;
import gap.com.car.util.Utils;

//import com.google.firebase.analytics.FirebaseAnalytics;

public class LoginActivity extends AppCompatActivity {

    EditText inputUsername, inputPassword;
    Button btnConfirm,btn_forgot;
    private String strUsername, strPassword;
    Driver driver;
    TextView txt_createAccount;
    private Globals globals = Globals.getInstance();
    private boolean loginIs = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_local);

        inputPassword = (EditText) findViewById(R.id.input_password);
        inputUsername = (EditText) findViewById(R.id.input_username);
        btnConfirm = (Button) findViewById(R.id.btn_ok);
        btn_forgot = findViewById(R.id.btn_forgot);
        inputUsername.setEnabled(false);
        inputUsername.setSelection(inputUsername.length());
        inputPassword.setSelection(inputPassword.length());

        driver = new Driver();

        Util.setTypeFace(inputUsername);
        Util.setTypeFace(inputPassword);

        // Util.loginIs(Constant.LOGIN_IS, true);
        /*List<User> userList = databaseManager.listUsers();
        if (userList.isEmpty()) {
            startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
        }*/

        CarApplication application = (CarApplication) getApplication();
        driver = application.getCurrentUser();

        if (driver != null) {
            inputUsername.setText(driver.getUsername());
        } else {
            List<Driver> driverList = DataBaseClint.getInstance(LoginActivity.this).getAppDataBase().driverDao().getAll();
            if (driverList.isEmpty()) {

            } else {
                driver = driverList.get(0);
                inputUsername.setText(driver.getUsername());
                application.setCurrentUser(driver);
            }
        }


        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strPassword = Utils.farsiNumberReplacement(inputPassword.getText().toString());

                if (strPassword.isEmpty()) {
                    inputPassword.setError(getResources().getString(R.string.label_login_editText_warning));
                    Toast toast = Toast.makeText(LoginActivity.this, getResources().getString(R.string.label_login_editText_warning), Toast.LENGTH_SHORT);
                    Util.showToast1(toast, false);
                    toast.show();

                } else {
                    String LOCALPASS = CarApplication.getInstance().getSharedPreferences().getString(Constant.LOCALPASS, "");
                    if (strPassword.equals(LOCALPASS)) {
                        //startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("loginIs", loginIs);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast toast = Toast.makeText(LoginActivity.this, getResources().getString(R.string.label_login_clickOk_warning), Toast.LENGTH_SHORT);
                        Util.showToast1(toast, false);
                        toast.show();
                    }
                }
            }
        });

        btn_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = CarApplication.getInstance().getSharedPreferences().edit();
                editor.putBoolean(Constants.PREF_FORGOT_PASSWORD, true);
                editor.apply();
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });

    }

}
