package gap.com.car.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import gap.com.car.R;
import gap.com.car.common.CalendarUtil;
import gap.com.car.gapcalendar.customweekview.PersianDate;
import gap.com.car.gapcalendar.customweekview.Roozh;
import gap.com.car.gapcalendar.persianweekview.PersianCalendar;
import gap.com.car.model.CarDailyEventList;
import gap.com.car.model.carinvoice.DailyEventList;
import gap.com.car.util.Globals;
import gap.com.car.util.JalaliCalendarUtil;
import gap.com.car.util.Util;

public class CarDailyEventListAdapter extends RecyclerView.Adapter<CarDailyEventListAdapter.CustomView> {
    private Context context;
    private ArrayList<DailyEventList> arrayList;
    private DateFormat sdf;
    private Calendar calendar = Calendar.getInstance();
    private Globals sharedData = Globals.getInstance();
    private Roozh roozh = new Roozh();

    public CarDailyEventListAdapter(Context context, ArrayList<DailyEventList> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public CustomView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_tab_fragment2, parent, false);
        return new CustomView(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CustomView holder, int position) {

        DailyEventList dailyEventList = arrayList.get(position);
        sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        if (dailyEventList != null) {
            if (dailyEventList.getEvent().getName() != null){
                holder.txt_event.setText(dailyEventList.getEvent().getName());
            }

            if (dailyEventList.getLine()!= null && dailyEventList.getLine().getLineCode() != null){
                holder.txt_eventLine.setText(dailyEventList.getLine().getLineCode());
            }

            if (dailyEventList.getEventPositionEn_text() != null){
                holder.txt_locateEvent.setText(dailyEventList.getEventPositionEn_text());
            }


            if (dailyEventList.getFractionWork() != null){
                holder.txt_fractionWork.setText(dailyEventList.getFractionWork());
            }

            if (dailyEventList.getDateCreation() != null){
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                try {

                    Date date = simpleDateFormat.parse(dailyEventList.getDateCreation());
                    holder.txt_eventDate.setText(CalendarUtil.convertPersianDateTime(date, "HH:mm"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }


            }

            if (dailyEventList.getReasonSysParamStr() != null){
                holder.txt_info.setText(dailyEventList.getReasonSysParamStr());
            }

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
        TextView txt_event, txt_eventLine, txt_fractionWork, txt_locateEvent, txt_eventDate,txt_info;

        public CustomView(View itemView) {
            super(itemView);
            txt_event = itemView.findViewById(R.id.txt_event);
            txt_eventLine = itemView.findViewById(R.id.txt_eventLine);
            txt_fractionWork = itemView.findViewById(R.id.txt_fractionWork);
            txt_locateEvent = itemView.findViewById(R.id.txt_locateEvent);
            txt_eventDate = itemView.findViewById(R.id.txt_eventDate);
            txt_info = itemView.findViewById(R.id.txt_info);
        }
    }
}
