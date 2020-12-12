/**
 * Создано: Денис 
 * Дата: 05.04.15
 * Описание: Класс - форма для статистики по лекарствам
 */
package forms;

import checkForm.Form;
import checkForm.FormImp;
import checkForm.fields.Field;
import checkForm.fields.FieldImp;
import checkForm.parsers.CalendarParser;
import checkForm.validators.CalendarValidator;
import checkForm.validators.NotEmptyValidator;
import helpers.GlobalConstants;

public class MedicamentStatForm extends ActionFormBase{
    private static Form form = createForm();

    @Override
    public Form getLogicForm() {
        return form;
    }

    private static Form createForm(){
        Form form = new FormImp();

        Field field = new FieldImp();
        field.setName(GlobalConstants.START_DAY);
        field.setDescription("Дата начала сбора статистики");
        field.setValidators(new NotEmptyValidator(), new CalendarValidator());
        field.setParser(new CalendarParser());
        form.addField(field);

        field = new FieldImp();
        field.setName(GlobalConstants.END_DAY);
        field.setDescription("Дата конца сбора статистики");
        field.setValidators(new NotEmptyValidator(),new CalendarValidator());
        field.setParser(new CalendarParser());
        form.addField(field);

        return form;
    }

}
