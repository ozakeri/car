package gap.com.car.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import gap.com.car.R;
import gap.com.car.app.CarApplication;
import gap.com.car.common.Constants;

public class ThemeFragment extends Fragment {

    private SeekBar seekBar;
    private int size;

    public ThemeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.theme_fragment, container, false);
        seekBar = (SeekBar) view.findViewById(R.id.seekbar);

        int size = CarApplication.getInstance().getSharedPreferences().getInt(Constants.PREF_FONT_SIZE, -1);
        if (size > -1) {
            seekBar.setProgress(size);
            ThemeFragment.this.size = size;
        }

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


                ThemeFragment.this.size = progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        view.findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = CarApplication.getInstance().getSharedPreferences().edit();
                editor.putInt(Constants.PREF_FONT_SIZE, ThemeFragment.this.size);
                editor.apply();
            }
        });
        return view;
    }

}
