/**
 * Создано: Денис 
 * Дата: 08.01.15
 * Описание: Класс для валидации и парсинга данных с формы
 */
package checkForm;

import checkForm.fields.Field;
import checkForm.parsers.FieldParser;
import checkForm.validators.FormValidator;
import checkForm.validators.Validator;
import exceptions.ParserException;
import helpers.StringHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.HashMap;
import java.util.Map;

public class FormHandler {
    private Logger log = LogManager.getLogger(FormHandler.class);
    private Map<Object, Object> mapInputValue;
    private Form form;
    private Map<String, Object> mapOutputValue = new HashMap<>();
    private String errorMessage;

    public FormHandler(Map<Object, Object> mapValue, Form form) {
        this.mapInputValue = mapValue;
        this.form = form;
    }

    /**
     * Обработка данных с формы
     * @return Да, если данные корректны. Нет в противном случае.
     */
    public boolean handler() throws ParserException {
        for (Field field : form.getFields()) {
            String value = (String)mapInputValue.get(field.getName());
            //Если поле не обязательное и пустое, то пропускаем его
            if (!field.isRequire() && StringHelper.isEmpty(value)){
                continue;
            }
            for (Validator validator : field.getValidators()) {
                if (!validator.validate(value)){
                    log.debug("Некоретное значение у поля \"" + field.getName()+"\". Валидатор: " + validator.getClass().getName());
                    errorMessage = validator.getErrorMessage();
                    return false;
                }
            }
            if (value != null){
                FieldParser parser = field.getParser();
                Object entity = null;
                try{
                    entity = parser != null ? parser.parser(value) : value;
                }catch (ParserException e){
                    log.error("Неудалось распарсить поле \"" + field.getName() + "\". Парсе: " + parser.getClass().getName());
                    throw e;
                }
                if (entity != null){
                    mapOutputValue.put(field.getName(), entity);
                }
            }
        }
        for(FormValidator validator:form.getValidators()){
            if (!validator.validate(mapOutputValue)){
                log.debug("Некоретное значение у формы. Валидатор: " + validator.getClass().getName());
                errorMessage = validator.getErrorMessage();
                return false;
            }
        }
        return true;
    }

    /**
     * Получение результата обработки
     * @return Map'а, содержащая значения с формы.
     */
    public Map<String, Object> getResult() {
        return mapOutputValue;
    }

    /**
     * Получение сообщения об ошибке.
     * @return Сообшение об ошибке.
     */
    public String getErrorMessage() {
        return errorMessage;
    }
}
