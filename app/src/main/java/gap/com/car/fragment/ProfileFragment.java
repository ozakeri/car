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
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import gap.com.car.R;
import gap.com.car.common.CalendarUtil;
import gap.com.car.gapcalendar.customweekview.PersianDate;
import gap.com.car.model.DriverProfileResponseBean;
import gap.com.car.util.Globals;

import static gap.com.car.R.id.content_frame;

public class ProfileFragment extends Fragment {



    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_photos, container, false);

        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("خودرو"));
        tabLayout.addTab(tabLayout.newTab().setText("راننده"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager =view.findViewById(R.id.view_pager);
        TabsAdapter tabsAdapter = new TabsAdapter(getActivity().getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(tabsAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setCurrentItem(1);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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

        return view;
    }

    public class TabsAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;
        public TabsAdapter(FragmentManager fm, int NoofTabs){
            super(fm);
            this.mNumOfTabs = NoofTabs;
        }
        @Override
        public int getCount() {
            return mNumOfTabs;
        }
        @Override
        public Fragment getItem(int position){
            switch (position){
                case 0:
                    return new CarProfileFragment();
                case 1:
                    return new DriverProfileFragment();

                default:
                    return null;
            }
        }
    }

}
