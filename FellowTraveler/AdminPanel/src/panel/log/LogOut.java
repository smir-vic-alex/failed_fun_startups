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
 * Класс предназначен для выхода пользователя из системы
 */
public class LogOut extends BaseAction {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session =  request.getSession();
        Cookie cookies[] = request.getCookies();
        int i = 0;
        while (i < cookies.length && !cookies[i].getName().equals("l") ){
            i++;
        }
        if (i < cookies.length){
            String hash = cookies[i].getValue();
            session.removeAttribute(hash);

        }
        return mapping.findForward("successful");

    }
}
