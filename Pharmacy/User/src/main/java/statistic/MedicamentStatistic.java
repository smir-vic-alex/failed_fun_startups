/**
 * Создано: Денис 
 * Дата: 07.01.15
 * Описание: 
 */
package statistic;

import entities.StatisticMedicamentEntity;
import helpers.DateHelper;
import hibernateService.HibernateService;

import java.util.*;

public class MedicamentStatistic extends BaseStatistic {

    private static final String NAME_STATISTIC = "Лекарственная статистика";

    public MedicamentStatistic() {
        super(NAME_STATISTIC);
    }

    public MedicamentStatistic(int timeIntervalInHour) {
        super(timeIntervalInHour, NAME_STATISTIC);
    }

    public void flush() {
        LOG.info("Началось обновление статистики по лекарствам");
        Set<Integer> setKey = map.keySet();
        HibernateService<StatisticMedicamentEntity> service = new HibernateService<>(StatisticMedicamentEntity.class);
        Map<Object, Object> parameters = new HashMap<>();
        Calendar currentDate = DateHelper.getCurrentDateInZeroTime();
        for (Integer key : setKey) {
            LightInteger count = map.get(key);
            parameters.put("countRequest", count.getValue());
            parameters.put("idMedicam", key);
            parameters.put("currentDay", currentDate);
            int countUpdateEntity = service.update(parameters, "updateCount");
            if (countUpdateEntity == 0) {
                StatisticMedicamentEntity entity = new StatisticMedicamentEntity();
                entity.setMedicamentId(key);
                entity.setCountRequest(count.getValue());
                entity.setDay(currentDate);
                service.saveOrUpdate(entity);
            }
        }
        lastUpdateTime = new GregorianCalendar();
        map = new HashMap<>();
        LOG.info("Обновление статистики по лекарствам завершено");
    }
}
