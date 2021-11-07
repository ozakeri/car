package gap.com.car.fragment;

import static gap.com.car.R.id.content_frame;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import gap.com.car.R;
import gap.com.car.app.CarApplication;
import gap.com.car.common.CalendarUtil;
import gap.com.car.common.Constants;
import gap.com.car.database.entity.Driver;
import gap.com.car.model.EventBusModel;
import gap.com.car.model.ServerDateTimeResponseBean;
import gap.com.car.model.carprofile.CarProfileResultBean;
import gap.com.car.services.ServerCoordinator;
import gap.com.car.util.DateUtils;
import gap.com.car.util.Globals;
import gap.com.car.util.Utils;
import gap.com.car.widget.CircularProgress;

public class CarProfileFragment extends Fragment {

    private TextView txt_status, txt_carName, txt_line, txt_carUsage, txt_companyProfit, txt_companyController, txt_insurance, txt_insuranceCopy, txt_technicalCheck, txt_technicalCheckCopy;
    private ImageView img_carImage;
    private List<Driver> driverList;
    private Driver driver;
    private Globals globals = Globals.getInstance();
    private CircularProgress progress_circular;
    private ScrollView scrollView;
    private Globals sharedData = Globals.getInstance();
    private String status, carName, line, carUsage, companyProfit, companyController, insurance, technicalCheck;
    private Bitmap bitmap;


    public CarProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.car_profile_fragment, container, false);

        txt_status = view.findViewById(R.id.txt_status);
        txt_carName = view.findViewById(R.id.txt_carName);
        txt_line = view.findViewById(R.id.txt_line);
        txt_carUsage = view.findViewById(R.id.txt_carUsage);
        txt_companyProfit = view.findViewById(R.id.txt_companyProfit);
        txt_companyController = view.findViewById(R.id.txt_companyController);
        txt_technicalCheck = view.findViewById(R.id.txt_technicalCheck);
        txt_technicalCheckCopy = view.findViewById(R.id.txt_technicalCheckCopy);
        txt_insurance = view.findViewById(R.id.txt_insurance);
        txt_insuranceCopy = view.findViewById(R.id.txt_insuranceCopy);
        img_carImage = view.findViewById(R.id.img_carImage);
        progress_circular = view.findViewById(R.id.progress_circular);
        scrollView = view.findViewById(R.id.scrollView);
        img_carImage.setImageResource(R.drawable.driver_image_null);
        progress_circular.setVisibility(View.VISIBLE);
        scrollView.setVisibility(View.GONE);

        getAll();

        img_carImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFragment(new ZoomFragment());
                EventBus.getDefault().post(new EventBusModel("ZoomFragment"));
            }
        });
        return view;
    }


    /*
     * get car info
     * */
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
                                        progress_circular.setVisibility(View.GONE);
                                        scrollView.setVisibility(View.VISIBLE);
                                        if (response != null) {
                                            Gson gson = new Gson();
                                            String json = gson.toJson(response);
                                            SharedPreferences.Editor editor = CarApplication.getInstance().getSharedPreferences().edit();
                                            editor.putString(Constants.CAR_PROFILE_RESPONSE, json);
                                            editor.apply();

                                            txt_status.setText(response.rESULT.car.carUsage.statusText);
                                            txt_carName.setText(response.rESULT.car.nameFv);
                                            txt_line.setText(response.rESULT.car.carUsage.line.nameFv);
                                            txt_carUsage.setText(response.rESULT.car.carUsage.usageTypeText);
                                            txt_companyProfit.setText(response.rESULT.car.carUsage.usageTypeText);
                                            txt_companyController.setText(response.rESULT.car.carUsage.line.lineCompanyController.company.nameFv);
                                            //txt_insurance.setText(response.rESULT.car.carOptionInsuranceFP.expireDate);
                                            //txt_technicalCheck.setText(response.rESULT.car.carOptionTechnicalCheckFP.expireDate);

                                            String strExpireDate = response.rESULT.car.carOptionInsuranceFP.expireDate;
                                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                                            Date expireDate = null;
                                            try {
                                                expireDate = simpleDateFormat.parse(strExpireDate);
                                                Date currentDate = new Date(System.currentTimeMillis());
                                                //String expireDateStr = CalendarUtil.datesDiff(getActivity(), currentDate, expireDate, "yMd");
                                                String expireDateStr = CalendarUtil.convertPersianDateTime(expireDate, "yyyy/MM/dd");
                                                int between = CalendarUtil.monthsBetween(currentDate, expireDate);

                                                if (between <= 2 && between >= 1) {
                                                    txt_insurance.setText(" ( " + between + " ماه تا پایان اعتبار " + " ) ");
                                                    txt_insurance.setTextColor(getResources().getColor(R.color.red));
                                                } else if (between < 1) {
                                                    String between1 = CalendarUtil.datesDiff(getActivity(), currentDate, expireDate, "d");
                                                    txt_insurance.setText(" ( " + between1 + " تا پایان اعتبار " + " ) ");
                                                    txt_insurance.setTextColor(getResources().getColor(R.color.red));
                                                }

                                            } catch (ParseException e) {
                                                e.printStackTrace();
                                            }

                                            strExpireDate = response.rESULT.car.carOptionTechnicalCheckFP.expireDate;
                                            simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                                            try {
                                                expireDate = simpleDateFormat.parse(strExpireDate);
                                                Date currentDate = new Date(System.currentTimeMillis());
                                                //String expireDateStr = CalendarUtil.datesDiff(getActivity(), currentDate, expireDate, "yMd");
                                                String expireDateStr = CalendarUtil.convertPersianDateTime(expireDate, "yyyy/MM/dd");

                                                int between = CalendarUtil.monthsBetween(currentDate, expireDate);
                                                if (between <= 2 && between >= 1) {
                                                    txt_technicalCheck.setText(" ( " + between + " ماه تا پایان اعتبار " + " ) ");
                                                    txt_technicalCheck.setTextColor(getResources().getColor(R.color.red));
                                                } else if (between < 1) {
                                                    String between1 = CalendarUtil.datesDiff(getActivity(), currentDate, expireDate, "d");
                                                    txt_technicalCheck.setText(" ( " + between1 + " تا پایان اعتبار " + " ) ");
                                                    txt_technicalCheck.setTextColor(getResources().getColor(R.color.red));
                                                }

                                            } catch (ParseException e) {
                                                e.printStackTrace();
                                            }


                                            try {

                                                if (response.rESULT.car.pictureAF != null && response.rESULT.car.pictureAF.getPictureBytes() != null) {
                                                    JSONArray pictureBytesJsonArray = new JSONArray();
                                                    for (int i : response.rESULT.car.pictureAF.getPictureBytes()) {
                                                        pictureBytesJsonArray.put(i);
                                                    }
                                                    byte[] bytes = new byte[pictureBytesJsonArray.length()];
                                                    for (int i = 0; i < pictureBytesJsonArray.length(); i++) {
                                                        bytes[i] = Integer.valueOf(pictureBytesJsonArray.getInt(i)).byteValue();
                                                    }

                                                    bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                                                    img_carImage.setImageBitmap(bitmap);
                                                    sharedData.setBitmap(bitmap);
                                                } else {
                                                    img_carImage.setBackgroundResource(R.drawable.driver_image_null);
                                                }

                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        Utils.showErrors(getActivity(), error);
                                        progress_circular.setVisibility(View.GONE);
                                    }
                                });

                    } else {
                        Utils.showToast(getActivity(), R.string.message_toast_invalidDateTime, false);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Utils.showErrors(getActivity(), error);
            }
        });
    }


    private void getAll() {
        //String response = CarApplication.getInstance().getSharedPreferences().getString(Constants.CAR_PROFILE_RESPONSE, "");
        String response = sharedData.getCarInfo();

        System.out.println("response=====" + response);

        if (response != null) {
            progress_circular.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
            if (!response.isEmpty()) {
                try {
                    JSONObject resultJson = new JSONObject(response);
                    if (!resultJson.isNull(Constants.SUCCESS_KEY)) {
                        if (!resultJson.isNull(Constants.RESULT_KEY)) {
                            JSONObject resultJsonObject = resultJson.getJSONObject(Constants.RESULT_KEY);
                            if (!resultJsonObject.isNull("car")) {
                                JSONObject carJsonObject = resultJsonObject.getJSONObject("car");

                                  if (!carJsonObject.isNull("pictureAF")) {
                                        JSONObject pictureAFJsonObject = carJsonObject.getJSONObject("pictureAF");
                                        if (!pictureAFJsonObject.isNull("pictureBytes")) {
                                            JSONArray pictureBytesJsonArray = pictureAFJsonObject.getJSONArray("pictureBytes");
                                            byte[] bytes = new byte[pictureBytesJsonArray.length()];
                                            for (int i = 0; i < pictureBytesJsonArray.length(); i++) {
                                                bytes[i] = Integer.valueOf(pictureBytesJsonArray.getInt(i)).byteValue();
                                            }
                                            bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                                            if (bitmap != null){
                                                img_carImage.setImageBitmap(bitmap);
                                                sharedData.setBitmap(bitmap);
                                                //img_carImage.setEnabled(false);
                                            }

                                        } else {
                                            img_carImage.setBackgroundResource(R.drawable.driver_image_null);
                                        }
                                    }

                                if (!carJsonObject.isNull("nameFv")) {
                                    carName = carJsonObject.getString("nameFv");
                                    System.out.println("carName====" + carName);
                                    txt_carName.setText(carName);
                                }
                                if (!carJsonObject.isNull("carUsage")) {
                                    JSONObject carUsageJsonObject = carJsonObject.getJSONObject("carUsage");
                                    if (!carUsageJsonObject.isNull("status_text")) {
                                        status = carUsageJsonObject.getString("status_text");
                                        System.out.println("status====" + status);
                                        txt_status.setText(status);
                                    }

                                    if (!carUsageJsonObject.isNull("line")) {
                                        JSONObject lineJsonObject = carUsageJsonObject.getJSONObject("line");
                                        if (!lineJsonObject.isNull("nameFv")) {
                                            line = lineJsonObject.getString("nameFv");
                                            System.out.println("line====" + line);
                                            txt_line.setText(line);
                                        }

                                        if (!lineJsonObject.isNull("lineCompanyController")) {
                                            JSONObject lineCompanyControllerJsonObject = lineJsonObject.getJSONObject("lineCompanyController");
                                            if (!lineCompanyControllerJsonObject.isNull("company")) {
                                                JSONObject companyControllerJsonObject = lineCompanyControllerJsonObject.getJSONObject("company");
                                                if (!companyControllerJsonObject.isNull("nameFv")) {
                                                    companyController = companyControllerJsonObject.getString("nameFv");
                                                    System.out.println("companyController====" + companyController);
                                                    txt_companyController.setText(companyController);
                                                }
                                            }
                                        }
                                    }

                                    if (!carUsageJsonObject.isNull("usageType_text")) {
                                        carUsage = carUsageJsonObject.getString("usageType_text");
                                        System.out.println("carUsage====" + carUsage);
                                        txt_carUsage.setText(carUsage);
                                    }

                                    if (!carJsonObject.isNull("carOptionInsuranceFP")) {
                                        JSONObject carOptionInsuranceFPJsonObject = carJsonObject.getJSONObject("carOptionInsuranceFP");

                                        if (!carOptionInsuranceFPJsonObject.isNull("expireDate")) {
                                            insurance = carOptionInsuranceFPJsonObject.getString("expireDate");

                                            String strExpireDate = insurance;

                                            System.out.println("strExpireDate====" + strExpireDate);

                                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                                            Date expireDate = null;
                                            try {
                                                expireDate = simpleDateFormat.parse(strExpireDate);
                                                Date currentDate = new Date(System.currentTimeMillis());
                                                int between = CalendarUtil.monthsBetween(currentDate, expireDate);


                                                System.out.println("between=====" + between);
                                                if (between > 1) {
                                                    txt_insurance.setVisibility(View.VISIBLE);
                                                    txt_insurance.setText(" ( " + between + " ماه تا پایان اعتبار " + " ) ");
                                                    txt_insurance.setTextColor(getResources().getColor(R.color.red));
                                                } else if (between < 1) {
                                                    txt_insurance.setVisibility(View.VISIBLE);
                                                    String between1 = CalendarUtil.datesDiff(getActivity(), currentDate, expireDate, "d");
                                                    txt_insurance.setText(" ( " + between1 + " تا پایان اعتبار " + " ) ");
                                                    txt_insurance.setTextColor(getResources().getColor(R.color.red));
                                                }

                                            } catch (ParseException e) {
                                                e.printStackTrace();
                                            }
                                        }

                                    }

                                      if (!carJsonObject.isNull("company")) {
                                            JSONObject companyJsonObject = carJsonObject.getJSONObject("company");
                                            if (!companyJsonObject.isNull("name")) {
                                                txt_companyProfit.setText(companyJsonObject.getString("name"));
                                            }
                                        }

                                    if (!carJsonObject.isNull("carOptionTechnicalCheckFP")) {
                                        JSONObject carOptionTechnicalCheckFPJsonObject = carJsonObject.getJSONObject("carOptionTechnicalCheckFP");
                                        if (!carOptionTechnicalCheckFPJsonObject.isNull("expireDate")) {
                                            technicalCheck = carOptionTechnicalCheckFPJsonObject.getString("expireDate");

                                            String strExpireDate = technicalCheck;
                                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                                            Date expireDate = null;
                                            try {
                                                expireDate = simpleDateFormat.parse(strExpireDate);
                                                Date currentDate = new Date(System.currentTimeMillis());
                                                //String expireDateStr = CalendarUtil.datesDiff(getActivity(), currentDate, expireDate, "yMd");
                                                String expireDateStr = CalendarUtil.convertPersianDateTime(expireDate, "yyyy/MM/dd");
                                                int between = CalendarUtil.monthsBetween(currentDate, expireDate);

                                                //txt_technicalCheck.setText(expireDateStr);
                                                //txt_technicalCheckCopy.setVisibility(View.GONE);

                                                System.out.println("========between======" + between);

                                                if (between >= 1) {
                                                    txt_technicalCheck.setVisibility(View.VISIBLE);
                                                    txt_technicalCheck.setText(" ( " + between + " ماه تا پایان اعتبار " + " ) ");
                                                    txt_technicalCheck.setTextColor(getResources().getColor(R.color.red));
                                                } else if (between < 1) {

                                                    txt_technicalCheck.setVisibility(View.VISIBLE);
                                                    String between1 = CalendarUtil.datesDiff(getActivity(), currentDate, expireDate, "d");
                                                    txt_technicalCheck.setText(" ( " + between1 + " تا پایان اعتبار " + " ) ");
                                                    txt_technicalCheck.setTextColor(getResources().getColor(R.color.red));
                                                }

                                            } catch (ParseException e) {
                                                e.printStackTrace();
                                            }
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
        }

        // private String status, carName, line, carUsage, companyProfit, companyController, insurance, technicalCheck;
     /*   txt_status.setText(status);
        txt_carName.setText(carName);
        txt_line.setText(line);
        txt_carUsage.setText(carUsage);
        txt_companyController.setText(companyController);
        txt_companyProfit.setText(companyProfit);
        txt_insurance.setText(insurance);
        txt_technicalCheck.setText(technicalCheck);*/

    }

    private void goToFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
        fragmentTransaction.replace(content_frame, fragment, fragment.getClass().getCanonicalName());
        fragmentTransaction.commit();
    }
}
