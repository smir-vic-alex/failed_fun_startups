package panel.settings;

import hibernateServise.HibernateUtil;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.BaseAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Класс остановки Hibernate
 */
public class StopHibernate extends BaseAction {
    private static final String FORWARD_SUCCESS = "successful";

    /**
     * Метод закрывает ссесию Hibernate
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        MessageForm messageForm = (MessageForm) form;
        try {
            HibernateUtil.close();
            messageForm.setMessage("Hibernate остановлен");
        }catch (Exception e){
            messageForm.setMessage(e.getMessage());
        }
        return mapping.findForward(FORWARD_SUCCESS);
    }
}
