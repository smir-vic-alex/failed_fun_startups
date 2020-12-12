/**
 * Создано: Денис 
 * Дата: 07.01.15
 * Описание: Интерфейс для всех статистик. Предполагется, что статистика сначала кешируется, потом вся разом сбрасывается
 */
package statistic;

import java.util.Calendar;

public interface Statistic {

    /**
     * Увеличение счётчика
     * @param id Id объекта, счётчик которого нужно увеличить
     */
    public void increment(Integer id);

    /**
     * Нужно ли обновить данные в БД
     * @return Да, если нужно. Нет в противном случае.
     */
    public boolean needFlush();

    /**
     * Сброс статистики в БД
     */
    public void flush();

    /**
     * Наступил ли следующий день
     * @return Да, если наступил. Нет в противном случае.
     */
    public boolean isNextDay(Calendar currentDate);
}
