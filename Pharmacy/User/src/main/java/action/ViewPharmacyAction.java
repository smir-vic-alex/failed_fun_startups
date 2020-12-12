/**
 * Created: Денис 
 * Date: 16.11.14.
 */
package action;

import forms.ActionFormBase;
import entities.Pharmacy;
import forms.ViewPharmacyForm;
import helpers.GlobalConstants;
import helpers.SessionAndRequestHelper;
import hibernateService.HibernateService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import statistic.PharmacyStatistic;
import statistic.StatisticUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewPharmacyAction extends LogDispatchAction {

    private static final String FORWARD_START = "start";

    public ActionForward start(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){

        ViewPharmacyForm frm = (ViewPharmacyForm)form;
        int id = getID(frm);
        if (id > 0){
            Pharmacy pharmacy = new HibernateService<Pharmacy>(Pharmacy.class).getById(id);
            if (pharmacy != null){
                StatisticUtil.getStatistic(PharmacyStatistic.class).increment(pharmacy.getId());
                frm.setPharmacy(pharmacy);
                return mapping.findForward(FORWARD_START);
            }
        }
        throw new IllegalArgumentException("Не найдено аптеки с id" + id);
    }

    private int getID(ViewPharmacyForm frm){
        if (frm.getId() != null && frm.getId() > 0){
            return frm.getId();
        }
        return -1;
    }

    public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){

        ActionFormBase frm = (ActionFormBase)form;
        Map<Object, Object> map = new HashMap<>();
        map.put(GlobalConstants.USER_CITY, SessionAndRequestHelper.getCity(request));
        List<Pharmacy> list = new HibernateService<Pharmacy>(Pharmacy.class).getList(map, "getAllPharmacyOfCity");
        frm.setData(list);
        return mapping.findForward(FORWARD_START);
    }
}
