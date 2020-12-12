/**
 * Создано: Денис 
 * Дата: 05.04.15
 * Описание: 
 */
package checkForm.parsers;

import exceptions.ParserException;
import helpers.DateHelper;

import java.util.Calendar;

public class CalendarParser implements FieldParser {

    @Override
    public Object parser(String entity) throws ParserException {
        Calendar calendar = DateHelper.getCurrentDateInZeroTime();
        Integer day = Integer.parseInt(entity.substring(0,2));
        Integer month = Integer.parseInt(entity.substring(3,5)) - 1;
        Integer year = Integer.parseInt(entity.substring(6,10));
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);
        return calendar;
    }
}
