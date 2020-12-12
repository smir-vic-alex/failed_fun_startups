package action;

import forms.AutoCompleteForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import workUnit.CompleteWorkUnit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by Виктор on 07.02.2015.
 */
public class CompleteAction extends LogDispatchAction {

    public ActionForward start(ActionMapping mapping, ActionForm form, HttpServletRequest request,HttpServletResponse response){
        AutoCompleteForm frm = (AutoCompleteForm) form;
        String search = frm.getSearchString();
        if (search != null && search.length() >= 3){
            CompleteWorkUnit workUnit = new CompleteWorkUnit();
            workUnit.init(search);
            frm.setData(workUnit.getList());
        }
        return mapping.findForward(SUCCESS);
    }

}
