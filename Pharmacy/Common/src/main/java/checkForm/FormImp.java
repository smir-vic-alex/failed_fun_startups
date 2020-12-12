/**
 * Создано: Денис 
 * Дата: 08.01.15
 * Описание: 
 */
package checkForm;

import checkForm.fields.Field;
import checkForm.validators.FormValidator;
import checkForm.validators.Validator;

import java.util.ArrayList;
import java.util.List;

public class FormImp implements Form {
    private String name;
    private List<Field> fields = new ArrayList<>();
    private List<FormValidator> validatorsList = new ArrayList<>();
    @Override
    public List<Field> getFields() {
        return fields;
    }

    @Override
    public void addField(Field field) {
        fields.add(field);
    }

    @Override
    public void addValidators(FormValidator... validators) {
        for (FormValidator validator : validators) {
            validatorsList.add(validator);
        }
    }

    @Override
    public List<FormValidator> getValidators() {
        return validatorsList;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
