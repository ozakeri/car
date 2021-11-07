package gap.com.car.fragment;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import gap.com.car.R;
import gap.com.car.model.CarDailyEventList;
import gap.com.car.model.SalaryAttribute;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment2 extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<CarDailyEventList> carDailyEventList;
    private FragmentManager fragmentManager;
    private SalaryAttribute salaryAttribute;
    private TextView showEmpty_txt;


    public TabFragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_fragment2, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        showEmpty_txt = view.findViewById(R.id.showEmpty_txt);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        showEmpty_txt.setVisibility(View.GONE);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            salaryAttribute = bundle.getParcelable("salaryAttribute");
            if (salaryAttribute != null) {
                if (salaryAttribute.getDriverDailyActivity() != null) {
                    carDailyEventList = (ArrayList<CarDailyEventList>) salaryAttribute.getDriverDailyActivity().getCarDailyEventList();
                   // recyclerView.setAdapter(new CarDailyEventListAdapter(recyclerView.getContext(), carDailyEventList));
                    if (carDailyEventList == null) {
                        showEmpty_txt.setVisibility(View.VISIBLE);
                    }
                }
            } else {
                showEmpty_txt.setVisibility(View.VISIBLE);
            }
        }

 /*       recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(recyclerView.getContext(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                CarDailyEventList carDailyEventList1 = carDailyEventList.get(position);
                fragmentManager = getActivity().getSupportFragmentManager();
                DetailTabFragment2 detailTabFragment2 = new DetailTabFragment2();
                Bundle args = new Bundle();
                args.putParcelable("carDailyEventList", carDailyEventList1);
                detailTabFragment2.setArguments(args);
                detailTabFragment2.show(fragmentManager, "fragment_edit_name");
            }
        }));*/
        return view;
    }

}
