/**
 * Создано: Денис 
 * Дата: 11.01.15
 * Описание: 
 */
package actions;

import action.BaseAction;
import forms.ActionFormBase;
import workUnit.ListWorkUnit;
import workUnit.ViewWorkUnit;
import workUnits.ListStatisticPharmacy;

public class StatisticPharmacyAction extends BaseAction {

    @Override
    protected ViewWorkUnit createViewWorkUnit(ActionFormBase form) {
        return null;
    }

    @Override
    protected void updateViewForm(ActionFormBase form, ViewWorkUnit view) {

    }

    @Override
    protected ListWorkUnit createListWorkUnit(ActionFormBase frm) {
        return new ListStatisticPharmacy();
    }
}
