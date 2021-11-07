package gap.com.car.widget;

/**
 * Created by Mohamad Cheraghi on 08/22/2016.
 */

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

import gap.com.car.R;
import gap.com.car.app.CarApplication;
import gap.com.car.util.Constant;
import gap.com.car.util.FontCache;

public class CustomTextView extends androidx.appcompat.widget.AppCompatTextView {
    private TextView textView;

    public CustomTextView(Context context) {
        super(context);
        applyCustomFont(context);
        singleLine(context);
        init();
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context);
        singleLine(context);
        init();
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        applyCustomFont(context);
        singleLine(context);
        init();
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("Wnazanin.ttf", context);
        setTypeface(customFont);

    }

    private void singleLine(Context context) {
        textView = new TextView(context);
        textView.setSingleLine(false);
    }

    private void init() {
        if (!isInEditMode()) {
            setTypeface(CarApplication.getInstance().getNormalTypeFace());
            int size = CarApplication.getInstance().getSharedPreferences().getInt(Constant.PREF_FONT_SIZE, -1);
            System.out.println("size======" + size);
            if (size > -1) {
                switch (size) {
                    case 0:
                        setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.text_small2));
                        break;
                    case 1:
                        setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.text_small));
                        break;
                    case 2:
                        setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.text_normal));
                        break;
                    case 3:
                        setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.text_big));
                        break;
                    case 4:
                        setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.text_huge));
                        break;
                }
            } else {
                setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.text_normal));
            }
        }
    }
}