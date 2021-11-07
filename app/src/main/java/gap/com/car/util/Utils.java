package gap.com.car.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;
import com.google.android.material.tabs.TabLayout;

import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import gap.com.car.R;
import gap.com.car.app.CarApplication;
import gap.com.car.common.Constants;
import gap.com.car.model.DeviceBean;
import gap.com.car.model.RequestBaseBean;
import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt;


/**
 * Created by mahdi on 10/18/16.
 */

public class Utils {

    public static String latinNumberToPersian(String input) {
        String output = input.replaceAll("0", "٠");
        output = output.replaceAll("1", "١");
        output = output.replaceAll("2", "٢");
        output = output.replaceAll("3", "٣");
        output = output.replaceAll("4", "۴");
        output = output.replaceAll("5", "۵");
        output = output.replaceAll("6", "۶");
        output = output.replaceAll("7", "٧");
        output = output.replaceAll("8", "٨");
        output = output.replaceAll("9", "٩");
        return output;
    }

    public static String farsiNumberReplacement(String text) {
        text = text.replaceAll("۰", "0");
        text = text.replaceAll("۱", "1");
        text = text.replaceAll("۲", "2");
        text = text.replaceAll("۳", "3");
        text = text.replaceAll("۴", "4");
        text = text.replaceAll("۵", "5");
        text = text.replaceAll("۶", "6");
        text = text.replaceAll("۷", "7");
        text = text.replaceAll("۸", "8");
        text = text.replaceAll("۹", "9");

        return text;
    }

    public static EditText farsiNumberReplacement(EditText editText) {
        if (editText.getText() != null) {
            String text = editText.getText().toString();
            text = text.replaceAll("۰", "0");
            text = text.replaceAll("۱", "1");
            text = text.replaceAll("۲", "2");
            text = text.replaceAll("۳", "3");
            text = text.replaceAll("۴", "4");
            text = text.replaceAll("۵", "5");
            text = text.replaceAll("۶", "6");
            text = text.replaceAll("۷", "7");
            text = text.replaceAll("۸", "8");
            text = text.replaceAll("۹", "9");
            editText.setText(text);
        }
        return editText;
    }

    public static Random random = new Random(System.currentTimeMillis());

    public static void changeTabsFont(TabLayout tabLayout) {

        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    ((TextView) tabViewChild).setTypeface(CarApplication.getInstance().getNormalTypeFace());
                }
            }
        }
    }

    public static String getUuid()
    {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 5);
    }

    public static void getTotalHeightofListView(ListView listView) {

        ListAdapter mAdapter = listView.getAdapter();
        if (mAdapter == null)
            return;

        int totalHeight = 0;

        for (int i = 0; i < mAdapter.getCount(); i++) {
            View mView = mAdapter.getView(i, null, listView);

            mView.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));

            totalHeight += mView.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (mAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();

    }


    public static String amountFormater(String amount) {
        if (amount.length() > 0) {

            boolean isminus = amount.startsWith("-");
            amount = amount.replaceAll("[^\\d]", "");
            for (int i = amount.length() - 3; i > 0; i -= 3) {
                amount = amount.substring(0, i) + "," + amount.substring(i);
            }
            if (isminus) {
                amount = amount + "-";
            }
            return amount;
        } else {
            return "";
        }
    }


    public static int clear(String amount) {
        if (amount.length() > 0) {

            amount = amount.replaceAll("[^\\d]", "");
            int a = 0;

            try {
                a = Integer.parseInt(amount);
            }
            catch (Exception e)
            {

            }
            return a;
        } else {
            return 0;
        }
    }

    public static void printLogs(String str) {
        if (Constants.RELEASE)
            return;
        if (str != null)
        {
            int split = str.length() / 4000 + 1;
            int mod = str.length() % 4000;
            for (int i = 0; i < split; i++)
            {
                try
                {
                    Log.e("post", str.substring(i * 4000, (i+1) * 4000));
                }
                catch (Exception e)
                {
                    Log.e("post", str.substring(i * 4000, i * 4000 + mod));
                }
            }
        }
    }

    public static void printAllStackTrace(Throwable e) {
        if (Constants.RELEASE)
            return;
        e.printStackTrace();
    }

    public static void showErrors(Activity activity, VolleyError error)
    {
        if (error instanceof CustomError)
        {
            CustomError customError = (CustomError) error;
            if (customError.errorResponseBean == null)
            {
                Utils.showToast(activity, R.string.error_unknown, true);
                return;
            }

            if (customError.errorResponseBean.getERROR() == null)
            {
                Utils.showToast(activity, R.string.error_unknown, true);
                return;
            }
            Utils.showToast(activity, customError.errorResponseBean.getERROR(), true);
        }
        else
        {
            Utils.showToast(activity, R.string.error_unknown, true);
        }
    }

    public static DeviceBean getDevice() {

        return new DeviceBean(Settings.Secure.getString(CarApplication.getInstance().getContentResolver(), Settings.Secure.ANDROID_ID),
                getMacAddr(),
                Build.MODEL.toLowerCase(),
                "Android",
                Build.VERSION.RELEASE);
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
                    res1.append(String.format("%02X:",b));
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

    public static class WSParameter {
        public String key;
        public Object value;

        public WSParameter(String key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    public static String createJson(ArrayList<WSParameter> wsParameters) {

        RequestBaseBean requestBaseBean = new RequestBaseBean();
        JsonElement jsonElement = new Gson().toJsonTree(requestBaseBean);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        for (WSParameter wsParameter : wsParameters)
            jsonObject.addProperty(wsParameter.key, wsParameter.value + "");
        String json = jsonObject.toString();
        Utils.printLogs("json = " + json);
        return json;
    }


    public static boolean isEmailValid(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
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
                if(textView == null)
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

    public static class ScreenSize {
        public int width, height;

        public ScreenSize(int x, int y) {
            this.width = x;
            this.height = y;
        }
    }

    public static ScreenSize getScreenSize() {
        Display display = CarApplication.getInstance().getWindowManager().getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 13) {
            Point size = new Point();
            display.getSize(size);
            return new ScreenSize(size.x, size.y);
        } else {
            return new ScreenSize(display.getWidth(), display.getHeight());
        }
    }

    public static int dp2px(Resources resources, int dp)
    {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp,
                resources.getDisplayMetrics());
    }

    public static int getDialogWidth(Resources resources) {

        int min_width =  (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                Constants.DIALOG_WIDTH,
                resources.getDisplayMetrics());
        int screen_width = (int) (getScreenSize().width * 0.8);
        return Math.max(screen_width, min_width);
    }


    public static boolean isConnected(Context context) {
        boolean connected = false;
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (cm != null) {
                NetworkInfo nInfo = cm.getActiveNetworkInfo();
                connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
            }
            return connected;
        } catch (Exception e) {
            Log.e("Connectivity Exception", e.getMessage());
        }
        return connected;
    }

    public static void showcaseView(Context context,int withDelay ,String content,View view) {

        TapTargetView.showFor((Activity) context, TapTarget.forView(view, "Hello, world!", content)
                .cancelable(false)
                .drawShadow(true)
                .titleTextDimen(R.dimen.title_text_size)
                .tintTarget(false), new TapTargetView.Listener() {
            @Override
            public void onTargetClick(TapTargetView view) {
                super.onTargetClick(view);
                // .. which evidently starts the sequence we defined earlier
                System.out.println("====sequence.start();=====");            }

            @Override
            public void onOuterCircleClick(TapTargetView view) {
                super.onOuterCircleClick(view);
                Toast.makeText(view.getContext(), "You clicked the outer circle!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTargetDismissed(TapTargetView view, boolean userInitiated) {
                Log.d("TapTargetViewSample", "You dismissed me :(");
            }
        });
        /*new MaterialTapTargetSequence()
                .addPrompt(new MaterialTapTargetPrompt.Builder((Activity) context)
                        .setTarget(view)
                        .setPrimaryText("Step 1")
                        .setSecondaryText("This will show for 4 seconds")
                        .setFocalPadding(R.dimen.dp40)
                        .create(), 4000)
                .addPrompt(new MaterialTapTargetPrompt.Builder((Activity) context)
                        .setTarget(findViewById(R.id.action_search))
                        .setPrimaryText("Step 2")
                        .setSecondaryText("This will show till you press it")
                        .setAnimationInterpolator(new LinearOutSlowInInterpolator())
                        .setFocalPadding(R.dimen.dp40)
                        .setIcon(R.drawable.ic_search))
                .show();*/

       /* new MaterialShowcaseView.Builder((Activity) context)
                .setTarget(view)
                .setContentText(content)
                .setDismissText("بستن")
                .setDismissOnTouch(true)
                .withCircleShape()
                .setContentTextColor(context.getResources().getColor(R.color.oil))
                .setDismissTextColor(context.getResources().getColor(R.color.oil))
                .setMaskColour(context.getResources().getColor(R.color.blue))
                .setTooltipMargin(100)
                .setDelay(withDelay) // optional but starting animations immediately in onCreate can make them choppy
                // .singleUse("") // provide a unique ID used to ensure it is only shown once
                .show();*/

        new MaterialTapTargetPrompt.Builder((Activity)context)
                .setTarget(view)
                .setPrimaryText(content)
                .setAutoDismiss(false)
                .setBackButtonDismissEnabled(true)
                .setSecondaryText("Tap the envelop to start composing your first email")
                .setPromptStateChangeListener(new MaterialTapTargetPrompt.PromptStateChangeListener()
                {
                    @Override
                    public void onPromptStateChanged(MaterialTapTargetPrompt prompt, int state)
                    {
                        if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED)
                        {
                            // User has pressed the prompt target

                            System.out.println("User has pressed the prompt target");
                        }
                    }
                })
                .show();
    }
}
