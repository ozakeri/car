package gap.com.car.fragment;


import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import gap.com.car.app.CarApplication;
import gap.com.datepicker.DatePicker;
import gap.com.datepicker.interfaces.DateSetListener;
import gap.com.car.R;
import gap.com.car.common.Constants;
import gap.com.car.database.DataBaseClint;
import gap.com.car.database.entity.Driver;
import gap.com.car.database.entity.PersonTimeOff;
import gap.com.car.gapcalendar.materialdatetimepicker.date.DatePickerDialog;
import gap.com.car.gapcalendar.materialdatetimepicker.utils.PersianCalendar;
import gap.com.car.model.SavedPersonTimeOffResponseBean;
import gap.com.car.model.ServerDateTimeResponseBean;
import gap.com.car.services.ServerCoordinator;
import gap.com.car.util.DateUtils;
import gap.com.car.util.Globals;
import gap.com.car.util.JalaliCalendarUtil;
import gap.com.car.util.Util;
import gap.com.car.util.Utils;
import gap.com.car.widget.CircularProgress;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeaveFragment extends Fragment implements DatePickerDialog.OnDateSetListener {

    EditText editTextStartDate, editTextEndDate;
    private int year;
    private int month;
    private int day;
    ImageView imgStartDate, imgEndDate;
    Globals sharedData = Globals.getInstance();
    private boolean b;
    private RadioGroup selectedLeaveType, selectedRequestTypeEN;
    private RadioButton timeOfDay1, timeOfDay2, requestTypeEN3, requestTypeEN2, requestTypeEN1;
    private TextView description;
    private Button btn_send;
    private int typeEn;
    private CircularProgress progressbar;
    CarApplication application;
    private Driver driver;
    private Calendar calFrom = null;
    private Calendar calTo = null;
    private Date startDate = null;
    private Date finishDate = null;
    private String fromDate, toDate;
    private boolean isOneDate = true;


    public LeaveFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_leave, container, false);
        sharedData.setLeavePage(true);

        editTextStartDate = view.findViewById(R.id.editTextStartDate);
        editTextEndDate = view.findViewById(R.id.editTextEndDate);
        description = view.findViewById(R.id.desc1);
        imgStartDate = view.findViewById(R.id.imgStartDate);
        imgEndDate = view.findViewById(R.id.imgEndDate);
        selectedLeaveType = view.findViewById(R.id.selected_leave_type);
        selectedRequestTypeEN = view.findViewById(R.id.selected_requestTypeEN);
        timeOfDay1 = view.findViewById(R.id.selected_timeOfDay1);
        timeOfDay2 = view.findViewById(R.id.selected_timeOfDay2);
        requestTypeEN1 = view.findViewById(R.id.requestTypeEN1);
        requestTypeEN2 = view.findViewById(R.id.requestTypeEN2);
        requestTypeEN3 = view.findViewById(R.id.requestTypeEN3);
        btn_send = view.findViewById(R.id.btn_send);
        progressbar = (CircularProgress) view.findViewById(R.id.progressbar);
        progressbar.setVisibility(View.GONE);
        //sharedData.setCheckOp(true);
        editTextStartDate.requestFocus();

        timeOfDay1.setChecked(true);
        requestTypeEN1.setChecked(true);
        if (isOneDate) {
            timeOfDay1.setChecked(true);
            timeOfDay2.setChecked(false);
            editTextEndDate.setVisibility(View.GONE);
            imgEndDate.setVisibility(View.GONE);
            editTextStartDate.setHint("تاریخ");

        } else {
            timeOfDay2.setChecked(true);
            timeOfDay1.setChecked(false);
            editTextEndDate.setVisibility(View.VISIBLE);
            imgEndDate.setVisibility(View.VISIBLE);
            editTextStartDate.setHint("از");
        }

        selectedLeaveType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.selected_timeOfDay1:
                        isOneDate = true;
                        editTextEndDate.setVisibility(View.GONE);
                        imgEndDate.setVisibility(View.GONE);
                        editTextStartDate.setHint("تاریخ");
                        sharedData.setCheckOp(false);
                        break;

                    case R.id.selected_timeOfDay2:
                        isOneDate = false;
                        editTextEndDate.setVisibility(View.VISIBLE);
                        imgEndDate.setVisibility(View.VISIBLE);
                        sharedData.setCheckOp(true);
                        editTextStartDate.setHint("از");
                        break;
                }
            }
        });


        selectedRequestTypeEN.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.requestTypeEN1:
                        typeEn = 0;
                        break;

                    case R.id.requestTypeEN2:
                        typeEn = 1;
                        break;

                    case R.id.requestTypeEN3:
                        typeEn = 2;
                        break;
                }
            }
        });

        Bundle bundle = this.getArguments();
        if (bundle != null) {

            year = bundle.getInt("year");
            month = bundle.getInt("monthOfYear");
            day = bundle.getInt("dayOfMonth");

            String date = year + "-" + month + "-" + day;
            SharedPreferences.Editor editor = CarApplication.getInstance().getSharedPreferences().edit();
            editor.putString("date", date);
            editor.apply();

            editTextStartDate.setText(sharedData.getDateOne());
            editTextEndDate.setText(sharedData.getDateTwo());

        }


        editTextStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                Calendar minDate = Calendar.getInstance();
                Calendar maxDate = Calendar.getInstance();
                maxDate.set(Calendar.MONTH, maxDate.get(Calendar.MONTH) + 1);
                // minDate.set(Calendar.MONTH, maxDate.get(Calendar.MONTH) - 2);
                new DatePicker.Builder()
                        .id(1)
                        .minDate(minDate)
                        .maxDate(maxDate)
                        .build(new DateSetListener() {
                            @Override
                            public void onDateSet(int id, @Nullable Calendar calendar, int day, int month, int year) {
                                if (calendar == null)
                                    return;

                                calFrom = calendar;
                                JalaliCalendarUtil jalaliCalendarUtil = new JalaliCalendarUtil(calendar);
                                editTextStartDate.setText(jalaliCalendarUtil.getIranianWeekDayStr() + " " + jalaliCalendarUtil.getIranianDate3());
                            }
                        })
                        .show(fm, "");
            }
        });


        editTextEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                Calendar minDate = Calendar.getInstance();
                Calendar maxDate = Calendar.getInstance();
                maxDate.set(Calendar.MONTH, maxDate.get(Calendar.MONTH) + 1);
                //minDate.set(Calendar.MONTH, maxDate.get(Calendar.MONTH) - 2);
                new DatePicker.Builder()
                        .id(1)
                        .minDate(minDate)
                        .maxDate(maxDate)
                        .build(new DateSetListener() {
                            @Override
                            public void onDateSet(int id, @Nullable Calendar calendar, int day, int month, int year) {
                                if (calendar == null)
                                    return;

                                calTo = calendar;
                                JalaliCalendarUtil jalaliCalendarUtil = new JalaliCalendarUtil(calendar);
                                editTextEndDate.setText(jalaliCalendarUtil.getIranianWeekDayStr() + " " + jalaliCalendarUtil.getIranianDate3());
                            }
                        })
                        .show(fm, "");
            }
        });


        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDeviceDateTimeValid();
            }
        });

        return view;
    }

    private void toDate() {
        SharedPreferences.Editor editor = CarApplication.getInstance().getSharedPreferences().edit();
        editor.putBoolean("b", false);
        editor.apply();

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

    private void fromDate() {
        SharedPreferences.Editor editor = CarApplication.getInstance().getSharedPreferences().edit();
        editor.putBoolean("b", true);
        editor.apply();

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

    @SuppressLint("SetTextI18n")
    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth, String dayName) {

    }


    private void isDeviceDateTimeValid() {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATE_TIME_FORMAT);
        progressbar.setVisibility(View.VISIBLE);

        application = (CarApplication) getActivity().getApplication();
        driver = application.getCurrentUser();
        final String username = driver.getUsername();
        final String password = driver.getPassword();
        final String str_description = description.getText().toString();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        if (calFrom != null) {
            startDate = calFrom.getTime();
            fromDate = formatter.format(startDate);
        }

        if (calTo != null) {
            finishDate = calTo.getTime();
            toDate = formatter.format(finishDate);
        }


        if (isOneDate) {
            if (calFrom != null) {
                finishDate = calFrom.getTime();
                toDate = formatter.format(finishDate);
            }
        }


        ServerCoordinator.getInstance().getServerDateTime(new Response.Listener<ServerDateTimeResponseBean>() {
            @Override
            public void onResponse(ServerDateTimeResponseBean response) {
                progressbar.setVisibility(View.GONE);
                try {
                    Date serverDateTime = simpleDateFormat.parse(response.getRESULT().getServerDateTime());
                    if (DateUtils.isValidDateDiff(new Date(), serverDateTime, Constants.VALID_SERVER_AND_DEVICE_TIME_DIFF)) {
                        progressbar.setVisibility(View.VISIBLE);
                        ServerCoordinator.getInstance().savePersonTimeOff(username, password, fromDate, toDate, typeEn, str_description,
                                new Response.Listener<SavedPersonTimeOffResponseBean>() {
                                    @Override
                                    public void onResponse(SavedPersonTimeOffResponseBean response) {
                                        progressbar.setVisibility(View.GONE);
                                        if (response != null) {

                                            int id = response.getRESULT().getSavedPersonTimeOff().getPersonTimeOff().getId();
                                            String startDate = response.getRESULT().getSavedPersonTimeOff().getPersonTimeOff().getStartDate();
                                            String finishDate = response.getRESULT().getSavedPersonTimeOff().getPersonTimeOff().getFinishDate();
                                            int type = response.getRESULT().getSavedPersonTimeOff().getPersonTimeOff().getPersonTimeOffTypeEn();
                                            String processStatus = response.getRESULT().getSavedPersonTimeOff().getPersonTimeOff().getProcessStatusText();
                                            addTask(id, startDate, finishDate, type, processStatus);

                                        }
                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        progressbar.setVisibility(View.GONE);

                                    }
                                });

                    } else {
                        Utils.showToast(getActivity(), R.string.message_toast_invalidDateTime, false);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Utils.showErrors(getActivity(), error);
            }
        });
    }

    public void addTask(final int id, final String startDate, final String finishDate, final int type, final String processStatus) {

        class InsertPersonTimeOff extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                PersonTimeOff personTimeOff = new PersonTimeOff();
                personTimeOff.setId(id);
                personTimeOff.setStartDate(startDate);
                personTimeOff.setFinishDate(finishDate);
                personTimeOff.setPersonTimeOffTypeEn(type);
                personTimeOff.setProcessStatusText(processStatus);
                DataBaseClint.getInstance(getActivity()).getAppDataBase().personTimeOffDao().addPersonTimeOff(personTimeOff);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast toast = Toast.makeText(getActivity(), "Saved", Toast.LENGTH_SHORT);
                Util.showToast1(toast, false);
                toast.show();

                ListLeaveFragment fragment = new ListLeaveFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
            }
        }

        new InsertPersonTimeOff().execute();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        sharedData.setLeavePage(false);
    }

    @Override
    public void onStop() {
        super.onStop();
        sharedData.setLeavePage(false);
    }

    @Override
    public void onPause() {
        super.onPause();
        sharedData.setLeavePage(false);
    }
}
