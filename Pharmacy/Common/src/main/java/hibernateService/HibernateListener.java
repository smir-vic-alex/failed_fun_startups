/**
 * Создано: Денис
 * Дата: 04.11.14.
 * Описание: Класс предназначен для запуска инициализации Hibernate во время запуска контейнера сервлетов
 */
package hibernateService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Locale;

public class HibernateListener implements ServletContextListener {

    private static final Logger LOG = LogManager.getLogger(HibernateListener.class);

    public void contextInitialized(ServletContextEvent servletContextEvent) {

        try {
            //Требуется для корректного подключения к БД (Проблема NLS(см. ORA-12705))
            Locale.setDefault(Locale.ENGLISH);
            LOG.info("Вызов инициализации Hibernate из Listener");
            HibernateUtil.buildSessionFactory();
        } catch (Exception e) {
            LOG.error("Ошибка инициализации Hibernate", e);
        }
    }


    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        HibernateUtil.closeSessionFactory();
    }
}
