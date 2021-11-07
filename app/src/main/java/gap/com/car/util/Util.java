package gap.com.car.util;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.net.NetworkInterface;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import gap.com.car.R;
import gap.com.car.app.CarApplication;
import gap.com.car.common.Constants;
import gap.com.car.gapcalendar.customweekview.Roozh;
import gap.com.car.gapcalendar.customweekview.CommonMethod;
import gap.com.car.model.DeviceBean;
import gap.com.car.model.RequestBaseBean;

import static gap.com.car.app.CarApplication.getContext;

/**
 * Created by GapCom on 12/26/2017.
 */

public class Util {

    private static Calendar calendar = Calendar.getInstance();
    private static String[] persianNumbers = new String[]{"۰", "۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹"};
    private static String token;

    private static final String[] numNames = {
            "",
            " فروردین",
            " اردیبهشت",
            " خرداد",
            " تیر",
            " مرداد",
            " شهریور",
            " مهر",
            " آبان",
            " آذر",
            " دی",
            " بهمن",
            " اسفند"
    };

    public static void recognizeSelectedItems(String str1, String str2) {
        SharedPreferences.Editor editor = CarApplication.getInstance().getSharedPreferences().edit();
        editor.putString(str1, str2);
        editor.apply();
    }

    public static void recognizeSelectedDayOfWeek(String str1, int num) {
        SharedPreferences.Editor editor = CarApplication.getInstance().getSharedPreferences().edit();
        editor.putInt(str1, num);
        editor.apply();
    }

    public static void recognizeSwitchLocalPassword(String str1, int num) {
        SharedPreferences.Editor editor = CarApplication.getInstance().getSharedPreferences().edit();
        editor.putInt(str1, num);
        editor.apply();
    }

    public static void recognizeInputLocalPassword(String str1, String str2) {
        SharedPreferences.Editor editor = CarApplication.getInstance().getSharedPreferences().edit();
        editor.putString(str1, str2);
        editor.apply();
    }

    public static void loginIs(String str1, boolean b) {
        SharedPreferences.Editor editor = CarApplication.getInstance().getSharedPreferences().edit();
        editor.putBoolean(str1, b);
        editor.apply();
    }

    public static void saveCustomDate(String str1, int num) {
        SharedPreferences.Editor editor = CarApplication.getInstance().getSharedPreferences().edit();
        editor.putInt(str1, num);
        editor.apply();
    }

    public static String getMonthName(String monthName) {
        return monthName
                .replace("1", "فروردین")
                .replace("2", "اردیبهشت")
                .replace("3", "خرداد")
                .replace("4", "تیر")
                .replace("5", "مرداد")
                .replace("6", "شهریور")
                .replace("7", "مهر")
                .replace("8", "آبان")
                .replace("9", "آذر")
                .replace("10", "دی")
                .replace("11", "بهمن")
                .replace("12", "اسفند");
    }

    public static String faToEn(String num) {
        return num
                .replace("0", "۰")
                .replace("1", "۱")
                .replace("2", "۲")
                .replace("3", "۳")
                .replace("4", "۴")
                .replace("5", "۵")
                .replace("6", "۶")
                .replace("7", "۷")
                .replace("8", "۸")
                .replace("9", "۹");
    }

    public static String convertLessThanOneThousand(int number) {
        String soFar;

        if (number % 100 < 20) {
            soFar = numNames[number % 100];
            number /= 100;
        } else {
            soFar = numNames[number % 10];
            number /= 10;

            soFar = numNames[number % 10] + soFar;
            number /= 10;
        }
        if (number == 0) return soFar;
        return numNames[number] + " hundred" + soFar;
    }

    public static String Shamsi_Date() {

        Calendar cal = Calendar.getInstance();
        int Day = cal.get(Calendar.DAY_OF_MONTH);
        int Month = cal.get(Calendar.MONTH) + 1;
        int Year = cal.get(Calendar.YEAR);
        int Day_Of_Year = cal.get(Calendar.DAY_OF_YEAR);

        //---------------------------------------------

        if (Day_Of_Year <= 80)
            Year -= 622;
        else
            Year -= 621;

        switch (Month) {
            case 1:
                if (Day < 21) {
                    Month = 10;
                    Day += 10;
                } else {
                    Month = 11;
                    Day -= 20;
                }
                break;

            case 2:
                if (Day < 20) {
                    Month = 11;
                    Day += 11;
                } else {
                    Month = 12;
                    Day -= 19;
                }
                break;

            case 3:
                if (Day < 21) {
                    Month = 12;
                    Day += 9;
                } else {
                    Month = 1;
                    Day -= 20;
                }
                break;

            case 4:
                if (Day < 21) {
                    Month = 1;
                    Day += 11;
                } else {
                    Month = 2;
                    Day -= 20;
                }
                break;

            case 5:
            case 6:
                if (Day < 22) {
                    Month -= 3;
                    Day += 10;
                } else {
                    Month -= 2;
                    Day -= 21;
                }
                break;

            case 7:
            case 8:
            case 9:
                if (Day < 23) {
                    Month -= 3;
                    Day += 9;
                } else {
                    Month -= 2;
                    Day -= 22;
                }
                break;

            case 10:
                if (Day < 23) {
                    Month = 7;
                    Day += 8;
                } else {
                    Month = 8;
                    Day -= 22;
                }
                break;

            case 11:
            case 12:
                if (Day < 22) {
                    Month -= 3;
                    Day += 9;
                } else {
                    Month -= 2;
                    Day -= 21;
                }
                break;
        }
        return String.valueOf(Day);

    }

    private static final ThreadLocal<DateFormat> dateFormatThreadLocal = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd");
        }
    };

    public static int compareDates(Date date1, Date date2) {
        DateFormat dateFormat = dateFormatThreadLocal.get();
        System.out.println("compareDates=" + dateFormat.format(date1).compareTo(dateFormat.format(date2)));
        return dateFormat.format(date1).compareTo(dateFormat.format(date2));
    }

    public static String getWeek() {
        String[] NextPreWeekday;
        String firstDayOfWeek;
        String lastDayOfWeek;
        Globals sharedData = Globals.getInstance();
        Roozh roozh = new Roozh();

        int year = sharedData.getYear();
        int month = sharedData.getMonth();
        int day = sharedData.getDay();
        roozh.PersianToGregorian(year, month, day);
        calendar.set(roozh.getYear(), roozh.getMonth() - 1, roozh.getDay());
        NextPreWeekday = getWeekDay();
        firstDayOfWeek = CommonMethod.convertWeekDays(NextPreWeekday[0]);
        lastDayOfWeek = CommonMethod.convertWeekDays(NextPreWeekday[6]);
        return firstDayOfWeek + " " + CommonMethod.convertWeekDaysMouth(NextPreWeekday[0]) +
                " - " + lastDayOfWeek + " " + CommonMethod.convertWeekDaysMouth(NextPreWeekday[6]);
    }

    private static String[] getWeekDay() {
        Calendar now = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String[] days = new String[7];
        int delta;
        int selectStartWeek;

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
    }

    public static String getDayNum(String name) {
        String num = null;
        switch (name) {
            case "\u0634\u0646\u0628\u0647":
                num = "6";
                break;

            case "\u06cc\u06a9\u200c\u0634\u0646\u0628\u0647":
                num = "1";
                break;

            case "\u062f\u0648\u0634\u0646\u0628\u0647":
                num = "2";
                break;

            case "\u0633\u0647\u200c\u0634\u0646\u0628\u0647":
                num = "3";
                break;

            case "\u0686\u0647\u0627\u0631\u0634\u0646\u0628\u0647":
                num = "4";
                break;

            case "\u067e\u0646\u062c\u200c\u0634\u0646\u0628\u0647":
                num = "5";
                break;

            case "\u062c\u0645\u0639\u0647":
                num = "0";
                break;
        }
        return num;
    }


    public static void showToast(final Activity activity, final String str, final boolean isError) {

        if (activity == null)
            return;

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                View view = LayoutInflater.from(activity).inflate(R.layout.widget_toast, null);
                if (view == null)
                    return;
                TextView textView = (TextView) view.findViewById(R.id.toast_text);
                if (textView == null)
                    return;
                if (isError)
                    textView.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.detail_sheet_background));
                else
                    textView.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.detail_sheet_background));

                textView.setText(str);
                Toast toast = new Toast(activity);
                toast.setView(view);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });
    }

    public static void showToast(final Activity activity, final int str, final boolean isError) {

        if (activity == null)
            return;


        showToast(activity, activity.getString(str), isError);

    }

    public static void showToast1(Toast toast, boolean b) {
        Typeface typeface = Typeface.create("Wnazanin.ttf", Typeface.BOLD);
        toast.setGravity(Gravity.CENTER, 0, 0);
        ViewGroup group = (ViewGroup) toast.getView();
        TextView messageTextView = (TextView) group.getChildAt(0);
        messageTextView.setTextSize(18);
        messageTextView.setTextColor(Color.WHITE);
        messageTextView.setTypeface(typeface);
        if (b) {
            group.setBackgroundResource(R.drawable.textview_toast_error_style

            );
        } else {
            group.setBackgroundResource(R.drawable.textview_toast_error_style);
        }
    }

    public static void showErrors(Activity activity, VolleyError error) {
        if (error instanceof CustomError) {
            CustomError customError = (CustomError) error;
            if (customError.errorResponseBean == null) {
                Util.showToast(activity, R.string.error_unknown, true);
                return;
            }

            if (customError.errorResponseBean.getERROR() == null) {
                Util.showToast(activity, R.string.error_unknown, true);
                return;
            }
            Util.showToast(activity, customError.errorResponseBean.getERROR(), true);
        } else {
            Util.showToast(activity, R.string.error_unknown, true);
        }
    }

    public static void setTypeFace(EditText editText) {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), Constant.CUSTOM_FONT);
        editText.setTypeface(font);
    }

    public static String PersianNumber(String text) {
        if (text.length() == 0) {
            return "";
        }
        String out = "";
        int length = text.length();
        for (int i = 0; i < length; i++) {
            char c = text.charAt(i);
            if ('0' <= c && c <= '9') {
                int number = Integer.parseInt(String.valueOf(c));
                out += persianNumbers[number];
            } else if (c == '٫') {
                out += '،';
            } else {
                out += c;
            }
        }
        return out;
    }

    public static class WSParameter {
        public String key;
        public Object value;

        public WSParameter(String key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    public static String getMacAddr() {
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    res1.append(String.format("%02X:", b));
                }

                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                return res1.toString();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "02:00:00:00:00:00";
    }

    public static void printLogs(String str) {
        if (Constants.RELEASE)
            return;
        if (str != null) {
            int split = str.length() / 4000 + 1;
            int mod = str.length() % 4000;
            for (int i = 0; i < split; i++) {
                try {
                    Log.e("post", str.substring(i * 4000, (i + 1) * 4000));
                } catch (Exception e) {
                    Log.e("post", str.substring(i * 4000, i * 4000 + mod));
                }
            }
        }
    }

    public static DeviceBean getDevice() {

        return new DeviceBean(Settings.Secure.getString(CarApplication.getInstance().getContentResolver(), Settings.Secure.ANDROID_ID),
                getMacAddr(),
                Build.MODEL.toLowerCase(),
                "Android",
                Build.VERSION.RELEASE);
    }

    public static String getToken (){
        return CarApplication.getInstance().getSharedPreferences().getString(Constants.FIRE_BASE_TOKEN, "");
    }

    public static String createJson(ArrayList<WSParameter> wsParameters) {

        RequestBaseBean requestBaseBean = new RequestBaseBean();
        //System.out.println("getToken====" + requestBaseBean.getToken());
        JsonElement jsonElement = new Gson().toJsonTree(requestBaseBean);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        for (WSParameter wsParameter : wsParameters)
            jsonObject.addProperty(wsParameter.key, wsParameter.value + "");
        String json = jsonObject.toString();
        Util.printLogs("json = " + json);
        return json;
    }

    public static String createJson(String userName,String password,Map<String, ArrayList<WSParameter>> mapParam) {

        RequestBaseBean requestBaseBean = new RequestBaseBean();
        JsonElement jsonElement = new Gson().toJsonTree(requestBaseBean);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        for (String key : mapParam.keySet()) {
            //RequestBaseBean requestBaseBean2 = new RequestBaseBean();
            //JsonElement jsonElement2 = new Gson().toJsonTree(requestBaseBean2);
            JsonObject jsonObject2 = new JsonObject();
            ArrayList<WSParameter> wsParameters = mapParam.get(key);
            if (wsParameters != null) {
                for (WSParameter wsParameter : wsParameters) {
                    jsonObject2.addProperty(wsParameter.key, wsParameter.value + "");
                }
            }
            jsonObject.addProperty("username", userName);
            jsonObject.addProperty("password", password);
            jsonObject.add(key, jsonObject2);

        }

        String json = jsonObject.toString();
        Util.printLogs("json = " + json);
        return json;
    }

    public static void printAllStackTrace(Throwable e) {
        if (Constants.RELEASE)
            return;
        e.printStackTrace();
    }


    public static String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return capitalize(model);
        } else {
            return capitalize(manufacturer) + " " + model;
        }
    }

    private static String capitalize(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char first = s.charAt(0);
        if (Character.isUpperCase(first)) {
            return s;
        } else {
            return Character.toUpperCase(first) + s.substring(1);
        }
    }
    public static String formatHoursAndMinutes(int totalMinutes) {
        String minutes = Integer.toString(totalMinutes % 60);
        minutes = minutes.length() == 1 ? "0" + minutes : minutes;
        return (totalMinutes / 60) + ":" + minutes;
    }

    public static String addCommasToNumericString(String digits) {
        String result = "";
        for (int i=1; i <= digits.length(); ++i) {
            char ch = digits.charAt(digits.length() - i);
            if (i % 3 == 1 && i > 1) {
                result = "," + result;
            }
            result = ch + result;
        }

        return result;
    }
}
