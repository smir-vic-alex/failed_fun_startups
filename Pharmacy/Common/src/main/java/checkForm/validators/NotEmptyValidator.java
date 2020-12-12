/**
 * Создано: Денис 
 * Дата: 08.01.15
 * Описание: Валидатор проверки на пустоту
 */
package checkForm.validators;

import helpers.StringHelper;

public class NotEmptyValidator extends BaseValidator {

    public NotEmptyValidator(){
        errorMessage = "Поле ? не должно быть пустым";
    }

    @Override
    public boolean validate(String str) {
        return StringHelper.isNotEmpty(str);
    }
}
