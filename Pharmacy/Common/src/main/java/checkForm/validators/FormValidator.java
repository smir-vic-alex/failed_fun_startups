/**
 * Создано: Денис 
 * Дата: 09.01.15
 * Описание: 
 */
package checkForm.validators;

import java.util.Map;

public interface FormValidator {
    /**
     * Валидация входных данных с формы
     * @param map Map'а для валидации
     * @return Да, если поле корректно. Нет, в противном случае.
     */
    public boolean validate(Map<String, Object> map);

    /**
     * Установление сообщения об ошибке, которое будет выводиться в случае неудачной валидации.
     * @param message Сообщение об ощибке
     */
    public void setErrorMessage(String message);

    /**
     * Получение сообщения об ощибке.
     * @return Сообщение об ощибке
     */
    public String getErrorMessage();
}
