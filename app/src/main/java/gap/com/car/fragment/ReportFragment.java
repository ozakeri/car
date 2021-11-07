package gap.com.car.fragment;


import android.os.AsyncTask;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.appcompat.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.Date;
import java.util.List;

import gap.com.car.R;
import gap.com.car.database.DataBaseClint;
import gap.com.car.database.entity.Driver;
import gap.com.car.database.entity.Report;
import gap.com.car.enumtype.EntityNameEn;
import gap.com.car.enumtype.SendingStatusEn;
import gap.com.car.services.ServerCoordinator;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReportFragment extends Fragment {

    private RadioGroup selected_reportTypeEN;
    private RadioButton reportTypeOther, reportTypeStation, reportTypeLine;
    private EditText code_ET, dec_ET;
    private AppCompatButton ok;
    private int entityNameEn;
    private String identifier;
    private List<Driver> driverList;
    private Driver driver;
    private long id;

    public ReportFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_report, container, false);
        selected_reportTypeEN = view.findViewById(R.id.selected_reportTypeEN);
        reportTypeOther = view.findViewById(R.id.reportTypeOther);
        reportTypeStation = view.findViewById(R.id.reportTypeStation);
        reportTypeLine = view.findViewById(R.id.reportTypeLine);
        code_ET = view.findViewById(R.id.code_ET);
        dec_ET = view.findViewById(R.id.dec_ET);
        ok = view.findViewById(R.id.ok);
        entityNameEn = EntityNameEn.DriverProfile.ordinal();

        getAllDriver();

        selected_reportTypeEN.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.reportTypeLine:
                        entityNameEn = EntityNameEn.Line.ordinal();
                        code_ET.setHint("کد خط");
                        code_ET.setVisibility(View.VISIBLE);
                        break;

                    case R.id.reportTypeStation:
                        entityNameEn = EntityNameEn.Station.ordinal();
                        code_ET.setHint("کد ایستگاه");
                        code_ET.setVisibility(View.VISIBLE);
                        break;

                    case R.id.reportTypeOther:
                        code_ET.setVisibility(View.GONE);
                        break;
                }

            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                id = new Date().getTime();
                System.out.println("id========" + id);
                identifier = code_ET.getText().toString();

                ServerCoordinator.getInstance().saveComplaintReport(driver.getUsername(),
                        driver.getPassword(),
                        String.valueOf(id),
                        identifier,
                        entityNameEn,
                        dec_ET.getText().toString()
                        , new Date(), 0.0, 0.0, new Response.Listener() {
                            @Override
                            public void onResponse(Object response) {
                                System.out.println("response====" + response);
                                insertReport();

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        });
            }
        });

        return view;
    }


    public void insertReport() {

        class InsertReport extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                String reportCode = code_ET.getText().toString();
                String reportDescription = dec_ET.getText().toString();
                Report report = new Report();
                report.setId(id);
                report.setReportCode(reportCode);
                report.setReportStr(reportDescription);
                report.setEntityNameEn(entityNameEn);
                report.setIdentifier(identifier);
                report.setReportDate(String.valueOf(new Date()));
                report.setDeliverIs(Boolean.FALSE);
                report.setSendingStatusEn(SendingStatusEn.Pending.ordinal());
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }
        }

        new InsertReport().execute();

    }

    private void getAllDriver() {
        class GetAllDriver extends AsyncTask<Void, Void, List<Driver>> {

            @Override
            protected List<Driver> doInBackground(Void... voids) {
                driverList = DataBaseClint.getInstance(getActivity()).getAppDataBase().driverDao().getAll();
                if (driverList.size() > 0) {
                    driver = driverList.get(0);
                    entityNameEn = driver.getDriverCode();
                }
                return driverList;
            }

            @Override
            protected void onPostExecute(List<Driver> drivers) {
                super.onPostExecute(drivers);

            }
        }
        new GetAllDriver().execute();
    }

}
