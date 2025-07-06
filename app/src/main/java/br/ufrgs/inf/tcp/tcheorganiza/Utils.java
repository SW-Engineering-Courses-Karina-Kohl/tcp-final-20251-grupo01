package br.ufrgs.inf.tcp.tcheorganiza;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Locale;

public class Utils {

    public static String getTodayWeekDayInPortuguese(){
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        String[] weekdays = new DateFormatSymbols(new Locale("pt", "BR")).getWeekdays();
        return weekdays[dayOfWeek];
    }
}
