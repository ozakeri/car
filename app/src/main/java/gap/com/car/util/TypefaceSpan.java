package gap.com.car.util;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

import gap.com.car.app.CarApplication;


/**
 * Created by mahdi on 4/28/15.
 */
public class TypefaceSpan extends MetricAffectingSpan {

    private Typeface mTypeface;

    public TypefaceSpan() {

        if (mTypeface == null) {
            mTypeface = CarApplication.getInstance().getNormalTypeFace();
        }
    }

    @Override
    public void updateMeasureState(TextPaint p) {
        p.setTypeface(mTypeface);
        p.setFlags(p.getFlags() | Paint.SUBPIXEL_TEXT_FLAG);
    }

    @Override
    public void updateDrawState(TextPaint tp) {
        tp.setTypeface(mTypeface);
        tp.setFlags(tp.getFlags() | Paint.SUBPIXEL_TEXT_FLAG);
    }
}