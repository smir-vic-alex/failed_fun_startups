/**
 * Создано: Денис 
 * Дата: 08.01.15
 * Описание: Валидатор для произвольных регулярных выражений.
 */
package checkForm.validators;

import java.util.regex.Pattern;

public class RegExpValidator extends BaseValidator {

    private Pattern pattern;

    public RegExpValidator(String regExp) {
        this(regExp,"Данные не соответствуют шаблону");
    }

    public RegExpValidator(String regExp, String errorMessage) {
        super(errorMessage);
        pattern = Pattern.compile(regExp);
    }

    @Override
    public boolean validate(String str) {
        return pattern.matcher(str).matches();
    }
}
