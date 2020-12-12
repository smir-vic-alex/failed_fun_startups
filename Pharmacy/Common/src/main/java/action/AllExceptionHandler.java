/**
 * Создано: Денис 
 * Дата: 31.12.14
 * Описание: Класс-обработчик всех ошибок, произошедщих в Action'е
 */
package action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AllExceptionHandler extends ExceptionHandler {

    protected static final Logger LOG = LogManager.getLogger(AllExceptionHandler.class);

    @Override
    public ActionForward execute(Exception ex, ExceptionConfig ae, ActionMapping mapping, ActionForm formInstance, HttpServletRequest request, HttpServletResponse response) throws ServletException {
        ActionForward forward = super.execute(ex, ae, mapping, formInstance, request, response);
        LOG.error("Ошибка в Action",ex);
        forward.setRedirect(true);
        return forward;
    }
}
