package gap.com.datepicker.adapters;

import android.content.SharedPreferences;
import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import java.text.ParseException;

import gap.com.car.app.CarApplication;
import gap.com.datepicker.components.JDF;
import gap.com.datepicker.components.SquareTextView;
import gap.com.datepicker.interfaces.DateInterface;
import gap.com.datepicker.model.Check;
import gap.com.car.R;
import gap.com.car.util.Globals;

/**
 * Created by Alireza Afkar on 2/11/16 AD.
 */
public class MonthAdapter extends RecyclerView.Adapter<MonthAdapter.ViewHolder> {
    private static final int TYPE_DAY = 0;
    private static final int TYPE_TITLE = 1;
    private static final int TYPE_NONE = 2;
    private int testPosition;
    private int count = 0;

    private int mYear;
    private int mMonth;
    private JDF mToday;
    private Long maxDate;
    private Long minDate;
    private int mStartDay;
    private DateInterface mCallback;
    private View.OnClickListener mOnClickListener;
    private Globals globalValue = Globals.getInstance();

    public MonthAdapter(DateInterface callback, View.OnClickListener onClickListener, int currentMonth, int chosenYear) {
        mToday = new JDF();
        mYear = chosenYear;
        mCallback = callback;
        mMonth = currentMonth + 1;
        mOnClickListener = onClickListener;
        maxDate = callback.getDateItem().getMaxDate().getTimeInMillis();
        minDate = callback.getDateItem().getMinDate().getTimeInMillis();

        try {
            mStartDay = new JDF().getIranianDay(mYear, mMonth, 1);
        } catch (ParseException ignored) {
        }
    }

    private boolean isSelected(int day) {

        return mCallback.getMonth() == mMonth &&
                mCallback.getDay() == day &&
                mCallback.getYear() == mYear;
    }

    private boolean isToday(int day) {
        return (mMonth == mToday.getIranianMonth()
                && day == mToday.getIranianDay()
                && mYear == mToday.getIranianYear());
    }

    @NonNull
    @Override
    public MonthAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_day, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MonthAdapter.ViewHolder holder, int position) {

        String text = null;
        int day;
        boolean checked = false;
        boolean selected = false;
        boolean clickable = false;

        int viewType = getItemViewType(position);

        if (viewType == TYPE_TITLE) {
            text = mCallback.getWeekDays()[position].substring(0, 1);
        } else if (viewType == TYPE_DAY) {

            testPosition = position + 1;
            if (testPosition % 7 == 0) {
                holder.mTextView.setTextColor(Color.parseColor("#77FF9800"));
            }

            day = getDay(position);
            selected = isSelected(day);
            text = String.valueOf(day);
            clickable = isSelectableDay(day);
            checked = isToday(day);
        }

        holder.mTextView.setClickable(clickable);
        holder.mTextView.setSelected(selected);
        holder.mTextView.setEnabled(clickable);
        holder.mTextView.setChecked(checked);
        holder.mTextView.setText(text);

      /*  if (!globalValue.isLeavePage() || !globalValue.isMonthlyPage()) {

        } else {
            String text = null;
            int day = 0;
            boolean checked = false;
            boolean selected = false;
            boolean clickable = false;

            int viewType = getItemViewType(position);

            if (viewType == TYPE_TITLE) {
                text = mCallback.getWeekDays()[position].substring(0, 1);
            } else if (viewType == TYPE_DAY) {

                day = getDay(position);
                selected = isSelected(day);
                text = String.valueOf(day);

                holder.mTextView.setEnabled(false);
                holder.mTextView.setTextColor(Color.LTGRAY);

                testPosition = position + 1;
                if (testPosition % 7 == 0) {
                    holder.mTextView.setTextColor(Color.parseColor("#77FF9800"));
                }

                if (isToday(day)) {
                    selected = true;
                    holder.mTextView.setBackgroundResource(R.drawable.item_background_enable);
                }

                Date date = new Date();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                JalaliCalendarUtil jalaliCalendarUtil = new JalaliCalendarUtil(calendar);
                System.out.println("=-=-=-=-=-=-=-" + jalaliCalendarUtil.getIranianDay() + " -- " + jalaliCalendarUtil.getIranianMonth());

                for (int i = jalaliCalendarUtil.getIranianDay() + 2; i <= jalaliCalendarUtil.getIranianDay() + 30; i++) {

                    if (mMonth == jalaliCalendarUtil.getIranianMonth()) {
                        if (day == i) {
                            count += 1;
                            if ((testPosition % 7 == 0)) {
                                holder.mTextView.setTextColor(Color.parseColor("#ffff0000"));
                            } else {
                                holder.mTextView.setTextColor(Color.parseColor("#1D004E"));
                            }

                            holder.mTextView.setEnabled(true);
                            holder.mTextView.setBackgroundResource(R.drawable.item_background);
                            holder.mTextView.setPaintFlags(holder.mTextView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                            System.out.println("count++===" + count);
                        }
                    } else if (mMonth == jalaliCalendarUtil.getIranianMonth() + 1) {
                        if ((testPosition % 7 == 0)) {
                            holder.mTextView.setTextColor(Color.parseColor("#ffff0000"));
                        } else {
                            holder.mTextView.setTextColor(Color.parseColor("#1D004E"));
                        }

                        holder.mTextView.setEnabled(true);
                        holder.mTextView.setBackgroundResource(R.drawable.item_background);
                        holder.mTextView.setPaintFlags(holder.mTextView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                        System.out.println("count++===" + count);
                    }

                }


                if (mMonth == jalaliCalendarUtil.getIranianMonth() && day == jalaliCalendarUtil.getIranianDay()) {

                }


                clickable = isSelectableDay(day);
            }

            holder.mTextView.setClickable(clickable);
            holder.mTextView.setSelected(selected);
            //holder.mTextView.setEnabled(clickable);
            holder.mTextView.setChecked(checked);
            holder.mTextView.setText(text);
        }*/
    }

    private boolean isSelectableDay(int day) {
        long date = new JDF(mYear, mMonth, day).getTimeInMillis();
        return date >= minDate && date <= maxDate;
    }

    private int getDay(int position) {
        return (position - mStartDay - 7) + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position >= 0 && position < 7) {
            return TYPE_TITLE;
        } else if (position - 7 >= mStartDay) {
            return TYPE_DAY;
        } else {
            return TYPE_NONE;
        }
    }

    @Override
    public int getItemCount() {
        int days = 30;
        if (mMonth <= 6)
            days = 31;
        if (mMonth == 12 && !JDF.isLeapYear(mYear))
            days = 29;

        return days + 7 + mStartDay;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private SquareTextView mTextView;

        ViewHolder(View itemView) {
            super(itemView);
            mTextView = (SquareTextView) itemView;
            mTextView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getDay(getLayoutPosition());
            if (mCallback == null || position < 0) return;

            int oldMonth = mCallback.getMonth();
            mCallback.setDay(position, mMonth, mYear);
            SharedPreferences.Editor editor = CarApplication.getInstance().getSharedPreferences().edit();
            editor.putString("checkClick", "day");
            editor.apply();
            System.out.println("onClick======1");
            if (oldMonth != mMonth) {
                mOnClickListener.onClick(view);
                System.out.println("onClick======2");
            } else {
                notifyDataSetChanged();
            }
            EventBus.getDefault().post(new Check(true));
            System.out.println("onClick======3");
        }
    }
}
