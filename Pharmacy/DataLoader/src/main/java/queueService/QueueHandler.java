package queueService;
/**
 * Created by Виктор on 06.11.2014.
 */
import form.LoadedData;
import entities.DescriptionParser;
import handler.UpdateDataHandler;
import hibernateService.HibernateService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import parsers.Parser;
import parsers.ParserFactory;
import parsers.ParsingException;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Обработчик очереди
 */
public class QueueHandler implements Runnable {

    protected final Logger LOG = LogManager.getLogger(QueueHandler.class);
    private static final int SLEEP_TIME = 5000;
    private static final UpdateDataHandler updateData = new UpdateDataHandler();
    private boolean running;

    /**
     * проверка на дестрой
     *
     * @return
     */
    public boolean isRunning() {
        return running;
    }

    /**
     * @param running
     */
    public void setRunning(boolean running) {
        this.running = running;
    }

    /**
     * Извлечение, обработка и обновление в бд данных, пришедших из очереди
     *
     * @param queue
     */
    private void processData(Queue queue) {
        LoadedData loadedData = (LoadedData) queue.poll();
        try {
            DescriptionParser descriptionParser = new HibernateService<DescriptionParser>(DescriptionParser.class).getById(loadedData.getPharmacy().getId());
            if (descriptionParser == null) {
                throw new Exception("Не найден парсер для аптеки с id = " + loadedData.getPharmacy().getId());
            }
            Parser parser = ParserFactory.getParser(descriptionParser.getParser());
            try {
                updateData.updateData(parser.getRecords(loadedData.getPathToFile(), loadedData.getEncoding()), loadedData);
            } catch (ParsingException e) {
                LOG.error("Ошибка парсинга: ",e);
            }
        } catch (Exception e) {
            LOG.error("Ошибка при обработке очереди для аптеки с ID = "+ loadedData.getPharmacy().getId() +": ", e);
        }
    }

    /**
     * процес работы с очередью
     */
    public void process() {

        Queue<Object> queue = QueueManager.getQueue();
        LOG.info("Старт процесса обработки очереди");
        while (running) {
            if (!queue.isEmpty()) {
                processData(queue);
            } else {
                try {
                    Thread.sleep(SLEEP_TIME);
                } catch (InterruptedException e) {
                    LOG.warn("Прерван поток обработки очереди " + e.toString(), e);
                }
            }
        }
        if (!running && queue.isBlockingAdd()) {
            LOG.info("Ожидание заверешения обработки очереди...");
            while (!queue.isEmpty()) {
                processData(queue);
            }
        }
    }

    /**
     * старт процесса работы с очередью
     */
    public void run() {
        process();
    }
}
