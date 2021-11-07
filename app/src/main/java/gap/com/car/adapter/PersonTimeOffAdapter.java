package gap.com.car.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import gap.com.car.R;
import gap.com.car.database.entity.PersonTimeOff;
import gap.com.car.util.JalaliCalendarUtil;

public class PersonTimeOffAdapter extends RecyclerView.Adapter<PersonTimeOffAdapter.CustomView> {
    private Context context;
    private List<PersonTimeOff> personTimeOffArrayList = new ArrayList<>();

    public PersonTimeOffAdapter(Context context, List<PersonTimeOff> arrayList) {
        this.context = context;
        this.personTimeOffArrayList = arrayList;
    }

    @NonNull
    @Override
    public CustomView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list_person_time_off, parent, false);
        return new CustomView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomView holder, int position) {
        PersonTimeOff personTimeOff = personTimeOffArrayList.get(position);
        if (personTimeOff != null) {

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            try {
                Date date1 = formatter.parse(personTimeOff.getStartDate());
                Date date2 = formatter.parse(personTimeOff.getFinishDate());

                Calendar calender1 = Calendar.getInstance();
                calender1.setTime(date1);
                JalaliCalendarUtil jalaliCalendarUtil = new JalaliCalendarUtil(calender1);
                holder.txt_startDate.setText(jalaliCalendarUtil.getIranianWeekDayStr() + " " + jalaliCalendarUtil.getIranianDate3());

                Calendar calender2 = Calendar.getInstance();
                calender2.setTime(date2);
                jalaliCalendarUtil = new JalaliCalendarUtil(calender2);
                holder.txt_endDate.setText(jalaliCalendarUtil.getIranianWeekDayStr() + " " + jalaliCalendarUtil.getIranianDate3());

            } catch (ParseException e) {
                e.printStackTrace();
            }



            switch (personTimeOff.getPersonTimeOffTypeEn()){
                case 0:
                    holder.txt_type.setText("استحقاقی");
                    break;

                case 1:
                    holder.txt_type.setText("بدون حقوق");
                    break;

                case 2:
                    holder.txt_type.setText("استعلاجی");
                    break;
            }

            holder.txt_status.setText(String.valueOf(personTimeOff.getProcessStatusText()));
        }
    }

    @Override
    public int getItemCount() {
        return personTimeOffArrayList.size();
    }

    public class CustomView extends RecyclerView.ViewHolder {

        private TextView txt_startDate, txt_endDate, txt_type, txt_status;

        public CustomView(@NonNull View itemView) {
            super(itemView);
            txt_startDate = itemView.findViewById(R.id.txt_startDate);
            txt_endDate = itemView.findViewById(R.id.txt_endDate);
            txt_type = itemView.findViewById(R.id.txt_type);
            txt_status = itemView.findViewById(R.id.txt_status);
        }
    }
}
