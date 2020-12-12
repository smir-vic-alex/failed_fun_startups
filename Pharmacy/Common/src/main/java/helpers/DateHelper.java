/**
 * Создано: Денис
 * Дата: 23.11.14
 * Описание: Класс-помошник для работы с датой.
 */
package helpers;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateHelper {

    /**
     * Возвращает дату обновления в виде слова, если последнее обновление было вчера или сегодня. В остальных случаях ДД.ММ
     * @param calendar Дата обновления
     * @return  Слово Вчера/Сегодня, если последнее обновление было вчера/сегодня. В остальных случаях ДД.ММ
     */
    public static String getDateUpdate(Calendar calendar){
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH) + 1;
        Calendar currentDate = new GregorianCalendar();
        int currentDay = currentDate.get(Calendar.DATE);
        int currentMonth = currentDate.get(Calendar.MONTH) + 1;
        if (month == currentMonth){
            switch(currentDay-day){
                case 0: return "Сегодня";
                case 1: return "Вчера";
            }
        }
        if (month < 10){
            return day + ".0" + month;
        }
        return day + "." + month;
    }

    /**
     * Возращает текущую дату в формате ДД.ММ
     * @return Дата в формате ДД.ММ
     */
    public static String getCurrentDateByString(){
        Calendar calendar = new GregorianCalendar();
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        StringBuilder string = new StringBuilder();
        if (day < 10){
            string.append("0");
        }
        string.append(day);
        if (month < 10){
            string.append("0");
        }
        string.append(month);
        return  string.toString();
    }

    /**
     * Получение текущей даты со временем 00.00 часов.
     * @return Текущая дата со временем 00.00 часов.
     */
    public static Calendar getCurrentDateInZeroTime(){
        Calendar date = new GregorianCalendar();
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
        return date;
    }
}
