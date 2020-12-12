/**
 * Создано: Денис 
 * Дата: 09.01.15
 * Описание: 
 */
package checkForm.validators;

public abstract class BaseFormValidator implements FormValidator {

    protected String errorMessage;

    protected BaseFormValidator(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public void setErrorMessage(String message) {
        errorMessage= message;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
