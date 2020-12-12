/**
 * Создано: Денис 
 * Дата: 07.01.15
 * Описание: Класс для получение статистики из БД
 */
package workUnit;

import entities.Pharmacy;
import entities.StatisticPharmacyEntity;
import entities.StatisticViewEntity;
import entities.UserAccount;
import helpers.DateHelper;
import hibernateService.GenerallyHibernateQuery;
import hibernateService.HibernateService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Query;

import java.util.*;

public class StatisticViewWU {

    private List<Pharmacy> pharmacies;
    private List<StatisticViewEntity> statisticList;
    private HibernateService<Pharmacy> pharmacyService = new HibernateService<Pharmacy>(Pharmacy.class);
    private HibernateService<StatisticPharmacyEntity> statisticService = new HibernateService<StatisticPharmacyEntity>(StatisticPharmacyEntity.class);

    /**
     * Инициализация статистических данных по всем аптекам
     * @param account Аккаунт клиента
     */
    public void init(UserAccount account) {
        Map<Object, Object> parameterMap = new HashMap<>();
        //Получение всех аптек клиента
        parameterMap.put("codeNetwork", account.getCodeNetwork());
        pharmacies = pharmacyService.getList(parameterMap, "getByCodeNetwork");

        statisticList = new ArrayList<>(pharmacies.size());
        //Получение статиски за 1, 7, 30 дней для каждой аптеки.
        statisticService.execute(new GenerallyHibernateQuery() {
            @Override
            public List<StatisticViewEntity> run(Session session) throws HibernateException {
                Query queue = session.getNamedQuery("countVisitOverPeriod");

                Calendar fromDay = DateHelper.getCurrentDateInZeroTime();

                Calendar fromWeek = DateHelper.getCurrentDateInZeroTime();
                fromWeek.add(Calendar.DAY_OF_MONTH, -7);

                Calendar fromMonth = DateHelper.getCurrentDateInZeroTime();
                fromMonth.add(Calendar.DAY_OF_MONTH, -30);

                for (Pharmacy pharmacy : pharmacies) {
                    queue.setParameter("idPharmacy", pharmacy.getId());
                    //Получение статистики за день
                    queue.setParameter("fromDate", fromDay);
                    Integer day = (Integer) queue.list().get(0);
                    day = day != null ? day : 0;

                    //Получение статистики за 7 дней
                    queue.setParameter("fromDate", fromWeek);
                    Integer week = (Integer) queue.list().get(0);
                    week = week != null ? week : 0;

                    //Получение статистики за 30 дней
                    queue.setParameter("fromDate", fromMonth);
                    Integer month = (Integer) queue.list().get(0);
                    month = month != null ? month : 0;

                    statisticList.add(new StatisticViewEntity(pharmacy, day, week, month));
                }
                return null;
            }
        });
    }

    /**
     * Получение результата работы
     * @return Статистика по всем аптекам
     */
    public List<StatisticViewEntity> getResult(){
        return statisticList;
    }
}
