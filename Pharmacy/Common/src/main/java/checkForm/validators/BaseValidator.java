/**
 * Создано: Денис 
 * Дата: 08.01.15
 * Описание: Базовый класс для валидаторов
 */
package checkForm.validators;

public abstract class BaseValidator implements Validator {

    protected String errorMessage;

    protected BaseValidator() {
    }

    protected BaseValidator(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public void setErrorMessage(String message) {
        this.errorMessage = message;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
