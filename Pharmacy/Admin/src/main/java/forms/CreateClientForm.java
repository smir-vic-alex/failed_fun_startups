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
import checkForm.parsers.EmptyParser;
import checkForm.validators.NotEmptyValidator;
import checkForm.validators.PasswordValidator;

public class CreateClientForm extends ViewClientForm {
    public static final Form FORM = create();

    @Override
    public Form getLogicForm() {
        return FORM;
    }

    public static Form create(){
        Form form = new FormImp();
        Field field = new FieldImp();
        field.setName("firstName");
        field.setDescription("Имя");
        field.setValidator(new NotEmptyValidator());
        field.setParser(new EmptyParser());
        form.addField(field);

        field = new FieldImp();
        field.setName("secondName");
        field.setDescription("Фамилия");
        field.setValidator(new NotEmptyValidator());
        field.setParser(new EmptyParser());
        form.addField(field);

        field = new FieldImp();
        field.setName("fatherName");
        field.setDescription("Отчество");
        field.setValidator(new NotEmptyValidator());
        field.setParser(new EmptyParser());
        form.addField(field);

        field = new FieldImp();
        field.setName("phone");
        field.setDescription("Телефон");
        field.setValidator(new NotEmptyValidator());
        field.setParser(new EmptyParser());
        form.addField(field);

        field = new FieldImp();
        field.setName("email");
        field.setDescription("E-mail");
        field.setValidator(new NotEmptyValidator());
        field.setParser(new EmptyParser());
        form.addField(field);

        field = new FieldImp();
        field.setName("login");
        field.setDescription("Логин");
        field.setValidator(new NotEmptyValidator());
        field.setParser(new EmptyParser());
        form.addField(field);

        field = new FieldImp();
        field.setName("password1");
        field.setDescription("Пароль1");
        field.setValidator(new NotEmptyValidator());
        field.setParser(new EmptyParser());
        form.addField(field);

        field = new FieldImp();
        field.setName("password2");
        field.setDescription("Пароль2");
        field.setValidator(new NotEmptyValidator());
        field.setParser(new EmptyParser());
        form.addField(field);

        form.addValidators(new PasswordValidator());

        return form;
    }
}
