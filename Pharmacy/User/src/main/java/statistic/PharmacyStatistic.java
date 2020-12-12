/**
 * Создано: Денис 
 * Дата: 07.01.15
 * Описание: Класс для обработки статистики по аптекам
 */
package statistic;


import entities.StatisticPharmacyEntity;
import helpers.DateHelper;
import hibernateService.HibernateService;

import java.util.*;

public class PharmacyStatistic extends BaseStatistic {

    private static final String NAME_STATISTIC = "Аптечная статистика";

    public PharmacyStatistic() {
        super(NAME_STATISTIC);
    }

    public PharmacyStatistic(int timeIntervalInHour) {
        super(timeIntervalInHour, NAME_STATISTIC);

    }

    public synchronized void flush() {
            LOG.info("Началось обновление статистики по аптекам");
            Set<Integer> setKey = map.keySet();
            HibernateService<StatisticPharmacyEntity> service = new HibernateService<StatisticPharmacyEntity>(StatisticPharmacyEntity.class);
            Map<Object, Object> parameters = new HashMap<>();
            Calendar currentDate = DateHelper.getCurrentDateInZeroTime();
            for (Integer key : setKey) {
                LightInteger count = map.get(key);
                parameters.put("countVisit", count.getValue());
                parameters.put("idPharmacy", key);
                parameters.put("currentDay", currentDate);
                int countUpdateEntity = service.update(parameters, "updateCount");
                if (countUpdateEntity == 0) {
                    StatisticPharmacyEntity entity = new StatisticPharmacyEntity();
                    entity.setIdPharmacy(key);
                    entity.setCountVisit(count.getValue());
                    entity.setDay(currentDate);
                    service.saveOrUpdate(entity);
                }
            }
            lastUpdateTime = new GregorianCalendar();
            map = new HashMap<>();
            LOG.info("Обновление статистики по аптекам завершено");
    }
}
