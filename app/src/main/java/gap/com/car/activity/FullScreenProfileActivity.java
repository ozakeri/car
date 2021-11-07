package gap.com.car.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import gap.com.car.R;
import gap.com.car.util.Globals;

public class FullScreenProfileActivity extends AppCompatActivity {

    ImageView img_profile;
    TextView driverName, liceExpire, driverCompany, driverSift, driverCar, driverLiceType;
    Globals sharedData = Globals.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_full_screen_profile);


        String liceName = sharedData.getLiceName();
        String[] parts = liceName.split("-");
        String first = parts[0];
        String second = parts[1];

        img_profile = findViewById(R.id.img_profile);
        driverName = findViewById(R.id.driverName);
        liceExpire = findViewById(R.id.liceExpire);
        driverCompany = findViewById(R.id.driverCompany);
        driverSift = findViewById(R.id.driverSift);
        driverCar = findViewById(R.id.driverCar);
        driverLiceType = findViewById(R.id.driverLiceType);

        JSONArray pictureBytesJsonArray = sharedData.getPictureByte();
        byte[] bytes = new byte[pictureBytesJsonArray.length()];
        for (int i = 0; i < pictureBytesJsonArray.length(); i++) {
            try {
                bytes[i] = Integer.valueOf(pictureBytesJsonArray.getInt(i)).byteValue();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        img_profile.setImageBitmap(bitmap);

        driverName.setText(sharedData.getName());
        liceExpire.setText(second);
        driverCompany.setText(sharedData.getCompanyName());
        driverCar.setText(sharedData.getCarName());

        int shiftType = sharedData.getSiftType();
        String str_shiftType = null;
        switch (shiftType) {
            case 0:
                str_shiftType = getResources().getString(R.string.label_shiftType_Morning);
                break;

            case 1:
                str_shiftType = getResources().getString(R.string.label_shiftType_Afternoon);
                break;

            case 2:
                str_shiftType = getResources().getString(R.string.label_shiftType_Night);
                break;

            case 3:
                str_shiftType = getResources().getString(R.string.label_shiftType_Other);
                break;

            case 4:
                str_shiftType = getResources().getString(R.string.label_shiftType_General);
                break;

            case 5:
                str_shiftType = getResources().getString(R.string.label_shiftType_MidDay);
                break;
        }
        driverSift.setText(str_shiftType);

        int licType = sharedData.getLiceType();
        String str_licType = null;
        switch (licType) {
            case 0:
                str_licType = getResources().getString(R.string.label_DrivingLicTypeEn1);
                break;

            case 1:
                str_licType = getResources().getString(R.string.label_DrivingLicTypeEn2);
                break;

            case 2:
                str_licType = getResources().getString(R.string.label_DrivingLicTypeEn3);
                break;

            case 3:
                str_licType = getResources().getString(R.string.label_DrivingLicTypeEn4);
                break;

            case 4:
                str_licType = getResources().getString(R.string.label_DrivingLicTypeEn5);
                break;

            case 5:
                str_licType = getResources().getString(R.string.label_DrivingLicTypeEn6);
                break;

            case 6:
                str_licType = getResources().getString(R.string.label_DrivingLicTypeEn7);
                break;
        }
        driverLiceType.setText(str_licType);

    }
}
