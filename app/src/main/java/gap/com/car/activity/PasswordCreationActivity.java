package gap.com.car.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import gap.com.car.R;
import gap.com.car.util.Constant;
import gap.com.car.util.Util;
import gap.com.car.util.Utils;

//import com.google.firebase.analytics.FirebaseAnalytics;

public class PasswordCreationActivity extends AppCompatActivity {

    EditText inputUsername, inputPassword;
    Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_creation);

        inputPassword = (EditText) findViewById(R.id.input_password);
        inputUsername = (EditText) findViewById(R.id.input_username);
        btnConfirm = (Button) findViewById(R.id.btn_ok);

        inputUsername.setSelection(inputUsername.length());
        inputPassword.setSelection(inputPassword.length());

        Util.setTypeFace(inputUsername);
        Util.setTypeFace(inputPassword);


        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String passwordStr = Utils.farsiNumberReplacement(inputUsername.getText().toString());
                String confirmStr = Utils.farsiNumberReplacement(inputPassword.getText().toString());

                Util.loginIs(Constant.LOGIN_IS, true);
                if (TextUtils.isEmpty(passwordStr)) {
                    inputUsername.setError(getResources().getString(R.string.label_login_editText_warning));
                    Toast toast = Toast.makeText(PasswordCreationActivity.this, getResources().getString(R.string.label_login_editText_warning), Toast.LENGTH_SHORT);
                    Util.showToast1(toast, false);
                    toast.show();
                } else if (TextUtils.isEmpty(confirmStr)) {
                    inputPassword.setError(getResources().getString(R.string.label_login_editText_warning));
                    Toast toast = Toast.makeText(PasswordCreationActivity.this, getResources().getString(R.string.label_login_editText_warning), Toast.LENGTH_SHORT);
                    Util.showToast1(toast, false);
                    toast.show();
                } else if (passwordStr.equals(confirmStr)) {
                    Util.recognizeSwitchLocalPassword(Constant.SELECT_CONFIRM_LOCALPASS, 1);
                    System.out.println("passwordStr.equals(confirmStr)");
                    Util.recognizeInputLocalPassword(Constant.LOCALPASS, passwordStr);
                    Util.recognizeInputLocalPassword(Constant.LOCALPASSCONFIRM, confirmStr);
                    Toast toast = Toast.makeText(PasswordCreationActivity.this, getResources().getString(R.string.label_login_editText_ok), Toast.LENGTH_SHORT);
                    Util.showToast1(toast, true);
                    toast.show();
                    startActivity(new Intent(PasswordCreationActivity.this, MainActivity.class));
                    finish();
                } else {
                    Toast toast = Toast.makeText(PasswordCreationActivity.this, getResources().getString(R.string.label_login_clickOk_warning), Toast.LENGTH_SHORT);
                    Util.showToast1(toast, false);
                    toast.show();
                }
            }
        });

    }

}
