/**
 * Создано: Денис 
 * Дата: 09.01.15
 * Описание: 
 */
package actions;

import action.BaseAction;
import checkForm.Form;
import entities.UserAccount;
import forms.ActionFormBase;
import forms.ViewClientForm;
import workUnit.EditWorkUnit;
import workUnit.ListWorkUnit;
import workUnit.ViewWorkUnit;
import workUnits.EditClientWU;
import workUnits.ListClientWU;
import workUnits.ViewClientWU;

public class ClientAction extends BaseAction {

    @Override
    protected ViewWorkUnit createViewWorkUnit(ActionFormBase form) {
        return new ViewClientWU();
    }

    @Override
    protected void updateViewForm(ActionFormBase form, ViewWorkUnit view) {
        UserAccount user = (UserAccount)view.getEntity();
        ViewClientForm frm = (ViewClientForm)form;
        frm.setClient(user);
    }

    @Override
    protected ListWorkUnit createListWorkUnit(ActionFormBase frm) {
        return new ListClientWU();
    }

    @Override
    protected EditWorkUnit createEditWorkUnit(ActionFormBase frm) {
        return new EditClientWU();
    }
}
