package gap.com.car.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import gap.com.car.R;
import gap.com.car.app.CarApplication;
import gap.com.car.common.CalendarUtil;
import gap.com.car.common.Constants;
import gap.com.car.gapcalendar.customweekview.PersianDate;
import gap.com.car.model.DriverProfileResponseBean;
import gap.com.car.model.driverprofile.DriverProfile;
import gap.com.car.util.Globals;
import gap.com.car.util.Utils;

import static gap.com.car.R.id.content_frame;

public class DriverProfileFragment extends Fragment {

    private TextView txt_driverCode,txt_driverName, txt_nationalNo, txt_mobileNo, txt_phoneNo, txt_liceNo, txt_expDate, txt_insuranceNo, txt_address, txt_between, txt_postalCode, txt_loginDate;
    private ImageView img_editProfile;
    private CircleImageView img_driverImage;
    private Globals globals = Globals.getInstance();

    public DriverProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.driver_profile_fragment, container, false);

        txt_driverName = (TextView) view.findViewById(R.id.txt_driverName);
        txt_nationalNo = (TextView) view.findViewById(R.id.txt_nationalNo);
        txt_mobileNo = (TextView) view.findViewById(R.id.txt_mobileNo);
        txt_phoneNo = (TextView) view.findViewById(R.id.txt_phoneNo);
        txt_liceNo = (TextView) view.findViewById(R.id.txt_liceNo);
        txt_expDate = (TextView) view.findViewById(R.id.txt_expDate);
        txt_insuranceNo = (TextView) view.findViewById(R.id.txt_insuranceNo);
        txt_address = (TextView) view.findViewById(R.id.txt_address);
        txt_between = (TextView) view.findViewById(R.id.txt_between);
        txt_postalCode = (TextView) view.findViewById(R.id.txt_postalCode);
        txt_loginDate = (TextView) view.findViewById(R.id.txt_loginDate);
        img_driverImage = (CircleImageView) view.findViewById(R.id.img_driverImage);
        img_editProfile = (ImageView) view.findViewById(R.id.img_editProfile);
        txt_driverCode = (TextView) view.findViewById(R.id.txt_driverCode);

        PersianDate persianDate = new PersianDate();
        txt_loginDate.setText(persianDate.dayName() + " " + persianDate.getShYear() + "/" + persianDate.getShMonth() + "/" + persianDate.getShDay() + " ساعت " + persianDate.getHour() + ":" + persianDate.getMinute());


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
                        img_driverImage.setImageBitmap(bitmap);
                    }else {
                        img_driverImage.setBackgroundResource(R.drawable.driver_image_null);
                    }

                    if (!resultJsonObject.isNull("licenceNo")) {
                        txt_liceNo.setText(resultJsonObject.getString("licenceNo"));
                    }


                    if (!resultJsonObject.isNull("driverProfileVO")) {
                        System.out.println("driverProfileVO====" + resultJsonObject.getString("driverProfileVO"));

                        JSONObject driverProfileVOJsonObject = resultJsonObject.getJSONObject("driverProfileVO");

                        if (!driverProfileVOJsonObject.isNull("driverCode")){
                            txt_driverCode.setText(driverProfileVOJsonObject.getString("driverCode"));
                        }

                        if (!driverProfileVOJsonObject.isNull("person")) {
                            JSONObject personJsonObject = driverProfileVOJsonObject.getJSONObject("person");
                            if (!personJsonObject.isNull("name")) {
                                txt_driverName.setText(personJsonObject.getString("name") + " " + personJsonObject.getString("family"));
                            }

                            if (!personJsonObject.isNull("nationalCode")) {
                                txt_nationalNo.setText(personJsonObject.getString("nationalCode"));
                            }

                            if (!personJsonObject.isNull("insuranceNo")) {
                                txt_insuranceNo.setText(personJsonObject.getString("insuranceNo"));
                            }



                            if (!personJsonObject.isNull("address")) {
                                JSONObject addressJsonObject = personJsonObject.getJSONObject("address");
                                if (!addressJsonObject.isNull("mobileNo")) {
                                    txt_mobileNo.setText(addressJsonObject.getString("mobileNo"));
                                }

                                if (!addressJsonObject.isNull("telNo")) {
                                    txt_phoneNo.setText(addressJsonObject.getString("telNo"));
                                }

                                if (!addressJsonObject.isNull("address")) {
                                    txt_address.setText(addressJsonObject.getString("address"));
                                }

                                if (!addressJsonObject.isNull("postalCode")) {
                                    txt_postalCode.setText(addressJsonObject.getString("postalCode"));
                                }
                            }

                        }

                        if (!driverProfileVOJsonObject.isNull("licence")) {
                            System.out.println("licence==-=-=-=-=-" + driverProfileVOJsonObject.getString("licence"));
                            JSONObject licenceJsonObject = driverProfileVOJsonObject.getJSONObject("licence");

                            if (!licenceJsonObject.isNull("expireDate")) {
                                String strExpireDate = licenceJsonObject.getString("expireDate");
                                System.out.println("strExpireDate========" + strExpireDate);
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                                Date expireDate = null;
                                try {
                                    expireDate = simpleDateFormat.parse(strExpireDate);
                                    Date currentDate = new Date(System.currentTimeMillis());
                                    String expireDateStr = CalendarUtil.convertPersianDateTime(expireDate, "yyyy/MM/dd");
                                    System.out.println("expireDateStr========" + expireDateStr);
                                    int between = CalendarUtil.monthsBetween(currentDate, expireDate);

                                    txt_expDate.setText(expireDateStr);
                                    if (between <= 2) {
                                        txt_between.setText(" ( " + between + " ماه تا پایان اعتبار " + " ) ");
                                    }

                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        }

                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        img_editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new EditProfileFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
                fragmentTransaction.replace(content_frame, fragment, fragment.getClass().getCanonicalName());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        return view;
    }

}
