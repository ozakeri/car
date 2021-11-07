package gap.com.datepicker.fragments;

import static androidx.recyclerview.widget.RecyclerView.RecycledViewPool;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar;

import java.util.Locale;

import gap.com.car.R;
import gap.com.datepicker.adapters.MonthAdapter;
import gap.com.datepicker.interfaces.DateInterface;

/**
 * Created by Alireza Afkar on 2/5/16 AD.
 */
public class MonthFragment extends Fragment implements View.OnClickListener {
    private TextView mTitle;
    private ViewPager mPager;
    private PagerAdapter mAdapter;
    private DateInterface mCallback;
    private int year;
    PersianCalendar p = new PersianCalendar();

    public static MonthFragment newInstance(DateInterface callback) {
        MonthFragment fragment = new MonthFragment();
        fragment.mCallback = callback;
        return fragment;
    }

    public MonthFragment() {
    }

    @SuppressLint("InflateParams")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return LayoutInflater.from(container.getContext())
                .inflate(R.layout.fragment_month, container, false);
    }

    @Override
    public void onClick(View view) {
        int currentItem = mPager.getCurrentItem();

        if (view.getId() == R.id.next) {

             if (p.getPersianMonth() == currentItem){
                 return;
             }

            if (mCallback.getMonth() - 1 == 11) {
                year = mCallback.getYear();
                initPager(mCallback.getYear(), mCallback.getMonth() - 11);
            }


            if (++currentItem < mAdapter.getCount()) {
                mPager.setCurrentItem(currentItem, true);
            }
        } else if (view.getId() == R.id.before) {
            if (p.getPersianMonth() - 6 == currentItem){
                return;
            }

            if (year < mCallback.getYear() && mCallback.getMonth() - 1 == 11) return;
            if (mCallback.getMonth() - 1 == 0) {
                year = mCallback.getYear() - 1;
                initPager(mCallback.getYear() - 1, mCallback.getMonth() + 11);
            }


            System.out.println("===-=-=-=-=-====" + p.getPersianMonth());
            System.out.println("currentItem====" + currentItem);
            if (--currentItem >= 0) {
                mPager.setCurrentItem(currentItem, true);
            }
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPager = view.findViewById(R.id.pager);
        mTitle = view.findViewById(R.id.title);
        view.findViewById(R.id.next).setOnClickListener(this);
        view.findViewById(R.id.before).setOnClickListener(this);
        initPager(mCallback.getYear(), mCallback.getMonth() - 1);
    }

    private void initPager(final int year, final int chosenMonth) {
        mAdapter = new PagerAdapter(year);
        mPager.setAdapter(mAdapter);
        mPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int month) {
                super.onPageSelected(month);
                mTitle.setText(String.format(Locale.US, "%s %d",
                        mAdapter.getPageTitle(month),
                        year));
                mCallback.setMonth(month + 1);
            }
        });
        mPager.setCurrentItem(chosenMonth);
        //System.out.println("chosenMonth==0000==" + chosenMonth);
        if (chosenMonth == 0) {
            mTitle.setText(String.format(Locale.US, "%s %d",
                    mAdapter.getPageTitle(0),
                    year));
        }
    }

    private class PagerAdapter extends androidx.viewpager.widget.PagerAdapter implements View.OnClickListener {
        private int mCurrentYear;
        private RecycledViewPool viewPool = new RecycledViewPool();

        PagerAdapter(int year) {
            mCurrentYear = year;
        }

        @Override
        public int getCount() {
            return mCallback.getMonths().length;
        }

        public int getYear() {
            return mCurrentYear;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        public int getItemPosition(@NonNull Object object) {
            return POSITION_NONE;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mCallback.getMonths()[position];
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int month) {
            View view = LayoutInflater.from(container.getContext())
                    .inflate(R.layout.layout_recycler_view, container, false);
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setRecycledViewPool(viewPool);
            MonthAdapter adapter = new MonthAdapter(mCallback, this, month, mCurrentYear);
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 7));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(adapter);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }

        @Override
        public void onClick(View view) {
            notifyDataSetChanged();
        }
    }
}
