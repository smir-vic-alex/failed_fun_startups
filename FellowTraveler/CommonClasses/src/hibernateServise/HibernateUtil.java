package hibernateServise;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.config.ModuleConfig;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SessionFactoryObserver;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.servlet.ServletException;
import java.util.Date;


public class HibernateUtil {


    public static void init(ActionServlet servlet) throws ServletException {
        Date curDate = new Date();
        long curTime = curDate.getTime();
        long tenminutes = 10 * 60 * 1000;
        if (curTime - HibernatePlugin.timer > tenminutes) {
            destroy(servlet);
        } else {
            curDate = new Date();
            HibernatePlugin.timer = curDate.getTime();
        }
        if (((SessionFactory) servlet.getServletContext().getAttribute(HibernatePlugin.KEY_NAME)).isClosed()) {
            Configuration configuration = new Configuration().configure("hibernateServise/hibernate.cfg.xml");
            final ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            configuration.setSessionFactoryObserver(new SessionFactoryObserver() {
                @Override
                public void sessionFactoryCreated(SessionFactory factory) {
                }

                @Override
                public void sessionFactoryClosed(SessionFactory factory) {
                    ((StandardServiceRegistryImpl) serviceRegistry).destroy();
                }
            });
            HibernatePlugin.sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            servlet.getServletContext().setAttribute(HibernatePlugin.KEY_NAME, HibernatePlugin.sessionFactory);
        }
    }


    public static void destroy(ActionServlet servlet) {
        try {
            ((SessionFactory) servlet.getServletContext().getAttribute(HibernatePlugin.KEY_NAME)).close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}