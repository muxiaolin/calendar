package com.sange.calendar;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by blanke on 16-12-14.
 */

public class CalendarUtils {

    /**
     * 获得两个日期间距多少天
     *
     * @param beginDate
     * @param endDate
     */
    public static int getTimeDistance(Date beginDate, Date endDate) {
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(beginDate);
        fromCalendar.set(Calendar.HOUR_OF_DAY, fromCalendar.getMinimum(Calendar.HOUR_OF_DAY));
        fromCalendar.set(Calendar.MINUTE, fromCalendar.getMinimum(Calendar.MINUTE));
        fromCalendar.set(Calendar.SECOND, fromCalendar.getMinimum(Calendar.SECOND));
        fromCalendar.set(Calendar.MILLISECOND, fromCalendar.getMinimum(Calendar.MILLISECOND));

        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(endDate);
        toCalendar.set(Calendar.HOUR_OF_DAY, fromCalendar.getMinimum(Calendar.HOUR_OF_DAY));
        toCalendar.set(Calendar.MINUTE, fromCalendar.getMinimum(Calendar.MINUTE));
        toCalendar.set(Calendar.SECOND, fromCalendar.getMinimum(Calendar.SECOND));
        toCalendar.set(Calendar.MILLISECOND, fromCalendar.getMinimum(Calendar.MILLISECOND));

        long dayDistance = (toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / (1000 * 60 * 60 * 24);
        dayDistance = Math.abs(dayDistance);

        return (int) Math.abs(dayDistance);
    }

    /**
     * 获得两个日期间距多少月
     *
     * @param startCalendar
     * @param endCalendar
     */
    public static int betweenMonthByTwoCalendar(Calendar startCalendar, Calendar endCalendar) {
        //判断日期大小
        if (startCalendar.after(endCalendar)) {
            Calendar temp = startCalendar;
            startCalendar = endCalendar;
            endCalendar = temp;
        }
        int startYear = startCalendar.get(Calendar.YEAR);
        int endYear = endCalendar.get(Calendar.YEAR);
        int startMonth = startCalendar.get(Calendar.MONTH);
        int endMonth = endCalendar.get(Calendar.MONTH);
        int monthNum = (endYear - startYear) * 12 + (endMonth - startMonth);
        return monthNum;
    }

    public static Calendar getToDay() {
        Calendar toDay = Calendar.getInstance();
        int year = toDay.get(Calendar.YEAR);
        int month = toDay.get(Calendar.MONTH);
        int day = toDay.get(Calendar.DAY_OF_MONTH);
        toDay.clear();
        toDay.set(Calendar.YEAR, year);
        toDay.set(Calendar.MONTH, month);
        toDay.set(Calendar.DAY_OF_MONTH, day);
        return toDay;
    }

    public static Calendar getCalendar(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return calendar;
    }

    //或者这个月的天数
    public static int getMaxMonthCount(Calendar monthDay) {
        return monthDay.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}
