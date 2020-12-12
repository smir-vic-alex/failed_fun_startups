/**
 * Создано: Денис 
 * Дата: 08.01.15
 * Описание: Интерфейс для всех валидаторов
 */
package checkForm.validators;

public interface Validator {

    /**
     * Валидация входной строки.
     * @param str Строка для валидации
     * @return Да, если поле корректно. Нет, в противном случае.
     */
    public boolean validate(String str);

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
