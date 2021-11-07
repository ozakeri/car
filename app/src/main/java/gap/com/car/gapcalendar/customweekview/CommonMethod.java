package gap.com.car.gapcalendar.customweekview;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CommonMethod {

    private static final String[] numNames = {
            "",
            " فروردین",
            " اردیبهشت",
            " خرداد",
            " تیر",
            " مرداد",
            " شهریور",
            " مهر",
            " آبان",
            " آذر",
            " دی",
            " بهمن",
            " اسفند"
    };

    public static String convertWeekDays(String date) {
        String formattedDate = null;
        PersianCalendar persianCalendar = new PersianCalendar();
        try {
            SimpleDateFormat originalFormat = new SimpleDateFormat(
                    "yyyy-MM-dd", Locale.ENGLISH);
            SimpleDateFormat targetFormat = new SimpleDateFormat("dd");
            Date date12 = originalFormat.parse(date);
            String s = String.valueOf(persianCalendar.getPersianDayOfMonth(date12));
            formattedDate = s;
            System.out.println("formattedDate=" + formattedDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return faToEn(formattedDate);
    }

    public static String convertWeekMonthDays(String date) {
        String formattedDate = null;
        PersianCalendar persianCalendar = new PersianCalendar();
        try {
            SimpleDateFormat originalFormat = new SimpleDateFormat(
                    "yyyy-MM-dd", new Locale("fa"));
            SimpleDateFormat targetFormat = new SimpleDateFormat("dd");
            Date date12 = originalFormat.parse(date);
            String s = String.valueOf(persianCalendar.getPersianDayOfMonth(date12));
            String s2 = String.valueOf(persianCalendar.getPersianMonth(date12));
            String sName = String.valueOf(persianCalendar.getDayOfWeek(date12));
            char first = sName.charAt(0);
            formattedDate = first +" " + s2 + "/" + s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return faToEn(formattedDate);
    }


    public static String convertWeekDaysMouth(String date) {
        String formattedDate = null;
        PersianCalendar persianCalendar = new PersianCalendar();
        try {
            SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd", new Locale("fa"));
            SimpleDateFormat targetFormat = new SimpleDateFormat("MMM yyyy");
            Date date12 = originalFormat.parse(date);
            //formattedDate = targetFormat.format(date12);
            String s = String.valueOf(persianCalendar.getPersianMonth(date12));
            formattedDate = convertLessThanOneThousand(Integer.parseInt(s));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return faToEn(formattedDate);

    }

    public static String convertWeekDaysYear(String date) {
        String s2 = null;
        PersianCalendar persianCalendar = new PersianCalendar();
        try {
            SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd", new Locale("fa"));
            SimpleDateFormat targetFormat = new SimpleDateFormat("MMM yyyy");
            Date date12 = originalFormat.parse(date);
            s2 = String.valueOf(persianCalendar.getPersianYear(date12));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return faToEn(s2);

    }

    public static String convertLessThanOneThousand(int number) {
        String soFar;

        if (number % 100 < 20) {
            soFar = numNames[number % 100];
            number /= 100;
        } else {
            soFar = numNames[number % 10];
            number /= 10;

            soFar = numNames[number % 10] + soFar;
            number /= 10;
        }
        if (number == 0) return soFar;
        return numNames[number] + " hundred" + soFar;
    }

    public static String faToEn(String num) {
        return num
                .replace("0", "۰")
                .replace("1", "۱")
                .replace("2", "۲")
                .replace("3", "۳")
                .replace("4", "۴")
                .replace("5", "۵")
                .replace("6", "۶")
                .replace("7", "۷")
                .replace("8", "۸")
                .replace("9", "۹");
    }


}
