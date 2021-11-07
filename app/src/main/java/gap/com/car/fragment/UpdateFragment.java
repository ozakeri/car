package gap.com.car.fragment;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import gap.com.car.BuildConfig;
import gap.com.car.R;
import gap.com.car.model.update.UpdateVersionResponseBean;
import gap.com.car.services.ServerCoordinator;
import gap.com.car.util.JalaliCalendarUtil;
import gap.com.car.widget.BTextView;
import gap.com.car.widget.CircularProgress;

public class UpdateFragment extends Fragment {

    private TextView txt_currentVersionNo, txt_installDate, txt_newVersionNo, txt_newVersionDate, txt_lastInstallDate;
    private CardView card_newVersion, card_null;
    private SimpleDateFormat sdf;
    private String updateUrl;
    private ProgressBar progressBar;
    private CircularProgress circularProgress;
    private TextView stateLabel;
    private BTextView btnDownloadAndUpdate, btnUpdateLocal;
    private String appFileName;
    private DpdateWork downloadWork;
    private int versionCode = 0;

    private void viewAllDownloads() {
        Intent intent = new Intent();
        intent.setAction(DownloadManager.ACTION_VIEW_DOWNLOADS);
        startActivity(intent);
    }

    public UpdateFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.update_fragment, container, false);

        txt_currentVersionNo = (TextView) view.findViewById(R.id.txt_currentVersionNo);
        txt_installDate = (TextView) view.findViewById(R.id.txt_installDate);
        txt_lastInstallDate = (TextView) view.findViewById(R.id.txt_lastInstallDate);
        txt_newVersionNo = (TextView) view.findViewById(R.id.txt_newVersionNo);
        txt_newVersionDate = (TextView) view.findViewById(R.id.txt_newVersionDate);
        progressBar = view.findViewById(R.id.ProgressBar);
        circularProgress = view.findViewById(R.id.ProgressIcon);
        stateLabel = view.findViewById(R.id.StateLabel);
        btnDownloadAndUpdate = view.findViewById(R.id.BtnDownloadAndUpdate);
        btnUpdateLocal = view.findViewById(R.id.BtnUpdateLocal);
        card_newVersion = (CardView) view.findViewById(R.id.card_newVersion);
        card_null = (CardView) view.findViewById(R.id.card_null);
        card_newVersion.setVisibility(View.GONE);
        card_null.setVisibility(View.GONE);
        sdf = new SimpleDateFormat("yyyy/MM/dd");

        updateVersion();
        AskForPermission();

        btnUpdateLocal.setVisibility(View.GONE);
        btnDownloadAndUpdate.setVisibility(View.VISIBLE);
        circularProgress.setVisibility(View.GONE);

        btnDownloadAndUpdate.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (appFileName == null || appFileName == "")
                    return;

                circularProgress.setVisibility(View.VISIBLE);
                btnDownloadAndUpdate.setVisibility(View.GONE);
                ResetDownloadUI();
                DoUpdate();
            }
        });

        btnUpdateLocal = view.findViewById(R.id.BtnUpdateLocal);
        btnUpdateLocal.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View view) {
                DoInstall();
            }
        });


        PackageManager pm = getActivity().getPackageManager();

        try {
            PackageInfo pi = pm.getPackageInfo(getActivity().getPackageName(), 0);


            String version = pi.versionName;

            txt_currentVersionNo.setText(version);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date(pi.firstInstallTime));

            Calendar calendar1 = Calendar.getInstance();
            calendar.setTime(new Date(pi.lastUpdateTime));

            JalaliCalendarUtil jalaliCalendarUtil = new JalaliCalendarUtil(calendar);
            JalaliCalendarUtil jalaliCalendarUtil1 = new JalaliCalendarUtil(calendar1);

            txt_installDate.setText(jalaliCalendarUtil.getIranianYear() + "/" + jalaliCalendarUtil.getIranianMonth() + "/" + jalaliCalendarUtil.getIranianDay());
            txt_lastInstallDate.setText(jalaliCalendarUtil1.getIranianYear() + "/" + jalaliCalendarUtil1.getIranianMonth() + "/" + jalaliCalendarUtil1.getIranianDay());

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return view;
    }

    private void ResetDownloadUI() {
        stateLabel.setText("");
        progressBar.setMax(100);
        progressBar.setProgress(0);
        SwitchBusyIcon(true);
    }

    private void SwitchBusyIcon(boolean flag) {
        int visible = flag ? View.VISIBLE : View.INVISIBLE;
        circularProgress.setVisibility(visible);
    }

    private void DoUpdate() {
        downloadWork = new DpdateWork();
        downloadWork.execute(updateUrl);
    }


    public String GetFileNameFromUrl(String urlString) {
        return urlString.substring(urlString.lastIndexOf('/') + 1).split("\\?")[0].split("#")[0];
    }

    class DpdateWork extends AsyncTask<String, Integer, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            SetStateLabel("در حال دانلود ... ");
        }

        @Override
        protected String doInBackground(String... params) {

            try {

                URL url = new URL(params[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setUseCaches(false);
                connection.connect();

                if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    return "Server returned HTTP " + connection.getResponseCode() + " " + connection.getResponseMessage();
                }

                File downloadPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                File outputFile = new File(downloadPath.getPath(), appFileName);
                if (outputFile.exists()) {
                    outputFile.delete();
                }

                int lenghtOfFile = connection.getContentLength();
                InputStream input = new BufferedInputStream(url.openStream(), 1024);
                OutputStream output = new FileOutputStream(downloadPath.toString() + "/" + appFileName);
                byte data[] = new byte[1024];
                long total = 0;
                int count;
                while ((count = input.read(data)) != -1) {
                    total += count;
                    int percent = (int) (total * 100 / lenghtOfFile); //0~100
                    publishProgress(percent);
                    output.write(data, 0, count);
                }
                output.flush();
                output.close();
                input.close();
            } catch (IOException e) {
                Log.d("mark", "Download io Error:" + e.getMessage());
            } catch (SecurityException e) {
                Log.d("mark", "Download security Error:" + e.getMessage());
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if (result == null) {
                SetStateLabel("دانلود با موفقیت انجام شد");
                SwitchBusyIcon(false);
                btnUpdateLocal.setVisibility(View.VISIBLE);
                btnDownloadAndUpdate.setVisibility(View.GONE);
                circularProgress.setVisibility(View.GONE);
                // DoInstall();
            } else {
                SetStateLabel(result);
            }
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();

            SwitchBusyIcon(false);
            SetStateLabel("downloadCancel");
        }


    }


    private void SetStateLabel(String msg) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());
        String str = formatter.format(curDate);
        stateLabel.setText(msg);
    }

    private void DoInstall() {

        File downloadPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(downloadPath.getPath(), appFileName);
        if (!file.exists()) {
            SetStateLabel("fileNotExist");
            return;
        }

        Uri fileUri = Uri.fromFile(file);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            fileUri = FileProvider.getUriForFile(getActivity(), BuildConfig.APPLICATION_ID + ".provider", file);
        }

        Intent intent = new Intent(Intent.ACTION_VIEW, fileUri);
        intent.setDataAndType(fileUri, "application/vnd.android.package-archive");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.putExtra(Intent.EXTRA_NOT_UNKNOWN_SOURCE, true);

        this.startActivity(intent);
    }

    private void AskForPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int REQUEST_CODE = 101;
            String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};

            for (String str : permissions) {
                if (getActivity().checkSelfPermission(str) != PackageManager.PERMISSION_GRANTED) {
                    this.requestPermissions(permissions, REQUEST_CODE);
                    return;
                }
            }
        }
    }

    private void updateVersion() {
        ServerCoordinator.getInstance().getLastDocumentVersion(new Response.Listener<UpdateVersionResponseBean>() {
            @Override
            public void onResponse(UpdateVersionResponseBean response) {
                final int currentVersion = BuildConfig.VERSION_CODE;
                if (response != null) {
                    if (response.getrESULT().getDocument().getLastDocumentVersion() != null) {
                        txt_newVersionNo.setText(response.getrESULT().getDocument().getLastDocumentVersion().getVersionName());
                        versionCode = Integer.parseInt(response.getrESULT().getDocument().getLastDocumentVersion().getVersionNo());
                        updateUrl = response.getrESULT().getDocument().getLastDocumentVersion().getPathUrl();

                        System.out.println("currentVersion===" + currentVersion);
                        System.out.println("versionCode===" + versionCode);
                        if (currentVersion < versionCode) {
                            if (updateUrl != null) {
                                appFileName = GetFileNameFromUrl(updateUrl);
                                try {
                                    Date date = sdf.parse(response.getrESULT().getDocument().getLastDocumentVersion().getVersionDate());
                                    Calendar calendar = Calendar.getInstance();
                                    calendar.setTime(date);
                                    JalaliCalendarUtil jalaliCalendarUtil = new JalaliCalendarUtil(calendar);
                                    txt_newVersionDate.setText(jalaliCalendarUtil.getIranianYear() + "/" + jalaliCalendarUtil.getIranianMonth() + "/" + jalaliCalendarUtil.getIranianDay());
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                card_newVersion.setVisibility(View.VISIBLE);
                            } else {
                                card_null.setVisibility(View.VISIBLE);
                            }
                        }else {
                            card_null.setVisibility(View.VISIBLE);
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }

}
