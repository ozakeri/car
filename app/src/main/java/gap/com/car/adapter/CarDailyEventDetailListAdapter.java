package gap.com.car.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import gap.com.car.R;
import gap.com.car.common.CalendarUtil;
import gap.com.car.gapcalendar.customweekview.Roozh;
import gap.com.car.model.DailyEventDetailList;
import gap.com.car.util.Globals;
import gap.com.car.util.Util;

public class CarDailyEventDetailListAdapter extends RecyclerView.Adapter<CarDailyEventDetailListAdapter.CustomView> {
    private Context context;
    private ArrayList<DailyEventDetailList> arrayList = new ArrayList<>();
    private DateFormat sdf;
    private Calendar calendar = Calendar.getInstance();
    private Globals sharedData = Globals.getInstance();
    private Roozh roozh = new Roozh();

    public CarDailyEventDetailListAdapter(Context context, ArrayList<DailyEventDetailList> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public CustomView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_detail_tab_fragment2, parent, false);
        return new CustomView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomView holder, int position) {

        DailyEventDetailList dailyEventDetailList = arrayList.get(position);
        Date startDate, endDate;
        sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        if (dailyEventDetailList != null) {

            if (dailyEventDetailList.getPathType() == 0) {
                holder.txt_pathType.setText(R.string.pathType_0);
            } else if (dailyEventDetailList.getPathType() == 1) {
                holder.txt_pathType.setText(R.string.pathType_1);
            }

            try {
                startDate = sdf.parse(dailyEventDetailList.getStartTime());
                endDate = sdf.parse(dailyEventDetailList.getEndTime());

                roozh.PersianToGregorian(sharedData.getYear(), sharedData.getMonth(), sharedData.getYear());
                calendar.set(roozh.getYear(), roozh.getMonth(), roozh.getDay());
                calendar.add(Calendar.MONTH, -1);
                Date date = calendar.getTime();

                if (Util.compareDates(date, date) == 0) {
                    holder.txt_startDate.setText(CalendarUtil.convertPersianDateTime(startDate, "HH:mm"));
                    holder.txt_endDate.setText(CalendarUtil.convertPersianDateTime(endDate, "HH:mm"));
                } else {
                    holder.txt_startDate.setText(CalendarUtil.convertPersianDateTime(startDate, "yyyy/MM/dd - HH:mm:ss"));
                    holder.txt_endDate.setText(CalendarUtil.convertPersianDateTime(endDate, "yyyy/MM/dd - HH:mm:ss"));
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if (position % 2 == 0) {
            holder.linearLayout1.setBackgroundResource(R.color.mdtp_circle_color);
        } else {
            holder.linearLayout1.setBackgroundResource(R.color.mdtp_circle_color1);
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
        TextView txt_pathType, txt_startDate, txt_endDate, txt_time;
        LinearLayout linearLayout1;

        public CustomView(View itemView) {
            super(itemView);
            txt_pathType = itemView.findViewById(R.id.txt_pathType);
            txt_startDate = itemView.findViewById(R.id.txt_startDate);
            txt_endDate = itemView.findViewById(R.id.txt_endDate);
            linearLayout1 = itemView.findViewById(R.id.linearLayout1);
        }
    }
}
