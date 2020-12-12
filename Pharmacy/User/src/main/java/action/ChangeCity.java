/**
 * Создано: Денис 
 * Дата: 28.03.15
 * Описание: Класс предназначен для смены города пользователя
 */
package action;

import entities.City;
import forms.ChangeCityForm;
import helpers.CityHelper;
import helpers.SessionAndRequestHelper;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeCity extends LogDispatchAction {

    @Override
    public ActionForward start(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        ChangeCityForm frm = (ChangeCityForm)form;
        Integer id = frm.getId();
        if (id != null && id > 0){
            City city = CityHelper.getCityById(id);
            if (city != null){
                SessionAndRequestHelper.setCity(request, city);
                frm.setStatus(true);
            }
        }
        return mapping.findForward(SUCCESS);
    }
}
