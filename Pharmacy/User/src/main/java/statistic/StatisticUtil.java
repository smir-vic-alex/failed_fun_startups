/**
 * Создано: Денис 
 * Дата: 07.01.15
 * Описание: 
 */
package statistic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StatisticUtil implements Runnable {

    private Thread thread;
    private boolean running = true;
    private static Map<Class, Statistic> statisticMap = new HashMap<>();
    private Logger log = LogManager.getLogger(StatisticUtil.class);

    public StatisticUtil() {
        statisticMap.put(PharmacyStatistic.class, new PharmacyStatistic());
        statisticMap.put(MedicamentStatistic.class, new MedicamentStatistic());
    }

    public void run() {

        Set<Class> setKey = statisticMap.keySet();
        while (running) {
            try {
                for (Class key : setKey) {
                    Statistic statistic = statisticMap.get(key);
                    if (statistic.needFlush()) {
                        statistic.flush();
                    }
                }
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                log.error("Поток " + thread.getName() + " прерван", e);
            } catch (Exception e) {
                log.error("Ошибка в StatisticUtil", e);
            }
        }
        try{
            for (Class key : setKey) {
                Statistic statistic = statisticMap.get(key);
                statistic.flush();
            }
        }catch (Exception e) {
            log.error("Ошибка в StatisticUtil", e);
        }


    }

    public static Statistic getStatistic(Class key) {
        return statisticMap.get(key);
    }

    public void stop() {
        log.info("Завершение работы StatisticUtil");
        running = false;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }
}
