package handler;
/**
 * Created by Виктор on 09.11.2014.
 */

import form.LoadedData;
import form.UpdateRecord;
import entities.Medicament;
import entities.Pharmacy;
import entities.Price;
import hibernateService.HibernateService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * Обновление данных о стоимости и количестве лекартсва
 */
public class UpdateDataHandler {

    private static final HibernateService<Price> servicePrice = new HibernateService<Price>(Price.class);
    private static final HibernateService<Medicament> serviceMedicament = new HibernateService<Medicament>(Medicament.class);
    private static final Logger LOG = LogManager.getLogger(UpdateDataHandler.class);

    /**
     * Обновление прайса аптеки
     *
     * @param list       Лист распарсенных данных
     * @param loadedData Данные по загрузке
     */
    public void updateData(List<UpdateRecord> list, LoadedData loadedData) {

        Medicament medicament = null;
        for (UpdateRecord updateRecord : list) {
            medicament = getMedicamentByName(updateRecord.getName());
            if (medicament != null) {
                Map<Object, Object> hashMap = new HashMap<>();
                hashMap.put("cost", updateRecord.getCost());
                hashMap.put("amount", updateRecord.getAmount());
                hashMap.put("pharmacy", loadedData.getPharmacy());
                hashMap.put("idMedicament", medicament.getId());
                hashMap.put("idCity", loadedData.getPharmacy().getCity().getId());
                hashMap.put("dateUpdate", new GregorianCalendar());

                int amountUpdateRecords = servicePrice.update(hashMap, "updatePrice");
                if (amountUpdateRecords == 0) {
                    servicePrice.saveOrUpdate(getPrice(hashMap));
                }
            }
        }

    }

    private Price getPrice(Map<Object, Object> map) {
        Price price = new Price();
        price.setAmount((Integer) map.get("amount"));
        price.setCost((Double) map.get("cost"));
        price.setPharmacy((Pharmacy) map.get("pharmacy"));
        price.setDateUpdate((GregorianCalendar) map.get("dateUpdate"));
        price.setIdCity((Integer) map.get("idCity"));
        price.setIdMedicament((Integer) map.get("idMedicament"));
        return price;
    }

    private Medicament getMedicamentByName(String name) {
        Map<Object, Object> map = new HashMap<>();
        map.put("name", name);
        List<Medicament> medicaments = serviceMedicament.getList(map, "getByName");
        Medicament medicament = null;
        if (medicaments.isEmpty()) {
            //TODO: Сделать отображение нового медикамента в админке
//            medicament = new Medicament();
//            medicament.setName(name.toUpperCase());
            LOG.info("Новый медикамент: " + name.toUpperCase());
//            serviceMedicament.saveOrUpdate(medicament);
        } else {
            medicament = medicaments.get(0);
        }
        return medicament;
    }
}

