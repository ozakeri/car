package gap.com.car.fragment;


import android.os.Bundle;
import android.os.Handler;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gap.com.car.R;
import gap.com.car.adapter.NewsNotificationPagerAdapter;

public class NewsNotifyFragment extends Fragment {

    private Handler handler;
    private boolean stop = false;

    private int[] tabIcons = {
            R.drawable.ic_home_black_24dp,
            R.drawable.ic_home_black_24dp
    };

    public NewsNotifyFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_add_event, container, false);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
                final ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);

                final NewsNotificationPagerAdapter adapter = new NewsNotificationPagerAdapter(getActivity(), getActivity().getSupportFragmentManager());
                viewPager.setAdapter(adapter);
                viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
                viewPager.setCurrentItem(2);
                viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
                tabLayout.setupWithViewPager(viewPager);


                tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        viewPager.setCurrentItem(tab.getPosition());
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {

                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {

                    }
                });

                if (!stop) {
                    handler.postDelayed(this, 10);
                    stop = true;
                }
            }
        }, 10);



        return view;

    }

}

