/**
 * Создано: Денис 
 * Дата: 18.03.15
 * Описание: Модуль для получения прайса
 */
package workUnit;

import entities.Medicament;
import entities.Pharmacy;
import entities.Price;
import helpers.CityHelper;
import helpers.GlobalConstants;
import helpers.NumberHelper;
import hibernateService.HibernateService;

import java.util.*;

public class PriceWU implements ListWorkUnit<Price> {

    private static HibernateService<Price> service = new HibernateService<>(Price.class);
    private static HibernateService<Medicament> medicamentService = new HibernateService<>(Medicament.class);
    private static HibernateService<Pharmacy> pharmacyService = new HibernateService<>(Pharmacy.class);
    private List<Price> list;
    private Map<Object, Object> map = new HashMap<>();
    private Medicament medicament;

    public void setFilter(Map<Object, Object> filterParam) {
        map.put(GlobalConstants.ID_MEDICAMENT_FOR_QUERY, filterParam.get(GlobalConstants.ID_MEDICAMENT_FOR_QUERY));
        map.put(GlobalConstants.ID_USER_CITY, filterParam.get(GlobalConstants.ID_USER_CITY));
    }

    public void filter() {
        list = service.getList(map, "getPrice");
        list = getPriceWithFake(list);
        Integer idMedicament =(Integer) map.get(GlobalConstants.ID_MEDICAMENT_FOR_QUERY);
        medicament = medicamentService.getById(idMedicament);
    }

    public List<Price> getResult() {
        return list;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    /**
     * Получение прайса с "шумовыми" записями
     * @param price Прайст без шума
     * @return Прайс с "шумовыми" записями
     */
    private List<Price> getPriceWithFake(List<Price> price){
        List<Integer> ids = new ArrayList<>(price.size());
        for(Price item: price){
            ids.add(item.getPharmacy().getId());
        }
        if  (ids.isEmpty()){
            ids.add(0);
        }
        map.put("ids", ids);
        Integer idCity = (Integer)map.get(GlobalConstants.ID_USER_CITY);
        map.put("city", CityHelper.getCityById(idCity));
        List<Pharmacy> pharmacies = pharmacyService.getList(map, "getAllPharmacyOutList");
        for (Pharmacy pharmacy: pharmacies){
            price.add(getFakePrice(pharmacy));
        }
        return price;
    }

    /**
     * Создание "шумовой" записи в прайсе
     * @param pharmacy Аптека, для которой нужно создать шум
     * @return Прайс
     */
    private Price getFakePrice(Pharmacy pharmacy){
        Price fakePrice = new Price();
        int amount = pharmacy.getFakePrice() ? NumberHelper.AVAILABLE_TO_ORDER : NumberHelper.NOT_DATA;
        fakePrice.setAmount(amount);
        fakePrice.setCost(-10D);
        fakePrice.setDateUpdate(new GregorianCalendar());
        fakePrice.setPharmacy(pharmacy);
        return fakePrice;
    }
}
