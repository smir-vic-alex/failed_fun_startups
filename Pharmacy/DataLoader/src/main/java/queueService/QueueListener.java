package queueService;
/**
 * Created by Виктор on 08.11.2014.
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class QueueListener implements ServletContextListener {

    private static final String NAME_THREAD = "queueHandlerThread";
    protected final Logger LOG = LogManager.getLogger(QueueListener.class);
    private QueueHandler queueHandler;
    private Thread queueHandlerThread;

    /**
     * Старт потока для обработки очереди
     * @param servletContextEvent
     */
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOG.info("Запуск потока " + NAME_THREAD + " для обработки очереди");
        queueHandler = new QueueHandler();
        queueHandler.setRunning(true);
        queueHandlerThread = new Thread(queueHandler, NAME_THREAD);
        queueHandlerThread.start();
        LOG.info("Поток " + NAME_THREAD + " запущен");
    }

    /**
     * Блокировка возможности добавление в очередь и прекращение работы потока, после того как последние данные из очереди будут изъяты
     *
     * @param servletContextEvent
     */
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOG.info(queueHandlerThread);
        if (queueHandlerThread.isAlive() && queueHandler.isRunning()) {
            QueueManager.getQueue().setBlockingAdd(true);
            queueHandler.setRunning(false);
        }
        LOG.info("Поток обработки жив: " + queueHandlerThread.isAlive());
        try {
            LOG.info("Ожидаем завершения обработки очереди");
            queueHandlerThread.join();
            LOG.info("Дождался завершения обработки очереди");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOG.info("Поток обработки жив: " + queueHandlerThread.isAlive());
    }

}
