/**
 * Создано: Денис 
 * Дата: 12.02.15
 * Описание: 
 */
package helpers;

public class NumberHelper {

    public static final int AVAILABLE_TO_ORDER = -2;
    public static final int NOT_AVAILABLE = 0;
    public static final int NOT_DATA = -3;
    public static final int AVAILABLE = -1;

    /**
     * Получение количества единиц товара с учётом наличия и скрытности данных о количестве товара
     * @param count Количество единиц товара
     * @return "Нет в наличии" если количество единиц = 0, "Есть в наличии" если информация скрыта, "Доступно под заказ" = -2. В остальных случаях число.
     */
    public static String getAmountMedicament(Integer count){
        switch (count){
            case NOT_AVAILABLE:
                return "Нет в наличии";
            case AVAILABLE:
                return "Есть в наличии";
            case AVAILABLE_TO_ORDER:
                return "Доступно под заказ";
            case NOT_DATA:
                return "Нет данных";
        }
        return count.toString();
    }

    /**
     * Получение стоимости лекарства с учётом "шума"
     * @param cost стоимость
     * @return Строковое представление числа с учётом "шума"
     */
    public static String getCostMedicament(Double cost){
        if (cost < 0){
            return  "---";
        }
        return cost.toString();
    }
}
