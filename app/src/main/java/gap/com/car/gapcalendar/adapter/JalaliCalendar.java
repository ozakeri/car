package gap.com.car.gapcalendar.adapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import gap.com.car.R;
import gap.com.car.app.CarApplication;
import gap.com.car.gapcalendar.customweekview.PersianDate;
import gap.com.car.gapcalendar.customweekview.DateConvertor;
import gap.com.car.gapcalendar.customweekview.Roozh;
import gap.com.car.model.CheckView;
import gap.com.car.model.SalaryAttributeList;
import gap.com.car.util.Constant;
import gap.com.car.util.Globals;
import gap.com.car.util.Util;

public class JalaliCalendar extends BaseAdapter {
    private static final String tag = "JalaliAdapter";
    private DateConvertor dateConvertor;
    private Context _context = null;
    private List<String> list = null;
    private static final int DAY_OFFSET = 0;
    private int currentDayOfMonth;
    private Globals shareData = Globals.getInstance();
    private DateConvertor tmpDateConvertor = new DateConvertor();
    private String dayName, monthName;
    private ArrayList<SalaryAttributeList> arrayList;
    Roozh roozh = new Roozh();
    private CheckView checkView = new CheckView();
    private TextView gridCell,calendar_day_gridcell_1,calendar_day_gridcell_2,calendar_description,id;
    private RelativeLayout relativeLayout;
    private ImageView statusIcon;

    public JalaliCalendar(Context context, int year, int month, int day, ArrayList<SalaryAttributeList> arrayList) {
        super();
        this._context = context;
        this.list = new ArrayList<String>();
        this.dateConvertor = new DateConvertor();
        this.dateConvertor.setIranianDate(year, month, day);
        this.currentDayOfMonth = this.dateConvertor.getIranianDay();
        this.printMonth(month, year);
        this.arrayList = arrayList;

    }

    private void printMonth(int mm, int yy) {
        int trailingSpaces = 0;
        int daysInPrevMonth = 0;
        int prevMonth = 0;
        int prevYear = 0;
        int nextMonth = 0;
        int nextYear = 0;

        int currentMonth = mm - 1;
        String currentMonthName = this.dateConvertor.getMonthName(currentMonth);//getMonthAsString(currentMonth);
        int daysInMonth = this.dateConvertor.getDaysInMonth(currentMonth);


        if (currentMonth == 11) {
            prevMonth = currentMonth - 1;
            daysInPrevMonth = this.dateConvertor.getDaysInMonth(prevMonth);//getNumberOfDaysOfMonth(prevMonth);
            nextMonth = 0;
            prevYear = yy;
            nextYear = yy + 1;
        } else if (currentMonth == 0) {
            prevMonth = 11;
            prevYear = yy - 1;
            nextYear = yy;
            daysInPrevMonth = this.dateConvertor.getDaysInMonth(prevMonth);//getNumberOfDaysOfMonth(prevMonth);
            nextMonth = 1;
        } else {
            prevMonth = currentMonth - 1;
            nextMonth = currentMonth + 1;
            nextYear = yy;
            prevYear = yy;
            daysInPrevMonth = this.dateConvertor.getDaysInMonth(prevMonth);//getNumberOfDaysOfMonth(prevMonth);
        }

        //DateConvertor tmpDateConvertor = new DateConvertor();

        int getStartWeek = CarApplication.getInstance().getSharedPreferences().getInt(Constant.SELECT_START_WEEKDAY, 0);
        switch (getStartWeek) {
            case 1:
                tmpDateConvertor.setIranianDate(yy, mm, 1);
                break;
            case 2:
                tmpDateConvertor.setIranianDate(yy, mm, 0);
                break;
            case 3:
                tmpDateConvertor.setIranianDate(yy, mm, -1);
                break;

            default:
                tmpDateConvertor.setIranianDate(yy, mm, 1);
        }

        //this.dateConvertor.setIranianDate(yy, mm, 1);
        GregorianCalendar cal = new GregorianCalendar(tmpDateConvertor.getGregorianYear(), tmpDateConvertor.getGregorianMonth() - 1, tmpDateConvertor.getGregorianDay());
        ////
        int currentWeekDay = cal.get(Calendar.DAY_OF_WEEK) - 1;

        trailingSpaces = (currentWeekDay + 1) % 7;


        /*Calculate Leap Years*/
        if (tmpDateConvertor.IsLeap(yy))
            if (mm == 12)
                ++daysInMonth;
            else if (mm == 1)
                ++daysInPrevMonth;

        // Trailing Month days
        for (int i = 0; i < trailingSpaces; i++) {
            list.add(String
                    .valueOf((daysInPrevMonth - trailingSpaces + DAY_OFFSET)
                            + i)
                    + "-GREY"
                    + "-"
                    + this.dateConvertor.getMonthName(prevMonth)//getMonthAsString(prevMonth)
                    + "-"
                    + prevYear);

        }

        // Current Month Days
        for (int i = 1; i <= daysInMonth; i++) {

            if (i == this.currentDayOfMonth) {
                list.add(String.valueOf(i) + "-BLUE" + "-"
                        + this.dateConvertor.getMonthName(currentMonth) + "-" + yy);
            } else {
                list.add(String.valueOf(i) + "-WHITE" + "-"
                        + this.dateConvertor.getMonthName(currentMonth) + "-" + yy);
            }
        }

        // Leading Month days
        for (int i = 0; i < list.size() % 7; i++) {
            list.add(String.valueOf(i + 1) + "-GREY" + "-"
                    + this.dateConvertor.getMonthName(nextMonth) + "-" + nextYear);
        }

        this.change2RTL();
    }

    /**
     * Changes the order of the List items to suite the RTL formatting.
     */
    private void change2RTL() {
        List<String> tmList1 = new ArrayList<String>();
        List<String> lstRTL = new ArrayList<String>();

        for (int i = 0; i < this.list.size(); i += 7) {
            tmList1.clear();
            for (int c = i; c < i + 7; c++) {
                tmList1.add(this.list.get(c));
            }

            Collections.reverse(tmList1);
            lstRTL.addAll(tmList1);
        }

        this.list.clear();
        this.list.addAll(lstRTL);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public String getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @SuppressLint({"SetTextI18n", "ResourceAsColor"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.screen_gridcell, parent, false);
        }

        gridCell = (TextView) convertView.findViewById(R.id.calendar_day_gridcell);
        calendar_day_gridcell_1 = (TextView) convertView.findViewById(R.id.calendar_day_gridcell_1);
        calendar_day_gridcell_2 = (TextView) convertView.findViewById(R.id.calendar_day_gridcell_2);
        calendar_description = (TextView) convertView.findViewById(R.id.calendar_description);
        id = (TextView) convertView.findViewById(R.id.id);
        relativeLayout = (RelativeLayout) convertView.findViewById(R.id.relativeLayout);
        statusIcon = (ImageView) convertView.findViewById(R.id.statusIcon);

        //checkView.setCheckView(false);
        // Get a reference to the Day gridcell

        // ACCOUNT FOR SPACING

        String[] day_color = list.get(position).split("-");
        String theday = day_color[0];
        String themonth = day_color[2];
        String theyear = day_color[3];

        String monthNumber = CarApplication.getInstance().monthNameNum(themonth);

        String s = Util.faToEn(theday);
        gridCell.setText(s);
        calendar_day_gridcell_1.setText(s);
        calendar_day_gridcell_2.setText(s);

        gridCell.setTag(theday + "-" + themonth + "-" + theyear);

        String currentDate = themonth + "  " + theyear;
        shareData.setMonthMenuDate(themonth);

        gap.com.car.gapcalendar.customweekview.PersianDate persianDate = new PersianDate();
        dayName = persianDate.dayName(Integer.parseInt(theyear), Integer.parseInt(monthNumber), Integer.parseInt(theday));
        monthName = themonth;

        TextView spinner_txt = (TextView) ((Activity) _context).findViewById(R.id.spinner_txt);
        spinner_txt.setText(Util.faToEn(currentDate));

        if (day_color[1].equals("GREY")) {
            gridCell.setTextColor(this._context.getResources().getColor(R.color.lightgray02));
            relativeLayout.setBackgroundResource(R.color.lightgray03);
        }
        if (day_color[1].equals("WHITE")) {
            gridCell.setTextColor(this._context.getResources().getColor(R.color.oil));
            relativeLayout.setBackgroundResource(R.color.lightgray);
        }
        if (day_color[1].equals("BLUE")) {
            gridCell.setTextColor(this._context.getResources().getColor(R.color.black));
            gridCell.setTextSize(20);
            relativeLayout.setBackgroundResource(R.color.white);

            shareData.setDayMenuDate(gridCell.getText() + "-" + themonth);
            shareData.setWeekMenuDate(1 + "-" + 7 + " " + themonth);

        }

        if (!day_color[1].equals("GREY")) {

            roozh.PersianToGregorian(Integer.parseInt(theyear), Integer.parseInt(monthNumber), Integer.parseInt(theday));

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

            for (SalaryAttributeList salaryAttributeListBean : arrayList) {
                try {
                    Date date1 = sdf.parse(String.valueOf(roozh));
                    Date date2 = sdf.parse(salaryAttributeListBean.getDate());

                    if (date1.equals(date2)) {
                        id.setText(salaryAttributeListBean.getId().toString());
                        if (salaryAttributeListBean.getDailyWorkTypeEn().equals(0)) {
                            //شاغل
                            gridCell.setBackgroundResource(R.drawable.white_circle_drawable);

                        } else if (salaryAttributeListBean.getDailyWorkTypeEn().equals(1)) {
                            //روز تعطیل

                        } else if (salaryAttributeListBean.getDailyWorkTypeEn().equals(2)) {
                            //مرخصی استحقاقی
                            calendar_description.setText(R.string.label_jalaliCalendar_TimeOFFEntitlement);

                        } else if (salaryAttributeListBean.getDailyWorkTypeEn().equals(3)) {
                            //مرخصی بدون حقوق
                            calendar_description.setText(R.string.label_jalaliCalendar_TimeOFFWithoutRights);

                        } else if (salaryAttributeListBean.getDailyWorkTypeEn().equals(4)) {
                            //مرخصی استعلاجی
                            calendar_description.setText(R.string.label_jalaliCalendar_TimeOFFSick);

                        } else if (salaryAttributeListBean.getDailyWorkTypeEn().equals(5)) {
                            //غیبت
                            calendar_description.setText(R.string.label_jalaliCalendar_Absence);

                        } else if (salaryAttributeListBean.getDailyWorkTypeEn().equals(6)) {
                            //ماموریت
                            calendar_description.setText(R.string.label_jalaliCalendar_Duty);

                        }
                    }

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            if (dayName.equals("جمعه")) {
                //relativeLayout.setBackgroundResource(R.color.orrange);
                calendar_day_gridcell_1.setVisibility(View.VISIBLE);
                calendar_day_gridcell_2.setVisibility(View.GONE);

            }

            if (dayName.equals("پنج\u200Cشنبه")) {
                //relativeLayout.setBackgroundResource(R.color.orange_low);
                calendar_day_gridcell_2.setVisibility(View.VISIBLE);
                calendar_day_gridcell_1.setVisibility(View.GONE);

            }
        }

        return convertView;
    }

	/*@Override
    public void onClick(View view) {
		//Toast.makeText(_context, String.valueOf(view.getId()), Toast.LENGTH_SHORT).show();
		Button btn = (Button) view;
		//btn.setText("clicked");
		String date_month_year = (String) view.getTag();
		//selectedDayMonthYearButton.setText("Selected: " + date_month_year);
		Log.e("Selected date", date_month_year);
		try {
			//Date parsedDate = dateFormatter.parse(date_month_year);
			//Log.d(tag, "Parsed Date: " + parsedDate.toString());

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}*/

}
