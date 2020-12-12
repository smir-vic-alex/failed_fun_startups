/**
 * Создано: Денис 
 * Дата: 08.01.15
 * Описание: Парсер для поля Город. Возвращает город по id
 */
package checkForm.parsers;

import entities.City;
import exceptions.ParserException;
import helpers.CityHelper;


public class CityParser implements FieldParser {
    @Override
    public Object parser(String entity) throws ParserException {
        City city = null;
        try {
            Integer id = Integer.valueOf(entity);
            city = CityHelper.getCityById(id);
            if (city == null){
                throw new Exception("Город с id = " + id + " не найден");
            }
        } catch (Exception e) {
            throw new ParserException(e);
        }
        return city;
    }
}
