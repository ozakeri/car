package gap.com.car.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import gap.com.car.R;
import gap.com.car.gapcalendar.materialdatetimepicker.date.DatePickerDialog;
import gap.com.car.gapcalendar.materialdatetimepicker.utils.PersianCalendar;
import gap.com.car.util.Globals;

public class MoviesFragment extends Fragment implements DatePickerDialog.OnDateSetListener {

    private EditText currentDateET;
    private Fragment fragment;
    private FragmentManager fragmentManager;
    private Globals sharedData = Globals.getInstance();
    private int year;
    private int month;
    private int day;
    private FloatingActionButton floatingActionButton;

    public MoviesFragment() {
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

                PersianCalendar now = new PersianCalendar();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        (DatePickerDialog.OnDateSetListener) getActivity(),
                        now.getPersianYear(),
                        now.getPersianMonth(),
                        now.getPersianDay()
                );
                dpd.setAccentColor(getResources().getColor(R.color.colorPrimary));
                PersianCalendar[] dates = new PersianCalendar[13];
                for (int i = -6; i <= 6; i++) {
                    PersianCalendar date = new PersianCalendar();
                    date.add(PersianCalendar.MONTH, i);
                    dates[i + 6] = date;
                }
                android.app.FragmentManager fm = getActivity().getFragmentManager();
                dpd.setSelectableDays(dates);
                dpd.show(fm, "Datepickerdialog");
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new ReportFragment();
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
            }
        });

        return view;
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth, String dayName) {

        fragment = new MoviesFragment();
        fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

        currentDateET.setText(year + "-" + monthOfYear + 1 + "-" + dayOfMonth);
        System.out.println("MoviesFragment====" + year);
        System.out.println("MoviesFragment====" + monthOfYear + 1);
        System.out.println("MoviesFragment====" + dayOfMonth);
    }
}
