/**
 * Создано: Денис 
 * Дата: 07.01.15
 * Описание: Базовый класс для сбора статистики
 */
package statistic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseStatistic implements Statistic {

    private static final int DEFAULT_INTERVAL_IN_HOUR = 1;
    protected Map<Integer, LightInteger> map = new HashMap<>();
    protected Calendar lastUpdateTime = new GregorianCalendar();
    protected final long INTERVAL;
    protected final Logger LOG = LogManager.getLogger(BaseStatistic.class);
    private final String STATISTIC_NAME;

    protected BaseStatistic(String name) {
        this(DEFAULT_INTERVAL_IN_HOUR, name);
    }

    protected BaseStatistic(int timeIntervalInHour, String name) {
        this.INTERVAL = timeIntervalInHour * 3600000;
        this.STATISTIC_NAME = name;
        LOG.info("Установлен интервал " + timeIntervalInHour + "ч. для статистики \"" + this.STATISTIC_NAME + "\"");
    }

    public synchronized void increment(Integer id) {
        LightInteger count = map.get(id);
        if (count == null){
            count = new LightInteger();
        }
        count.incrementOn(1);
        map.put(id, count);
    }

    public boolean needFlush() {
        Calendar currentTime = new GregorianCalendar();
        long deltaTime = currentTime.getTimeInMillis() - lastUpdateTime.getTimeInMillis();
        return INTERVAL < deltaTime || isNextDay(currentTime);
    }


    public boolean isNextDay(Calendar currentDate) {
        int currentMonth = currentDate.get(Calendar.MONTH);
        int lastMonth = lastUpdateTime.get(Calendar.MONTH);
        if (currentMonth == lastMonth) {
            return currentDate.get(Calendar.DAY_OF_MONTH) > lastUpdateTime.get(Calendar.DAY_OF_MONTH);
        }
        return true;
    }
}
