package records;

import hibernateServise.*;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Класс предназначен для возвращения маршрутов из БД
 */
public class DispatchRecords extends DispatchAction {
    public static final String FORWARD_LIST_RECORDS = "listRecords";
    public static final String FORWARD_EMPTY_RECORD = "emptyRecord";
    public static final String FORWARD_SAVE_RECORD = "successful";
    public static final String FORWARD_ERROR = "error";
    private static final String TABLE = "ways";

    @Override
    protected String getMethodName(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, String parameter) throws Exception {
        return parameter;
    }

    /**
     * Метод удаляет запись из БД
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HibernateUtil.init(servlet);
        RecordsForm routesForm = (RecordsForm) form;
        User user = new User();
        user.setId(routesForm.getId());
        Session session = null;
        Transaction transaction = null;
        try {
            session = ((SessionFactory) servlet.getServletContext().getAttribute(HibernatePlugin.KEY_NAME)).getCurrentSession();
            transaction = session.beginTransaction();
            session.delete(TABLE, user);
            routesForm.setUsers(session.createCriteria(TABLE).list());
            transaction.commit();
        } catch (HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw he;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return mapping.findForward(FORWARD_LIST_RECORDS);
    }
    private SessionFactory _sessions;
    /**
     * Метод возвращает все записи
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward allRecords(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HibernateUtil.init(servlet);
        RecordsForm routesForm = (RecordsForm) form;
        Transaction transaction = null;
        Session session = null;
        try {

            session = ((SessionFactory) servlet.getServletContext().getAttribute(HibernatePlugin.KEY_NAME)).getCurrentSession();
            transaction = session.beginTransaction();
            routesForm.setUsers(session.createCriteria(TABLE).list());
            transaction.commit();
        } catch (HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw he;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return mapping.findForward(FORWARD_LIST_RECORDS);
    }

    /**
     * Метод сохраняет данные о маршруте
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward saveRecords(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HibernateUtil.init(servlet);
        User user = (User) form;
        user.setIntermediatepoints("");
        if (user != null) {
            Transaction transaction = null;
            Session session = null;
            try {
                session = ((SessionFactory) servlet.getServletContext().getAttribute(HibernatePlugin.KEY_NAME)).getCurrentSession();

                transaction = session.beginTransaction();
                session.save(TABLE, user);
                transaction.commit();
            } catch (HibernateException he) {
                if (transaction != null) {
                    transaction.rollback();
                }
                throw he;
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return mapping.findForward(FORWARD_SAVE_RECORD);
        } else {
            return mapping.findForward(FORWARD_ERROR);

        }
    }

    /**
     * Метод получает все маршруты, соответствующие критериям из form
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward getSpecificRecords(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HibernateUtil.init(servlet);
        RecordsForm routesForm = (RecordsForm) form;
        User user = new User();
        user.setStartpoint(routesForm.getStartpoint());
        user.setFinishpoint(routesForm.getFinishpoint());
        user.setDay(routesForm.getDay());
        user.setMonth(routesForm.getMonth());
        user.setAgree(routesForm.getAgree());
        user.setWho(routesForm.getWho());
        if (user != null) {
            Transaction transaction = null;
            Session session = null;
            try {
                session = ((SessionFactory) servlet.getServletContext().getAttribute(HibernatePlugin.KEY_NAME)).getCurrentSession();

                transaction = session.beginTransaction();
                Criteria criteria = session.createCriteria(TABLE);
                if (!user.getStartpoint().equals("")) {
                    criteria.add(Restrictions.eq("startpoint", user.getStartpoint()));
                }
                if (!user.getFinishpoint().equals("")) {
                    criteria.add(Restrictions.like("finishpoint", user.getFinishpoint()));
                }
                Integer day = user.getDay();
                if (day != null && day.compareTo(new Integer(0)) != 0) {
                    criteria.add(Restrictions.like("day", user.getDay()));
                }
                Integer month = user.getMonth();
                if (month != null && month.compareTo(new Integer(0)) != 0) {
                    criteria.add(Restrictions.like("month", user.getMonth()));
                }
                Integer who = user.getWho();
                if (who != null) {
                    criteria.add(Restrictions.eq("who", user.getWho()));
                }
                routesForm.setUsers(criteria.list());
                transaction.commit();
            } catch (HibernateException he) {
                if (transaction != null) {
                    transaction.rollback();
                }
                throw he;
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            if (routesForm.getUsers().size() == 0) {
                return mapping.findForward(FORWARD_EMPTY_RECORD);
            }
            return mapping.findForward(FORWARD_LIST_RECORDS);
        } else {
            return mapping.findForward(FORWARD_ERROR);
        }

    }
}
