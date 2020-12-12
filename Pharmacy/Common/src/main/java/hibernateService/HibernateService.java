/**
 * Создано: Денис
 * Дата: 05.11.14.
 * Описание: Класс-сервис для работы с БД
 */
package hibernateService;

import org.hibernate.*;

import java.util.List;
import java.util.Map;

/**
 * Сервис по работе с БД
 * @param <E> класс сущности с которой планируется работать
 */
public class HibernateService<E> {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private Class clazz;

    private HibernateService() {
    }

    /**
     * Конструктор предназначен для инициализации HibernateService под конкретный класс
     *
     * @param clazz класс, относительно которого нужно выполнить запрос
     */
    public HibernateService(Class clazz) {
        this.clazz = clazz;
    }

    /**
     * Получение сущности по ID
     *
     * @param id ID
     * @return Сущность, с указанным ID
     * @throws HibernateException
     */
    public E getById(int id) throws HibernateException {
        Session session = null;
        Transaction transaction = null;
        E obj = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            obj = (E) session.get(clazz, id);
            session.flush();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return obj;
    }

    /**
     * Сохраняет или обновляет сущность
     *
     * @param obj Сущность для обнавления/сохранения
     * @throws HibernateException
     */
    public void saveOrUpdate(E obj) throws HibernateException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(obj);
            session.flush();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Удаление сущности из БД
     * @param obj Удаляемая сущность
     * @throws HibernateException
     */
    public void delete(E obj) throws HibernateException{
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(obj);
            session.flush();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Возращает список сущностей, соответствующих указанным критериям
     * @param criteria  критерии, по которым будет производиться поиск
     * @param nameQuery имя запроса
     * @return список сущностей, соответствующих критериям
     * @throws HibernateException
     */
    public List<E> getList(Map<Object, Object> criteria, String nameQuery) throws HibernateException {
        Session session = null;
        List<E> list = null;
        try {
            session = sessionFactory.openSession();
            Query query = session.getNamedQuery(clazz.getName() + "." + nameQuery);
            query.setProperties(criteria);
            list = query.list();
        } catch (HibernateException e) {
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;
    }

    /**
     * Обновление записей в БД
     * @param criteria Критерии запроса
     * @param nameQuery Имя запроса
     * @return Количество обновлённых записей
     * @throws HibernateException
     */
    public int update(Map<Object, Object> criteria, String nameQuery) throws HibernateException{
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query query = session.getNamedQuery(clazz.getName() + "." + nameQuery);
            query.setProperties(criteria);
            return query.executeUpdate();
        } catch (HibernateException e) {
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Выполнение произвольного запроса.
     * @param query Класс, реализующий класс GenerallyHibernateQuery
     */
    public List<E> execute(GenerallyHibernateQuery query){
        Session session = null;
        Transaction transaction = null;
        List<E> list = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            list = query.run(session);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;
    }

    /**
     * Получение всех записей из таблицы
     * @return Список всех сущностей в таблице
     */
    public List<E> getAll(){
        Session session = null;
        List<E> list = null;
        try {
            session = sessionFactory.openSession();
            list = session.createCriteria(clazz).list();
        } catch (HibernateException e) {
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;
    }
}