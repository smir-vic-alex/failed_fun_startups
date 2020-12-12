/**
 * Создано: Денис 
 * Дата: 04.01.15
 * Описание: Класс проверяет зарегистрирован ли пользователь или нет.
 */
package login;

import action.LogDispatchAction;
import entities.UserAccount;
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
     * Вход пользователя в систему
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
            HibernateService<UserAccount> service = new HibernateService<UserAccount>(UserAccount.class);
            List<UserAccount> list = service.getList(queryMap, "getByLoginAndPassword");
            if (!list.isEmpty()) {
                log.info("Пользователь " + login + " зашёл в систему");
                request.getSession().setAttribute(GlobalConstants.IS_LOGIN_USER, Boolean.TRUE);
                request.getSession().setAttribute(GlobalConstants.CLIENT, list.get(0));
                return mapping.findForward(SUCCESS);
            }
        }
        frm.setCorrectLoginAndPassword(false);
        return mapping.findForward(ERROR);
    }

    /**
     * Выход пользователя из системы.
     */
    public ActionForward exit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        UserAccount user = (UserAccount)session.getAttribute(GlobalConstants.CLIENT);
        session.removeAttribute(GlobalConstants.IS_LOGIN_USER);
        session.removeAttribute(GlobalConstants.CLIENT);
        log.info("Пользователь " + user.getLogin() + " вышел из системы");
        return mapping.findForward(SUCCESS);
    }

}
