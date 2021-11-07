package gap.com.car.fragment;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import org.greenrobot.eventbus.EventBus;

import gap.com.car.R;
import gap.com.car.app.CarApplication;
import gap.com.car.model.EventBusModel;
import gap.com.car.util.Constant;
import gap.com.car.util.Util;

import static gap.com.car.R.id.content_frame;

public class SettingsFragment extends Fragment {

    //selectDayOfWeek, cancel, layout_them, layout_update, layout_privacy, layout_contactUs, layout_about,
    RelativeLayout cancel,layout_privacyNew,layout_update;
    //TextView showStartDate;
    RadioButton radioButton1, radioButton2, radioButton3;
    RadioGroup radioTypeOP;
    int getDay = 0;

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        //selectDayOfWeek = (RelativeLayout) view.findViewById(R.id.layout_selectDayOfWeek);
        //layout_them = (RelativeLayout) view.findViewById(R.id.layout_them);
        //layout_update = (RelativeLayout) view.findViewById(R.id.layout_update);
        //layout_privacy = (RelativeLayout) view.findViewById(R.id.layout_privacy);
        //layout_contactUs = (RelativeLayout) view.findViewById(R.id.layout_contactUs);
        //layout_about = (RelativeLayout) view.findViewById(R.id.layout_about);
        layout_privacyNew = (RelativeLayout) view.findViewById(R.id.layout_privacyNew);
        layout_update = (RelativeLayout) view.findViewById(R.id.layout_update);

       // showStartDate = (TextView) view.findViewById(R.id.showStartDate_txt);

        getDay = CarApplication.getInstance().getSharedPreferences().getInt(Constant.SELECT_START_WEEKDAY, -1);

      /*  switch (getDay) {
            case 1:
                showStartDate.setText(R.string.label_persian_p1);
                break;

            case 2:
                showStartDate.setText(R.string.label_persian_p2);
                break;

            case 3:
                showStartDate.setText(R.string.label_persian_p3);
                break;

            default:
                showStartDate.setText(R.string.label_persian_p1);
        }*/

       /* selectDayOfWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSelectDayOfWeek();
            }
        });*/


      /*  layout_fontSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToThemePage();
            }
        });*/

       /* layout_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUpdatePage();
            }
        });*/

        layout_privacyNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToPrivacyPage();
            }
        });

        layout_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUpdatePage();
            }
        });

       /* layout_contactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToContactUsPage();
            }
        });*/

        /*layout_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAboutPage();
            }
        });*/

        return view;
    }

    public void showSelectDayOfWeek() {
        final Dialog alert = new Dialog(getActivity());
        alert.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alert.setContentView(R.layout.custom_dialog);
        getDay = CarApplication.getInstance().getSharedPreferences().getInt(Constant.SELECT_START_WEEKDAY, 0);

        radioTypeOP = (RadioGroup) alert.findViewById(R.id.RadioGroupOP);
        radioButton1 = (RadioButton) alert.findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) alert.findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) alert.findViewById(R.id.radioButton3);
        cancel = (RelativeLayout) alert.findViewById(R.id.layout_cancel);

        switch (getDay) {
            case 1:
                radioButton1.setChecked(true);
                break;

            case 2:
                radioButton2.setChecked(true);
                break;

            case 3:
                radioButton3.setChecked(true);
                break;

            default:
                radioButton1.setChecked(true);
        }

      /*  radioTypeOP.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i) {
                    case R.id.radioButton1:
                        Util.recognizeSelectedDayOfWeek(Constant.SELECT_START_WEEKDAY, 1);
                        showStartDate.setText(R.string.label_persian_p1);
                        break;
                    case R.id.radioButton2:
                        Util.recognizeSelectedDayOfWeek(Constant.SELECT_START_WEEKDAY, 2);
                        showStartDate.setText(R.string.label_persian_p2);
                        break;
                    case R.id.radioButton3:
                        Util.recognizeSelectedDayOfWeek(Constant.SELECT_START_WEEKDAY, 3);
                        showStartDate.setText(R.string.label_persian_p3);
                        break;

                    default:
                        Util.recognizeSelectedDayOfWeek(Constant.SELECT_START_WEEKDAY, 1);
                        showStartDate.setText(R.string.label_persian_p1);
                }

                alert.dismiss();
            }
        });*/

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert.dismiss();
            }
        });

        alert.show();
    }


    public void goToThemePage() {
        Fragment fragment = new ThemeFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
        Util.recognizeSelectedItems(Constant.RECOGNIZE, "CreationLocalPasswordFragment");
        EventBus.getDefault().post(new EventBusModel("CreationLocalPasswordFragment"));
    }

    public void goToUpdatePage() {
        Fragment fragment = new UpdateFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
        Util.recognizeSelectedItems(Constant.RECOGNIZE, "UpdateFragment");
        EventBus.getDefault().post(new EventBusModel("UpdateFragment"));
    }

    public void goToPrivacyPage() {
        goToFragment(new PrivacyFragment());
        EventBus.getDefault().post(new EventBusModel("PrivacyFragment"));
    }

    public void goToContactUsPage() {
        Fragment fragment = new ContactUsFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
        Util.recognizeSelectedItems(Constant.RECOGNIZE, "ContactUsFragment");
        EventBus.getDefault().post(new EventBusModel("ContactUsFragment"));
    }

    public void goToAboutPage() {
        Fragment fragment = new AboutFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
        Util.recognizeSelectedItems(Constant.RECOGNIZE, "AboutFragment");
        EventBus.getDefault().post(new EventBusModel("AboutFragment"));
    }

    public void showCreateLocalPassword() {
        final Dialog alert = new Dialog(getActivity());
        alert.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alert.setContentView(R.layout.create_localpass_dialog);
        alert.show();
    }

    private void goToFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
        fragmentTransaction.replace(content_frame, fragment, fragment.getClass().getCanonicalName());
        fragmentTransaction.commit();
    }
}
