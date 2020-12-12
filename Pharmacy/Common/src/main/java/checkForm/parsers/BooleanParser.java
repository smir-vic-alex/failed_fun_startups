/**
 * Создано: Денис 
 * Дата: 28.03.15
 * Описание: Парсер для полей типа boolean
 */
package checkForm.parsers;

import exceptions.ParserException;

public class BooleanParser implements FieldParser {
    @Override
    public Object parser(String entity) throws ParserException {
        return Boolean.valueOf(entity);
    }
}
