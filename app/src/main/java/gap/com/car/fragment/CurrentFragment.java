package gap.com.car.fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

import gap.com.car.R;
import gap.com.car.app.CarApplication;
import gap.com.car.common.Constants;
import gap.com.car.gapcalendar.customweekview.CommonMethod;
import gap.com.car.gapcalendar.customweekview.DateConvertor;
import gap.com.car.gapcalendar.customweekview.PersianDate;
import gap.com.car.gapcalendar.customweekview.Roozh;
import gap.com.car.util.Constant;
import gap.com.car.util.Globals;
import gap.com.car.util.Util;

public class CurrentFragment extends Fragment {

    private Globals responseJson = Globals.getInstance();

    DateConvertor dateConvertor;
    private int dayName;
    private Roozh roozh = new Roozh();
    private Calendar calendar = Calendar.getInstance();

    public CurrentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_currnet, container, false);
        Globals sharedData = Globals.getInstance();
        PersianDate persianDate = new PersianDate();
        dateConvertor = new DateConvertor();

        //DriverProfileResponseBean response = responseJson.getResponse();
       // System.out.println("getNameFv=====" + response.getRESULT().getDriverProfile().getDriverJob().getCar().getNameFv());

        int day;
        int month;
        int year;
        if (sharedData.getYear() != 0 && sharedData.getMonth() != 0 && sharedData.getDay() != 0) {
            year = sharedData.getYear();
            month = sharedData.getMonth();
            day = sharedData.getDay();

        } else {
            year = dateConvertor.getIranianYear();
            month = dateConvertor.getIranianMonth();
            day = dateConvertor.getIranianDay();

            sharedData.setYear(year);
            sharedData.setMonth(month);
            sharedData.setDay(day);
        }

        if (!CarApplication.getInstance().getSharedPreferences().getBoolean(Constants.PREF_GOTO_SETTING, false)) {
            Fragment fragment = new PrivacyFragment();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
            Util.recognizeSelectedItems(Constant.RECOGNIZE, "PrivacyFragment");
        }

        Date date = new Date();
        roozh.PersianToGregorian(year, month, day);
        calendar.set(roozh.getYear(), roozh.getMonth(), roozh.getDay());
        calendar.add(Calendar.MONTH, -1);
        Date date12 = calendar.getTime();

        if (Util.compareDates(date, date12) == 0) {
            TextView showDateName = (TextView) ((Activity) getContext()).findViewById(R.id.showDateName_txt);
            showDateName.setText("امروز" + " , " + persianDate.dayName(year, month, day));
        } else {
            TextView showDateName = (TextView) ((Activity) getContext()).findViewById(R.id.showDateName_txt);
            showDateName.setText(persianDate.dayName(year, month, day));
        }

        gap.com.car.gapcalendar.persianweekview.PersianCalendar persianCalendar1 =
                new gap.com.car.gapcalendar.persianweekview.PersianCalendar(roozh.getYear(), roozh.getMonth(), roozh.getDay());
        day = persianCalendar1.getIranianDay();
        month = persianCalendar1.getIranianMonth();
        String monthName = CommonMethod.convertLessThanOneThousand(month);
        year = persianCalendar1.getIranianYear();
        sharedData.setDayMenuTitle(day + " " + monthName + " " + year);
        TextView txtView = ((Activity) getContext()).findViewById(R.id.spinner_txt);
        txtView.setText(Util.faToEn(day + " " + monthName + " " + year));

        return view;
    }
}
