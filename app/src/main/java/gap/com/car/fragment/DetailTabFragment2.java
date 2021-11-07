package gap.com.car.fragment;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;

import gap.com.car.R;
import gap.com.car.adapter.CarDailyEventDetailListAdapter;
import gap.com.car.model.CarDailyEventList;
import gap.com.car.model.DailyEventDetailList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailTabFragment2 extends DialogFragment {

    private RecyclerView recyclerView;
    private ImageButton close;
    private CarDailyEventList carDailyEventList;

    public DetailTabFragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_fragment2_detail, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        close = view.findViewById(R.id.close);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            carDailyEventList = bundle.getParcelable("carDailyEventList");
            if (carDailyEventList != null) {
                ArrayList<DailyEventDetailList> dailyEventDetailLists = (ArrayList<DailyEventDetailList>) carDailyEventList.getDailyEventDetailList();
                recyclerView.setAdapter(new CarDailyEventDetailListAdapter(recyclerView.getContext(), dailyEventDetailLists));
            }
        }

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               getDialog().dismiss();
            }
        });

        return view;
    }

}
