package gap.com.car.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import gap.com.car.R;
import gap.com.car.adapter.PersonTimeOffAdapter;
import gap.com.car.database.DataBaseClint;
import gap.com.car.model.EventBusModel;
import gap.com.car.database.entity.PersonTimeOff;
import gap.com.car.util.Globals;

public class ListLeaveFragment extends Fragment {

    private Fragment fragment;
    private FragmentManager fragmentManager;
    private Globals sharedData = Globals.getInstance();
    private int year;
    private int month;
    private int day;
    private FloatingActionButton floatingActionButton;
    private List<PersonTimeOff> list = new ArrayList<>();
    private RecyclerView recyclerView;
    private PersonTimeOffAdapter adapter;
    private AppCompatTextView txt_null;

    public ListLeaveFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_leave_layout, container, false);

        getAll();

        floatingActionButton = view.findViewById(R.id.floatingActionButton);
        recyclerView = view.findViewById(R.id.recyclerView);
        txt_null = view.findViewById(R.id.txt_null);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new LeaveFragment();
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                EventBus.getDefault().post(new EventBusModel("LeaveFragment"));
            }
        });

        return view;
    }

    private void getAll() {
        class GetPersonTimeOffList extends AsyncTask<Void, Void, List<PersonTimeOff>> {

            @Override
            protected List<PersonTimeOff> doInBackground(Void... voids) {
                list = DataBaseClint.getInstance(getActivity()).getAppDataBase().personTimeOffDao().getAll();
                return list;
            }

            @Override
            protected void onPostExecute(List<PersonTimeOff> personTimeOffs) {
                super.onPostExecute(personTimeOffs);
                if (personTimeOffs.size() > 0){
                    txt_null.setVisibility(View.GONE);
                }
                recyclerView.setAdapter(new PersonTimeOffAdapter(getActivity(), personTimeOffs));
            }
        }
        new GetPersonTimeOffList().execute();
    }
}
