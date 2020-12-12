package panel;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Класс проверки залогинености
 */
public class CheckUser {

    /**
     * Метод проверяет зашёл пользователь в кабинет или нет
     * @param request - запрос от клиента
     * @return Если пользователь залогинен, то true
     */
    public static boolean logon(HttpServletRequest request){
        Cookie cookies[] = request.getCookies();
        int i = 0;
        while (i < cookies.length && !cookies[i].getName().equals("l") ){
            i++;
        }
        if (i < cookies.length){
            String hash = cookies[i].getValue();
            String user = (String) request.getSession().getAttribute(hash);
            if (user != null){
                return true;
            }
        }
        return false;
    }
}
