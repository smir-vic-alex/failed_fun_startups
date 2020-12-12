package records;

/**
 * Created by Виктор on 23.05.2014.
 */

import hibernateServise.User;

/**
 * Класс для проверки поля из формы
 */
public class CheckRecords {
    /**
     * Метод проверки состоит ли строка только из русских букв или нет
     * true если состоит из русских букв
     *
     * @param s - строка
     * @return boolean
     */
    private static boolean isConsistOfRussianLetters(String s) {
        char[] buf = new char[s.length()];
        s.getChars(0, s.length(), buf, 0);
        for (int i = 0; i < s.length(); i++) {
            if ('а' <= buf[i] && buf[i] <= 'я' || 'А' <= buf[i] && buf[i] <= 'Я') {

            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * Метод проверки записи на корректность (не пустая, не null, состоит из букв русского алфавита)
     *
     * @param s входная строка
     * @return boolean
     */
    private static boolean recordIsCorrect(String s) {
        if (!s.equals("") && s != null ) {
            return true;
        }
        return false;
    }

    /**
     * Метод проверки на корректность данных полей day и month
     *
     * @param day   день
     * @param month месяц
     * @return boolean
     */
    private static boolean dateIsCorrect(Integer day, Integer month) {
        if (day != null && month != null) {
                switch (month) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        if (0 <= day && day <= 31) {
                            return true;
                        }
                        return false;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        if (0 <= day && day <= 30) {
                            return true;
                        }
                        return false;
                    case 2:
                        if (0 <= day && day <= 28) {
                            return true;
                        }
                        return false;
                    default:
                        return false;
                }
        }
        return false;
    }

    /**
     * Метод проверки на корректность данных поля vkId
     *
     * @param vkId ссылка на страницу в соц сети ВКонтакте
     * @return boolean
     */
    private static boolean recordVKidIsCorrect(String vkId) {

        if (vkId.indexOf("http://vk.com/") == 0 || vkId.indexOf("vk.com/") == 0) {
            return true;
        }
        return false;

    }

    /**
     * Метод проверки строки на допустимую длину
     * true если длина строки не превосходит допустимую длину
     *
     * @param s      - строка
     * @param length - допустимая длина
     * @return boolean
     */
    private static boolean doesNotExceed(String s, int length) {
        if (s.length() <= length) {
            return true;
        }
        return false;
    }

    /**
     * Метод проверки на корректность пришедшей строки с ожидаемым значением
     * true если строка не null и совпадает с ожидаемым значением
     *
     * @param s             - строка, которую проверяем
     * @param expectedValue - строка с которой сравниваем на эквивалентность
     * @return boolean
     */
    private static boolean isCoincides(String s, String expectedValue) {
        if (s != null && s.equals(expectedValue)) {
            return true;
        }
        return false;
    }

    public static boolean driverFormIsCorrect(User form) {
        if (recordIsCorrect(form.getStartpoint()) && recordIsCorrect(form.getFinishpoint()) && dateIsCorrect(form.getDay(), form.getMonth())
                && recordVKidIsCorrect(form.getVkId()) && doesNotExceed(form.getInformation(), 1000) && isCoincides(form.getAgree(), "true")) {
            return true;
        }
        return false;
    }

    public static boolean passengerFormIsCorrect(User form) {
        if (recordIsCorrect(form.getStartpoint()) && recordIsCorrect(form.getFinishpoint()) && dateIsCorrect(form.getDay(), form.getMonth())
                && isCoincides(form.getAgree(), "true")) {
            return true;
        }
        return false;
    }
}

