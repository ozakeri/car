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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import gap.com.car.R;
import gap.com.car.common.CalendarUtil;
import gap.com.car.gapcalendar.customweekview.Roozh;
import gap.com.car.model.carinvoice.HalfPathInfoList;
import gap.com.car.util.Globals;

public class HalfPathListAdapter extends RecyclerView.Adapter<HalfPathListAdapter.CustomView> {
    private Context context;
    private ArrayList<HalfPathInfoList> arrayList;
    private DateFormat sdf;
    private Calendar calendar = Calendar.getInstance();
    private Globals sharedData = Globals.getInstance();
    private Roozh roozh = new Roozh();

    public HalfPathListAdapter(Context context, ArrayList<HalfPathInfoList> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public CustomView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.halft_path_item_lis, parent, false);
        return new CustomView(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CustomView holder, int position) {

        HalfPathInfoList halfPathInfoList = arrayList.get(position);

        if (halfPathInfoList != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            try {
                Date startDate = simpleDateFormat.parse(halfPathInfoList.getStartTime());
                Date finishDate = simpleDateFormat.parse(halfPathInfoList.getEndTime());
                holder.txt_startTime.setText(CalendarUtil.convertPersianDateTime(startDate, "HH:mm"));
                holder.txt_endTime.setText(CalendarUtil.convertPersianDateTime(finishDate, "HH:mm"));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            //holder.txt_date.setText(halfPathInfoList.getPlaningDate());
            //holder.txt_line.setText(halfPathInfoList.getLineCode());
            holder.txt_halfType.setText(halfPathInfoList.getDispatchTypeEn_text());
            holder.txt_routeType.setText(halfPathInfoList.getPathType_text());
           // holder.txt_startTime.setText(halfPathInfoList.getStartTime());
           // holder.txt_endTime.setText(halfPathInfoList.getEndTime());
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
        TextView txt_halfType, txt_routeType, txt_startTime,txt_endTime;

        public CustomView(View itemView) {
            super(itemView);
            txt_halfType = itemView.findViewById(R.id.txt_halfType);
            txt_routeType = itemView.findViewById(R.id.txt_routeType);
            txt_startTime = itemView.findViewById(R.id.txt_startTime);
            txt_endTime = itemView.findViewById(R.id.txt_endTime);
        }
    }
}
