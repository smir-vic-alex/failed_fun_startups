/**
 * Создано: Денис 
 * Дата: 04.01.15
 * Описание: Класс-помошник для работы со строками
 */
package helpers;

public class StringHelper {

    /**
     * Проверка на пустую строку
     *
     * @param str Проверяемая строка
     * @return Да, если строка равна null или пустая. Нет в остальных случаях
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * Проверка, не пустая ли строка.
     * @param str Проверяемая строка
     * @return Да, если строка не пустая. Нет в остальных случаях
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * Разделение строки на части по разделителю
     * @param str Строка
     * @param delimiter Разделитель
     * @return Массив из строк, полученный разделением входяшей строки через разделитель.
     */
    public static String[] slit(String str, String delimiter) {
        return str.split(delimiter);
    }

    /**
     * Склоняет слово "Предложение" от числительного
     *
     * @param number - числительное в диапозоне от 0 до 99
     * @return "Предложение в нужном падеже"
     */
    public static String declension(Long number) {

        if (11 <= number && number <= 14) {
            return "предложений";
        } else {
            long rest = number % 10;
            if (rest == 1) {
                return "предложение";
            } else if (2 <= rest && rest <= 4) {
                return "предложения";
            } else {
                return "предложений";
            }
        }
    }
}