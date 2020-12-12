package hibernateServise;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.SessionFactoryObserver;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.servlet.ServletException;
import java.util.Date;

/**
 * Created by Денис on 24.05.14.
 */
public class HibernatePlugin implements PlugIn {
    public static SessionFactory sessionFactory;
    private static Class clazz = HibernatePlugin.class;
    public static final String KEY_NAME = clazz.getName();
    public static long timer = 0;

    @Override
    public void init(ActionServlet servlet, ModuleConfig config) throws ServletException {
        Date dt = new Date();
        timer = dt.getTime();
        Configuration configuration = new Configuration().configure("hibernateServise/hibernate.cfg.xml");
        final ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        configuration.setSessionFactoryObserver(new SessionFactoryObserver() {
            @Override
            public void sessionFactoryCreated(SessionFactory factory) {
            }
            @Override
            public void sessionFactoryClosed(SessionFactory factory) {
                ((StandardServiceRegistryImpl)serviceRegistry).destroy();
            }
        });
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        servlet.getServletContext().setAttribute(KEY_NAME, sessionFactory);
    }

    @Override
    public void destroy() {
        try {
            sessionFactory.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
