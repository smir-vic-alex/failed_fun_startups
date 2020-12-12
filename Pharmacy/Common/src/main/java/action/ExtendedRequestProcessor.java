/**
 * Создано: Денис 
 * Дата: 03.01.15
 * Описание: Класс предназначен для навешивания дополнительных действий на RequestProcessor
 */
package action;

import helpers.GlobalConstants;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.RequestProcessor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExtendedRequestProcessor extends RequestProcessor {

    /**
     * Устанавление атрибута CURRENT_ACTION_FORM со значением form в request
     * @return
     */
    @Override
    protected ActionForm processActionForm(HttpServletRequest request, HttpServletResponse response, ActionMapping mapping) {
        ActionForm form = super.processActionForm(request, response, mapping);
        request.setAttribute(GlobalConstants.CURRENT_ACTION_FORM, form);
        log.debug( "ActionForm установлена в'" + mapping.getScope() + "' под ключом '" + GlobalConstants.CURRENT_ACTION_FORM + "'");
        return form;
    }
}
