/**
 * Создано: Денис 
 * Дата: 07.01.15
 * Описание: 
 */
package hibernateService;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public abstract class GenerallyHibernateQuery<E> {
    public abstract List<E> run(Session session) throws HibernateException;
}
