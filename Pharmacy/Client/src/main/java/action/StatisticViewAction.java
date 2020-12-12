/**
 * Создано: Денис 
 * Дата: 07.01.15
 * Описание: Класс для получение статистики
 */
package action;

import forms.ActionFormBase;
import helpers.SessionAndRequestHelper;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import workUnit.StatisticViewWU;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StatisticViewAction extends LogDispatchAction {

    /**
     * Получение краткой статиски по всем аптекам
     */
    public ActionForward start(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionFormBase frm = (ActionFormBase)form;
        StatisticViewWU workUnit = new StatisticViewWU();
        workUnit.init(SessionAndRequestHelper.getUserAccount(request));
        frm.setData(workUnit.getResult());
        return mapping.findForward(SUCCESS);
    }
}
