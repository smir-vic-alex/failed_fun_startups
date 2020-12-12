/**
 * Создано: Денис 
 * Дата: 09.01.15
 * Описание: 
 */
package workUnits;

import entities.Pharmacy;
import hibernateService.HibernateService;
import workUnit.ListWorkUnit;

import java.util.List;
import java.util.Map;

public class ListPharmacyWU implements ListWorkUnit<Pharmacy> {

    private List<Pharmacy> list;
    private HibernateService<Pharmacy> service = new HibernateService<Pharmacy>(Pharmacy.class);

    @Override
    public void setFilter(Map<Object, Object> filterParam) {

    }

    @Override
    public void filter() {
        list = service.getAll();
    }

    @Override
    public List<Pharmacy> getResult() {
        return list;
    }
}
