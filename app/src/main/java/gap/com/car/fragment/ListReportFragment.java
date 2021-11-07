package gap.com.car.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

import java.util.Calendar;

import gap.com.datepicker.DatePicker;
import gap.com.datepicker.interfaces.DateSetListener;
import gap.com.car.R;
import gap.com.car.model.EventBusModel;
import gap.com.car.util.Globals;
import gap.com.car.util.JalaliCalendarUtil;

public class ListReportFragment extends Fragment{

    private EditText currentDateET;
    private Fragment fragment;
    private FragmentManager fragmentManager;
    private Globals sharedData = Globals.getInstance();
    private int year;
    private int month;
    private int day;
    private FloatingActionButton floatingActionButton;

    public ListReportFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies, container, false);

        currentDateET = view.findViewById(R.id.currentDate_VT);
        floatingActionButton = view.findViewById(R.id.floatingActionButton);
        currentDateET.setText(" امروز " + sharedData.getDay() + "-" + sharedData.getMonth() + "-" + sharedData.getYear());

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            year = bundle.getInt("year");
            month = bundle.getInt("monthOfYear");
            day = bundle.getInt("dayOfMonth");
            currentDateET.setText(year + "-" + month + "-" + day);
        }

        currentDateET.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View view) {

                FragmentManager fm = getActivity().getSupportFragmentManager();
                Calendar minDate = Calendar.getInstance();
                Calendar maxDate = Calendar.getInstance();
                maxDate.set(Calendar.MONTH, maxDate.get(Calendar.MONTH) + 2);
                minDate.set(Calendar.MONTH, maxDate.get(Calendar.MONTH) - 2);
                new DatePicker.Builder()
                        .id(1)
                        .minDate(minDate)
                        .maxDate(maxDate)
                        .build(new DateSetListener() {
                            @Override
                            public void onDateSet(int id, @Nullable Calendar calendar, int day, int month, int year) {
                                if (calendar == null)
                                    return;

                                JalaliCalendarUtil jalaliCalendarUtil = new JalaliCalendarUtil(calendar);
                                currentDateET.setText(jalaliCalendarUtil.getIranianWeekDayStr() + " " + jalaliCalendarUtil.getIranianDate3());
                            }
                        })
                        .show(fm, "");
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new ReportFragment();
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                EventBus.getDefault().post(new EventBusModel("ReportFragment"));
            }
        });

        return view;
    }
}
