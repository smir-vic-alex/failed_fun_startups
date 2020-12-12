/**
 * Создано: Денис 
 * Дата: 11.01.15
 * Описание: 
 */
package workUnits;

import entities.Pharmacy;
import entities.StatisticPharmacyEntity;
import entities.StatisticViewEntity;
import helpers.DateHelper;
import hibernateService.GenerallyHibernateQuery;
import hibernateService.HibernateService;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import workUnit.ListWorkUnit;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class ListStatisticPharmacy implements ListWorkUnit {
    private HibernateService<Pharmacy> pharmacyService = new HibernateService<Pharmacy>(Pharmacy.class);
    private HibernateService<StatisticPharmacyEntity> statisticService = new HibernateService<StatisticPharmacyEntity>(StatisticPharmacyEntity.class);
    private List<StatisticViewEntity> statisticList;

    @Override
    public void setFilter(Map filterParam) {

    }

    @Override
    public void filter() {
        List<Pharmacy> pharmacies = pharmacyService.getAll();
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

    @Override
    public List getResult() {
        return statisticList;
    }
}
