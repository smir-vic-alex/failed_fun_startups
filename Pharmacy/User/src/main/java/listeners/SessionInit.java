/**
 * Создано: Денис 
 * Дата: 24.01.15
 * Описание: Класс для инициализации сесси
 */
package listeners;

import helpers.CityHelper;
import helpers.GlobalConstants;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionInit implements HttpSessionListener {


    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        httpSessionEvent.getSession().setAttribute(GlobalConstants.ID_USER_CITY, CityHelper.getDefaultCity());
        httpSessionEvent.getSession().setAttribute(GlobalConstants.FLAG_CITY_CHECK,Boolean.FALSE);
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }

}
