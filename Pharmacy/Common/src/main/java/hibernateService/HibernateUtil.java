/**
 * Создано: Денис
 * Дата: 04.11.14.
 * Описание: Класс для инициализации Hibernate
 */
package hibernateService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.File;

public class HibernateUtil {

    private static final Logger LOG = LogManager.getLogger(HibernateUtil.class);
    private static SessionFactory sessionFactory;

    public static void buildSessionFactory() throws Exception{
        LOG.info("Начало инициализация Hibernate.");
        try{
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            if (sessionFactory == null){
                throw new HibernateException("Не удалось проинициализировать sessionFactory.");
            }
        }catch (HibernateException e){
            LOG.error("Не удалось проинициализировать Hibernate.", e);
            throw new Exception(e);
        }
        LOG.info("Инициализация Hibernate успешно завершена.");
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static void closeSessionFactory(){
        if (sessionFactory != null){
            sessionFactory.close();
        }
    }
}
