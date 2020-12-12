/**
 * Создано: Денис 
 * Дата: 04.01.15
 * Описание: Формя для формы входа
 */
package forms;

public class LoginForm extends ActionFormBase {
    private boolean isCorrectLoginAndPassword = true;
    private String errorMessage;

    /**
     * Установка флага, правильно ли были введены логин и пароль.
     * @param isCorrectLoginAndPassword Флаг
     */
    public void setCorrectLoginAndPassword(boolean isCorrectLoginAndPassword) {
        this.isCorrectLoginAndPassword = isCorrectLoginAndPassword;
    }

    /**
     * Проверка, были ли введены корректные данны логин и пароль.
     * @return Да, если логин и пароль корректны
     */
    public boolean isCorrectLoginAndPassword() {
        return isCorrectLoginAndPassword;
    }

    /**
     * Получение сообщения об ошибке.
     * @return Сообщение об ошибке
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Установка сообщения об ошибке.
     * @param errorMessage Сообщение об ошибке.
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
