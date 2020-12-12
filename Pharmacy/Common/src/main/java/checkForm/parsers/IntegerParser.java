/**
 * Создано: Денис 
 * Дата: 08.01.15
 * Описание: Парсер разбирает строку как число. Вовращает целое число
 */
package checkForm.parsers;

import exceptions.ParserException;

public class IntegerParser implements FieldParser {
    @Override
    public Object parser(String entity) throws ParserException{
        return Integer.valueOf(entity);
    }
}
