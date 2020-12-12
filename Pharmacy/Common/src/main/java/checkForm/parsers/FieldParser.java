/**
 * Создано: Денис 
 * Дата: 08.01.15
 * Описание: Интерфейс для всех парсеров полей.
 */
package checkForm.parsers;

import exceptions.ParserException;

public interface FieldParser {
    /**
     * Парсинг поля.
     * @param entity Разбираемый объект
     * @return Распарсенная сущность
     * @throws ParserException
     */
    public Object parser(String entity) throws ParserException;
}
