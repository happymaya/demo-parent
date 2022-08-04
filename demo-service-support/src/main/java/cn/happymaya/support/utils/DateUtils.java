package cn.happymaya.support.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * The utility of the date.
 *
 * @author superhsc
 */
public class DateUtils {
    private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";

    /**
     * @param date date
     * @return 将 Date 转换为 Calendar
     */
    public static Calendar getCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    /**
     * @return 获取当前时间的Calendar
     */
    public static Calendar getCalendar() {
        Calendar calendar = Calendar.getInstance();
        return calendar;
    }

    /**
     * @return 获取当前时间
     */
    public static Date getNow() {
        return getCalendar().getTime();
    }

    /**
     * @param string string
     * @param format format
     * @return 将日期时间字符串按照某种格式转换为日期时间
     */
    public static Date getDate(String string, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(string);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param string string
     * @return 将日期时间字符串按照默认格式转换为日期时间
     */
    public static Date getDate(String string) {
        return getDate(string, dateFormat);
    }
}
