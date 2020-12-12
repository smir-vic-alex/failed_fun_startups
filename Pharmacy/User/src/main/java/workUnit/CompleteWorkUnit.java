package workUnit;

import entities.Medicament;
import hibernateService.GenerallyHibernateQuery;
import hibernateService.HibernateService;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Создано: Денис 
 * Дата: 08.02.15
 * Описание: Модуль для получения списка для автозаполнения
 */

public class CompleteWorkUnit {
    public static final int MAX_RESULTS = 10;
    private static HibernateService<Medicament> service = new HibernateService<Medicament>(Medicament.class);
    public List<Medicament> list;

    /**
     * Инициализация модуля
     * @param val Искомая подстрока
     */
    public void init(String val){
        Map<Object, Object> map = new HashMap<>();
        map.put("name", val+"%");
        list = service.execute(new GenerallyHibernateQuery(){
            @Override
            public List run(Session session) throws HibernateException {
                Query query = session.getNamedQuery(Medicament.class.getName() + ".getByNameLike");
                query.setProperties(map);
                query.setMaxResults(MAX_RESULTS);
                return query.list();
            }
        });
    }

    /**
     * Получение списка схожих лекарств
     * @return Список лекарств
     */
    public List<Medicament> getList() {
        return list;
    }
}
