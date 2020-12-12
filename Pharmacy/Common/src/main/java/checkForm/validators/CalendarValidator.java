/**
 * Создано: Денис 
 * Дата: 05.04.15
 * Описание: 
 */
package checkForm.validators;

import java.util.regex.Pattern;

public class CalendarValidator extends BaseValidator {

    private Pattern pattern;

    public CalendarValidator() {
        super("Введите дату в формате ДД.ММ.ГГГГ");
        pattern = Pattern.compile("\\d{2}.\\d{2}.\\d{4}");
    }

    @Override
    public boolean validate(String str) {
        return pattern.matcher(str).matches();
    }
}
