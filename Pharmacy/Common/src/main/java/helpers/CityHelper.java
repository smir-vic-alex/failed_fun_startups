/**
 * Создано: Денис 
 * Дата: 08.01.15
 * Описание: Класс-помошник для работы с сущностью город
 */
package helpers;

import entities.City;
import hibernateService.GenerallyHibernateQuery;
import hibernateService.HibernateService;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class CityHelper {
    private static List<City> listCity;
    private static City defaultCity;

    /**
     * Получение списка всех городов
     * @return Список городов
     */
    public static List<City> getListCities() {
        if (listCity == null) {
            synchronized (CityHelper.class){
                if (listCity == null) {
                    listCity = new HibernateService<City>(City.class).execute(new GenerallyHibernateQuery() {
                        @Override
                        public List<City> run(Session session) throws HibernateException {
                            return session.createCriteria(City.class).list();
                        }
                    });
                }
            }
        }
        return listCity;
    }

    /**
     * Получение города по id
     * @param id  Id города
     * @return Сущность Город
     */
    public static City getCityById(Integer id){
        List<City> cities = getListCities();
        for(City city: cities){
            if (city.getId().equals(id)){
                return city;
            }
        }
        return null;
    }

    /**
     * Получение города пользователя по умолчанию
     * @return Город пользователя по умолчанию. На данный момент, это Вологда
     */
    public static City getDefaultCity(){
        if(defaultCity == null){
            synchronized (CityHelper.class){
                if (defaultCity == null){
                    List<City> list = getListCities();
                    for(City city: list){
                        if(GlobalConstants.DEFAULT_CITY.equals(city.getName())){
                            defaultCity = city;
                            break;
                        }
                    }
                }
            }
        }
        return defaultCity;
    }

}
