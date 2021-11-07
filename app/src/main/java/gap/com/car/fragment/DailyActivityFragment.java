package gap.com.car.fragment;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gap.com.car.R;

public class DailyActivityFragment extends Fragment {


    public DailyActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.daily_activity_fragment, container, false);



        return view;

    }

}

