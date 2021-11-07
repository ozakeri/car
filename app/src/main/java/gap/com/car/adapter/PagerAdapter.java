package gap.com.car.adapter;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import gap.com.car.R;
import gap.com.car.fragment.TabFragment2;
import gap.com.car.fragment.TabFragment3;
import gap.com.car.model.SalaryAttribute;

public class PagerAdapter extends FragmentStatePagerAdapter {
    private SalaryAttribute salaryAttribute;
    private Context mContext;

    public PagerAdapter(Context mContext, FragmentManager manager, SalaryAttribute salaryAttribute) {
        super(manager);
        this.salaryAttribute = salaryAttribute;
        this.mContext = mContext;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle args = new Bundle();
        args.putParcelable("salaryAttribute", salaryAttribute);
        switch (position) {
           /* case 0:
                TabFragment1 tabFragment1 = new TabFragment1();
                tabFragment1.setArguments(args);
                return tabFragment1;*/

           /*
           * tab for daily fragment
           * one tab for event and two tab for halfPath
           * */
            case 0:
                TabFragment2 tabFragment2 = new TabFragment2();
                tabFragment2.setArguments(args);
                return tabFragment2;

            case 1:
                TabFragment3 tabFragment3 = new TabFragment3();
                tabFragment3.setArguments(args);
                return tabFragment3;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            //case 0:
                //return mContext.getString(R.string.label_tabLayout_tab1);
            case 0:
                return mContext.getString(R.string.label_tabLayout_tab2);
            case 1:
                return mContext.getString(R.string.label_tabLayout_tab3);
            default:
                return null;
        }
    }

    @Override
    public int getItemPosition(@NonNull Object object){
        return PagerAdapter.POSITION_NONE;
    }
}
