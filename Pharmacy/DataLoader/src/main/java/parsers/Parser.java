package parsers;
/**
 * Created by Виктор on 04.11.2014.
 */

import form.UpdateRecord;

import java.util.List;

/**
 * Интерфейс парсера
 */
public interface Parser {

    /**
     *
     * @param pathToFile путь до файла, который нужно распарсить
     * @param encoding кодировка файла
     * @return лист распарсенных данных
     */
    public List<UpdateRecord> getRecords(String pathToFile, String encoding)throws ParsingException;

}
