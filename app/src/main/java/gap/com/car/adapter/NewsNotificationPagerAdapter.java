package gap.com.car.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import gap.com.car.R;
import gap.com.car.fragment.NewsFragment;
import gap.com.car.fragment.NotificationFragment;

public class NewsNotificationPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private NewsFragment fragment1;
    private NotificationFragment fragment2;

    public NewsNotificationPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                fragment1 = new NewsFragment();
                return fragment1;
            case 1:
                fragment2 = new NotificationFragment();
                return fragment2;
            default:
                return fragment2;
        }
    }

    // this counts total number of tabs
    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            //case 0:
            //return mContext.getString(R.string.label_tabLayout_tab1);
            case 0:
                return mContext.getString(R.string.label_tabLayout_news);
            case 1:
                return mContext.getString(R.string.label_tabLayout_notification);
            default:
                return null;
        }
    }

    @Override
    public int getItemPosition(@NonNull Object object){
        return NewsNotificationPagerAdapter.POSITION_NONE;
    }

}
