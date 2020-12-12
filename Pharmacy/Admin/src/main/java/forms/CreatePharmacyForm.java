/**
 * Создано: Денис 
 * Дата: 09.01.15
 * Описание: 
 */
package forms;

import checkForm.Form;
import checkForm.FormImp;
import checkForm.fields.Field;
import checkForm.fields.FieldImp;
import checkForm.parsers.BooleanParser;
import checkForm.parsers.CityParser;
import checkForm.parsers.EmptyParser;
import checkForm.parsers.IntegerParser;
import checkForm.validators.IntegerValidator;
import checkForm.validators.NotEmptyValidator;
import checkForm.validators.PasswordValidator;

public class CreatePharmacyForm extends ViewPharmacyForm {
    public static final Form FORM = create();

    @Override
    public Form getLogicForm() {
        return FORM;
    }

    private static Form create() {
        Form form = new FormImp();
        Field field = new FieldImp();
        field.setName("name");
        field.setDescription("Название аптеки");
        field.setValidator(new NotEmptyValidator());
        field.setParser(new EmptyParser());
        form.addField(field);

        field = new FieldImp();
        field.setName("address");
        field.setDescription("Адрес аптеки");
        field.setValidator(new NotEmptyValidator());
        field.setParser(new EmptyParser());
        form.addField(field);

        //TODO:Прикрутить проверку на коррекстность номера после прикручивания соответствующего скрипта
        field = new FieldImp();
        field.setName("phone");
        field.setDescription("Телефон аптеки");
        field.setValidator(new NotEmptyValidator());
        field.setParser(new EmptyParser());
        form.addField(field);

        field = new FieldImp();
        field.setName("city");
        field.setDescription("Id города");
        field.setValidators(new NotEmptyValidator(), new IntegerValidator());
        field.setParser(new CityParser());
        form.addField(field);

        field = new FieldImp();
        field.setName("codeNetwork");
        field.setDescription("Код сети");
        field.setNotRequired();
        field.setValidators(new NotEmptyValidator(), new IntegerValidator());
        field.setParser(new IntegerParser());
        form.addField(field);

        field = new FieldImp();
        field.setName("coordinates");
        field.setDescription("Координаты");
        field.setValidator(new NotEmptyValidator());
        field.setParser(new EmptyParser());
        form.addField(field);

        field = new FieldImp();
        field.setName("login");
        field.setDescription("Логин");
        field.setValidators(new NotEmptyValidator());
        field.setParser(new EmptyParser());
        form.addField(field);

        field = new FieldImp();
        field.setName("password1");
        field.setDescription("Пароль 1");
        field.setValidators(new NotEmptyValidator());
        field.setParser(new EmptyParser());
        form.addField(field);

        field = new FieldImp();
        field.setName("password2");
        field.setDescription("Пароль 2");
        field.setValidators(new NotEmptyValidator());
        field.setParser(new EmptyParser());
        form.addField(field);

        field = new FieldImp();
        field.setName("workTime");
        field.setDescription("Время работы");
        field.setValidators(new NotEmptyValidator());
        field.setParser(new EmptyParser());
        form.addField(field);

        field = new FieldImp();
        field.setName("fakePrice");
        field.setDescription("Активировать Шум");
        field.setNotRequired();
        field.setValidators(new NotEmptyValidator());
        field.setParser(new BooleanParser());
        form.addField(field);

        form.addValidators(new PasswordValidator());

        return form;
    }
}
