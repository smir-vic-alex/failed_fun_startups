/**
 * Создано: Денис 
 * Дата: 09.01.15
 * Описание: 
 */
package actions;

import action.BaseAction;
import entities.Pharmacy;
import forms.ActionFormBase;
import forms.ViewPharmacyForm;
import workUnit.EditWorkUnit;
import workUnit.ListWorkUnit;
import workUnit.ViewWorkUnit;
import workUnits.EditPharmacyWU;
import workUnits.ListPharmacyWU;
import workUnits.ViewPharmacyWU;

public class PharmacyAction extends BaseAction {

    @Override
    protected ViewWorkUnit createViewWorkUnit(ActionFormBase form) {
        return new ViewPharmacyWU();
    }

    @Override
    protected void updateViewForm(ActionFormBase form, ViewWorkUnit view) {
        ViewPharmacyForm frm = (ViewPharmacyForm)form;
        frm.setPharmacy((Pharmacy)view.getEntity());
    }

    @Override
    protected EditWorkUnit createEditWorkUnit(ActionFormBase frm) {
        return new EditPharmacyWU();
    }

    @Override
    protected ListWorkUnit createListWorkUnit(ActionFormBase frm) {
        return new ListPharmacyWU();
    }

}
