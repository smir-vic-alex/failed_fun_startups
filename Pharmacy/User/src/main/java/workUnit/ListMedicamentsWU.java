/**
 * Создано: Денис 
 * Дата: 18.03.15
 * Описание: Модуль для получения списка лекарств
 */
package workUnit;

import entities.Medicament;
import entities.Pair;
import entities.Price;
import helpers.GlobalConstants;
import hibernateService.GenerallyHibernateQuery;
import hibernateService.HibernateService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListMedicamentsWU implements ListWorkUnit<Pair<Medicament, Long>> {

    public static final String TARGET_MEDICAMENT_ID = "medId";
    private static final String MEDICAMENT_NAME = "name";
    private static HibernateService<Medicament> medicamentService = new HibernateService<>(Medicament.class);
    private static HibernateService<Price> priceService = new HibernateService<>(Price.class);

    private List<Pair<Medicament, Long>> listMedicaments;
    private Pair<Medicament, Long> targetMedicament;
    private Map<Object, Object> map;
    private Integer idCity;

    public void setFilter(Map<Object, Object> filterParam) {
        map = filterParam;
        String name =(String) filterParam.get("searchInput");
        map.put(MEDICAMENT_NAME,name+"%");
        idCity = (Integer)map.get(GlobalConstants.ID_USER_CITY);
    }

    public void filter() {
        // Если пользователь знает что ищет.
        if (map.containsKey(TARGET_MEDICAMENT_ID)){
            Integer id = (Integer) map.get(TARGET_MEDICAMENT_ID);
            Medicament medicament = medicamentService.getById(id);
            if (medicament != null){
                targetMedicament = new Pair<>(medicament,getCountOffer(medicament));
                //Покажем ка пользователю похожие запросы
                String name = medicament.getName().split(" ")[0];
                map.put(MEDICAMENT_NAME, name+"%");
            }
        }
        List<Medicament> list = medicamentService.getList(map, "getByNameLike");
        listMedicaments = new ArrayList<>(list.size());
        //Получаем количество предложений по лекарствам
        for(Medicament medicament: list){
            listMedicaments.add(new Pair<>(medicament, getCountOffer(medicament)));
        }
    }

    public List<Pair<Medicament, Long>> getResult() {
        return listMedicaments;
    }

    /**
     * Получение количества предложений по лекарству
     * @param medicament Лекарство
     * @return Количество предложений
     */
    private Long getCountOffer(Medicament medicament){
        List list = priceService.execute(new GenerallyHibernateQuery() {
            @Override
            public List run(Session session) throws HibernateException {
                return session.createCriteria(Price.class).setProjection(Projections.count("id")).
                        add(Restrictions.eq("idMedicament", medicament.getId())).
                        add(Restrictions.eq("idCity", idCity)).list();
            }
        });
        return (Long)list.get(0);
    }

    /**
     * Получение конкретного лекарства, которое искал пользователь
     * @return Лекарство с количеством предложений по нему
     */
    public Pair<Medicament, Long> getTargetMedicament() {
        return targetMedicament;
    }
}
