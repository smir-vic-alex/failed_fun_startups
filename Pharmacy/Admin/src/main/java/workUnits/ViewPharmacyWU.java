/**
 * Создано: Денис 
 * Дата: 08.01.15
 * Описание: 
 */
package workUnits;

import entities.Pharmacy;
import hibernateService.GenerallyHibernateQuery;
import hibernateService.HibernateService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import workUnit.ViewWorkUnit;

import java.util.List;

public class ViewPharmacyWU implements ViewWorkUnit<Pharmacy> {

    private Pharmacy pharmacy;
    private HibernateService<Pharmacy> service = new HibernateService<Pharmacy>(Pharmacy.class);
    @Override
    public void init(Integer id) {
        if (id != null && id > 0){
            pharmacy = service.getById(id);
            if  (pharmacy == null){
                throw new IllegalArgumentException("Недопустимый ID = " + id);
            }
        }else {
            throw new IllegalArgumentException("Недопустимый ID = " + id);
        }
    }

    @Override
    public Pharmacy getEntity() {
        return pharmacy;
    }
}
