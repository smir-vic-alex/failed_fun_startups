/**
 * Создано: Денис 
 * Дата: 08.01.15
 * Описание: "Пустой" парсер. Возвращает строку как есть.
 */
package checkForm.parsers;

import exceptions.ParserException;

public class EmptyParser implements FieldParser{
    @Override
    public Object parser(String entity) throws ParserException{
        return entity;
    }
}
