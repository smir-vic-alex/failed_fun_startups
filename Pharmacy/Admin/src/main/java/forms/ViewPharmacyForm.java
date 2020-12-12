/**
 * Создано: Денис 
 * Дата: 05.01.15
 * Описание: 
 */
package forms;

import entities.Pharmacy;

public class ViewPharmacyForm extends ActionFormBase {

    private Pharmacy pharmacy;

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
}
