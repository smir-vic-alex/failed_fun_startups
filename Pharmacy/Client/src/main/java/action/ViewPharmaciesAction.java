/**
 * Создано: Денис 
 * Дата: 05.01.15
 * Описание: Класс для просмотра информации об атеках клиента
 */
package action;

import entities.Pharmacy;
import entities.UserAccount;
import forms.ActionFormBase;
import forms.ViewPharmacyClientForm;
import helpers.SessionAndRequestHelper;
import hibernateService.HibernateService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewPharmaciesAction extends LogDispatchAction {

    /**
     * Получение списка всех аптек клиента
     */
    public ActionForward start(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionFormBase frm = (ActionFormBase)form;
        UserAccount account = SessionAndRequestHelper.getUserAccount(request);
        Map<Object, Object> parameterMap = new HashMap<>();
        parameterMap.put("codeNetwork", account.getCodeNetwork());
        List<Pharmacy> list = new HibernateService<Pharmacy>(Pharmacy.class).getList(parameterMap, "getByCodeNetwork");
        frm.setData(list);
        return mapping.findForward(SUCCESS);
    }

    public ActionForward viewPharmacy(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ViewPharmacyClientForm frm = (ViewPharmacyClientForm)form;
        UserAccount account = SessionAndRequestHelper.getUserAccount(request);
        int id = getID(frm);
        if (id > 0){
            Pharmacy pharmacy = new HibernateService<Pharmacy>(Pharmacy.class).getById(id);
            if (pharmacy.getCodeNetwork().equals(account.getCodeNetwork())){
                frm.setPharmacy(pharmacy);
                return mapping.findForward(SUCCESS);
            }
            return mapping.findForward(ERROR);
        }
        throw new Exception("Неверно задан id");

    }

    private int getID(ActionFormBase frm){
        if (frm.getId() != null && frm.getId() > 0){
            return frm.getId();
        }
        return -1;
    }
}
