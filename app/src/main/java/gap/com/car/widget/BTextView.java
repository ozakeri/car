package gap.com.car.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

import gap.com.car.R;
import gap.com.car.app.CarApplication;
import gap.com.car.util.Constant;
import gap.com.car.util.Utils;


/**
 * Created by mahdi on 7/18/2016 AD.
 */
public class BTextView extends androidx.appcompat.widget.AppCompatTextView {
    private String rawText;

    public BTextView(Context context) {
        super(context);
        init();
    }

    public BTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            setTypeface(CarApplication.getInstance().getNormalTypeFace());
            int size = CarApplication.getInstance().getSharedPreferences().getInt(Constant.PREF_FONT_SIZE, -1);
            size = 0;
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

    public void removeTypeface() {
        if (!isInEditMode())
            setTypeface(null);
    }

    public void setText (CharSequence text, TextView.BufferType type) {
        super.setText(Utils.latinNumberToPersian(text.toString()), type);
    }
}
