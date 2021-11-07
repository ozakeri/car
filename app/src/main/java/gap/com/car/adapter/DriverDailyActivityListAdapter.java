package gap.com.car.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import gap.com.car.R;
import gap.com.car.gapcalendar.customweekview.Roozh;
import gap.com.car.model.carinvoice.DailyEventList;
import gap.com.car.util.Globals;

public class DriverDailyActivityListAdapter extends RecyclerView.Adapter<DriverDailyActivityListAdapter.CustomView> {
    private Context context;
    private ArrayList<DailyEventList> arrayList;
    private DateFormat sdf;
    private Calendar calendar = Calendar.getInstance();
    private Globals sharedData = Globals.getInstance();
    private Roozh roozh = new Roozh();
    private String date;
    private String sysParamStr;
    private String locateStr;
    private String subString;

    public DriverDailyActivityListAdapter(Context context, ArrayList<DailyEventList> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public CustomView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_tab_fragment1, parent, false);
        return new CustomView(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CustomView holder, int position) {

        DailyEventList dailyEventList = arrayList.get(position);
        Date startDate = null, endDate = null;
        sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        if (dailyEventList != null) {

            System.out.println("dailyEventList=====" + dailyEventList.getEvent().getName());
            System.out.println("dailyEventList=====" + dailyEventList.describeContents());
            System.out.println("dailyEventList=====" + dailyEventList.getEvent().getReasonSysParamStr());
        }

    }

    @Override
    public int getItemCount() {
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public class CustomView extends RecyclerView.ViewHolder {
        TextView txt_event, txt_eventLine, txt_fractionWork, txt_locateEvent, txt_eventDate;

        public CustomView(View itemView) {
            super(itemView);
            txt_event = itemView.findViewById(R.id.txt_event);
            txt_eventLine = itemView.findViewById(R.id.txt_eventLine);
            txt_fractionWork = itemView.findViewById(R.id.txt_fractionWork);
            txt_locateEvent = itemView.findViewById(R.id.txt_locateEvent);
            txt_eventDate = itemView.findViewById(R.id.txt_eventDate);
        }
    }
}
