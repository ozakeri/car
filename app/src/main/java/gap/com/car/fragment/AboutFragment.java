package gap.com.car.fragment;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uncopt.android.widget.text.justify.JustifiedTextView;

import gap.com.car.R;

public class AboutFragment extends Fragment {

    private TextView txt_site;
    private JustifiedTextView justifiedTextView;


    public AboutFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.about_fragment, container, false);
        txt_site = view.findViewById(R.id.txt_site);
        justifiedTextView = view.findViewById(R.id.justifiedTextView);
        justifiedTextView.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "YekanBakhBold.ttf"));


        return view;
    }

}
