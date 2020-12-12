package action;

/**
 * Created by Виктор on 23.01.2015.
 */

import entities.Pharmacy;
import forms.LoginForm;
import helpers.GlobalConstants;
import helpers.PasswordHelper;
import helpers.StringHelper;
import hibernateService.HibernateService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginAction extends LogDispatchAction {

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";

    /**
     * Вход аптеки в систему
     */
    public ActionForward start(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LoginForm frm = (LoginForm) form;
        Map<Object, Object> map = frm.getFields();
        String login = (String) map.get(LOGIN);
        String password = (String) map.get(PASSWORD);
        if (StringHelper.isNotEmpty(login) && StringHelper.isNotEmpty(password)) {
            Map<Object, Object> queryMap = new HashMap<>();
            queryMap.put(LOGIN, login);
            queryMap.put(PASSWORD, PasswordHelper.encrypt(password));
            HibernateService<Pharmacy> service = new HibernateService<Pharmacy>(Pharmacy.class);
            List<Pharmacy> list = service.getList(queryMap, "getByLoginAndPassword");
            if (!list.isEmpty()) {
                log.info("Аптека " + login + " авторизована в системе");
                request.getSession().setAttribute(GlobalConstants.IS_LOGIN_USER, Boolean.TRUE);
                request.getSession().setAttribute(GlobalConstants.PHARMACY, list.get(0));
                return mapping.findForward(SUCCESS);
            }
        }
        frm.setCorrectLoginAndPassword(false);
        return mapping.findForward(ERROR);
    }

    /**
     * Выход аптеки из системы.
     */
    public ActionForward exit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        Pharmacy pharmacy = (Pharmacy)session.getAttribute(GlobalConstants.PHARMACY);
        session.removeAttribute(GlobalConstants.IS_LOGIN_USER);
        session.removeAttribute(GlobalConstants.PHARMACY);
        log.info("Пользователь " + pharmacy.getLogin() + " вышел из системы");
        return mapping.findForward(SUCCESS);
    }

}

