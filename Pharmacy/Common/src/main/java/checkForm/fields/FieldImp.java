/**
 * Создано: Денис 
 * Дата: 08.01.15
 * Описание: Реализация интерфейса Field.
 */
package checkForm.fields;

import checkForm.parsers.FieldParser;
import checkForm.validators.Validator;

import java.util.ArrayList;
import java.util.List;

public class FieldImp implements Field {
    private List<Validator> validatorsList = new ArrayList<>();
    private FieldParser parser;
    private String name;
    private String description;
    private boolean require = true;

    @Override
    public void setValidator(Validator validator) {
        validatorsList.add(validator);
    }

    @Override
    public void setValidators(Validator[] validators) {
        for(Validator validator: validators){
            validatorsList.add(validator);
        }
    }

    @Override
    public List<Validator> getValidators() {
        return validatorsList;
    }

    @Override
    public void setParser(FieldParser parser) {
        this.parser = parser;
    }

    @Override
    public FieldParser getParser() {
        return this.parser;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setNotRequired() {
        require = false;
    }

    @Override
    public boolean isRequire() {
        return require;
    }
}
