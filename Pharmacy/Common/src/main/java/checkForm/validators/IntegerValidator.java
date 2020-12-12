/**
 * Создано: Денис 
 * Дата: 08.01.15
 * Описание: Валидатор для целых чисел
 */
package checkForm.validators;

import java.util.regex.Pattern;

public class IntegerValidator extends BaseValidator {

   private Pattern pattern = Pattern.compile("-?\\d+");

    public IntegerValidator() {
        errorMessage = "";
    }


    @Override
    public boolean validate(String str) {
        return pattern.matcher(str).matches();
    }
}
