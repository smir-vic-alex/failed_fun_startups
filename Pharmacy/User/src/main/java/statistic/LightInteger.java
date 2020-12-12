/**
 * Создано: Денис 
 * Дата: 04.04.15
 * Описание: Класс-обёртка над примитивом int.
 */
package statistic;

public class LightInteger {
    private int value;

    /**
     * Увеличение текщего значения на number
     * @param number Число, которое хотим прибавить к экземпляру класса
     */
    public void incrementOn(int number){
        value += number;
    }

    /**
     * Получение текущего значения, хранимого в классе
     * @return Текущее значение
     */
    public int getValue() {
        return value;
    }

    /**
     * Установка значения в нуль.
     */
    public void reset(){
        value = 0;
    }
}
