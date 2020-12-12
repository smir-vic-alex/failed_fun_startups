/**
 * Создано: Денис 
 * Дата: 07.01.15
 * Описание: 
 */
package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import statistic.StatisticUtil;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitStatisticUtilListener implements ServletContextListener {

    private StatisticUtil statisticUtil = new StatisticUtil();
    private Thread thread;
    private Logger log = LogManager.getLogger(InitStatisticUtilListener.class);

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        log.info("Начало инициализация StatisticUtil");
        thread = new Thread(statisticUtil, "StatisticUtil");
        statisticUtil.setThread(thread);
        thread.start();
        log.info("StatisticUtil запущен");
    }


    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        statisticUtil.stop();
        if (thread.isAlive()){
            try {
                log.info("Ожидаем завершение работы StatisticUtil");
                thread.join();
            } catch (InterruptedException e) {
                log.error("Поток " + thread.getName() + "прерван", e);
            }
        }
        log.info("StatisticUtil завершил работу");
    }
}
