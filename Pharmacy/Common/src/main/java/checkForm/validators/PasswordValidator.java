/**
 * Создано: Денис 
 * Дата: 09.01.15
 * Описание: 
 */
package checkForm.validators;

import helpers.StringHelper;

import java.util.Map;

public class PasswordValidator extends BaseFormValidator {

    public PasswordValidator() {
        super("Пароли не совпадают");
    }

    @Override
    public boolean validate(Map<String, Object> map) {
        String password1 = (String) map.get("password1");
        String password2 = (String) map.get("password2");
        if (password1 == null && password2 == null){
            return true;
        }
        return StringHelper.isNotEmpty(password1) && password1.equals(password2);
    }
}
