package panel.log;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.BaseAction;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Класс предназначен для логирования пользователя
 */
public class LogOn extends BaseAction {

    private static final String  FORWARD = "successful";
    private static final String  name = "adminMan";
    private static final String  password = "citylife";

    @Override
    /**
     * Метод проверяет на наличие пользователя в базе данных. Если пользователь есть, то он получает доступ
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        FormLogon logonData = (FormLogon) form;
        HttpSession httpSession = request.getSession();
        if (logonData.getName().equals(name)  && logonData.getPassword().equals(password) ){
            String hash = KeyGen.generation();
            response.addCookie(new Cookie("l", hash));
            httpSession.setAttribute(hash, logonData.getName());
            return mapping.findForward(FORWARD);
        }
        logonData.setStatus("Ошибка");
        return mapping.findForward("error");
    }
}
