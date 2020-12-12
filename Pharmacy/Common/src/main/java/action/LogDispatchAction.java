/**
 * Создано: Денис
 * Дата: 09.11.14.
 */
package action;

import helpers.StringHelper;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class LogDispatchAction extends DispatchAction {

    private static final String DEFAULT_METHOD = "start";
    private static final String EMPTY = "";
    protected static final String SUCCESS = "success";
    protected static final String ERROR = "error";

    @Override
    protected String getParameter(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String parameter = mapping.getParameter();
        return StringHelper.isNotEmpty(parameter) ? parameter : EMPTY;
    }

    @Override
    protected String getMethodName(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, String parameter) throws Exception {
        String methodName = parameter;
        return StringHelper.isNotEmpty(methodName)? methodName : DEFAULT_METHOD;
    }

    /**
     * Метод по умолчанию
     */
    public abstract ActionForward start(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
