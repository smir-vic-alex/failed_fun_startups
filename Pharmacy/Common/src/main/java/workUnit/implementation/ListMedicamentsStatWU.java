/**
 * Создано: Денис 
 * Дата: 05.04.15
 * Описание: Класс для выводы статистики по лекарствам
 */
package workUnit.implementation;

import entities.MedicamentStat;
import helpers.GlobalConstants;
import hibernateService.GenerallyHibernateQuery;
import hibernateService.HibernateService;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import workUnit.ListWorkUnit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListMedicamentsStatWU implements ListWorkUnit<MedicamentStat>{

    private static HibernateService<MedicamentStat> service = new HibernateService<>(MedicamentStat.class);
    private static String START_DAY = "STARTDAY";
    private static String END_DAY = "ENDDAY";
    private List<MedicamentStat> listMedStat;
    private Map<Object, Object> param = new HashMap<>();

    @Override
    public void setFilter(Map<Object, Object> filterParam) {
        param.put(START_DAY, filterParam.get(GlobalConstants.START_DAY));
        param.put(END_DAY, filterParam.get(GlobalConstants.END_DAY));
    }

    @Override
    public void filter() {
        listMedStat = service.execute(new GenerallyHibernateQuery<MedicamentStat>() {
            @Override
            public List<MedicamentStat> run(Session session) throws HibernateException {
                Query queue = session.getNamedQuery("entities.StatisticMedicamentEntity.selectStatFromPeriod");
                queue.setProperties(param);
                List<Object[]> list =  (List<Object[]>)queue.list();
                List<MedicamentStat> outList = new ArrayList<>(list.size());
                for (Object[] arrObj:list){
                    MedicamentStat stat = new MedicamentStat();
                    stat.setName((String)arrObj[0]);
                    stat.setCountRequest((Integer)arrObj[1]);
                    outList.add(stat);
                }
                return outList;
            }
        });

    }

    @Override
    public List<MedicamentStat> getResult() {
        return listMedStat;
    }
}
