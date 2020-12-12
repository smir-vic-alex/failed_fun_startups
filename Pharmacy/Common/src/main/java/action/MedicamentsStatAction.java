/**
 * Создано: Денис 
 * Дата: 05.04.15
 * Описание: 
 */
package action;

import forms.ActionFormBase;
import workUnit.ListWorkUnit;
import workUnit.ViewWorkUnit;
import workUnit.implementation.ListMedicamentsStatWU;

public class MedicamentsStatAction extends BaseAction {
    @Override
    protected ViewWorkUnit createViewWorkUnit(ActionFormBase form) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void updateViewForm(ActionFormBase form, ViewWorkUnit view) {

    }

    @Override
    protected ListWorkUnit createListWorkUnit(ActionFormBase frm) {
        return new ListMedicamentsStatWU();
    }
}
