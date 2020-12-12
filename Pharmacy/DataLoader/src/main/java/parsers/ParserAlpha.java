package parsers;
/**
 * Created by Виктор on 04.11.2014.
 */


import fileService.FileManager;
import form.UpdateRecord;
import helpers.StringHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

/**
 * Парсер для внутреннего тестирования системы.
 * Формат парсера: "название+пробел+количество+пробел+стоимость+;".
 * На данном этапе следует строго соблюдать формат
 */
public class ParserAlpha implements Parser {

    private static final int NAME_INDEX = 0;
    private static final int AMOUNT_INDEX = 1;
    private static final int COST_INDEX = 2;
    private static final String SEPARATOR = "\\^";
    private UpdateRecord parseRecord;
    private Scanner scanner;
    private List<UpdateRecord> list = new LinkedList<UpdateRecord>();

    private Integer getNumber(String number) {
        return Integer.parseInt(number);
    }

    private Double getDoubleNumber(String real) {
        return Double.parseDouble(real);
    }

    /**
     * @return обновленные данные из распарсенной строки, где все распарсенные данные являются типом String
     */
    private UpdateRecord getParseRecord(String record) throws ParsingException {

        try {
            parseRecord = new UpdateRecord();
            String data[] = record.split(SEPARATOR);
            parseRecord.setName(data[NAME_INDEX]);
            parseRecord.setAmount(getNumber(data[AMOUNT_INDEX]));
            parseRecord.setCost(getDoubleNumber(data[COST_INDEX]));
        } catch (PatternSyntaxException e) {
            throw new ParsingException("Не могу распарсить строку: " + record, e);
        }catch (IndexOutOfBoundsException e){
            throw new ParsingException("Не могу распарсить строку: " + record, e);
        }
        return parseRecord;
    }

    /**
     * Распарсить файл
     *
     * @param pathToFile путь до файла
     */
    private void parseFile(String pathToFile, String encoding) throws ParsingException{

        scanner = new FileManager(pathToFile).getScanner();
        while (scanner.hasNextLine()) {
            String record = new String(scanner.nextLine().getBytes(),Charset.forName(encoding));
            list.add(getParseRecord(record));
        }

    }

    public List<UpdateRecord> getRecords(String pathToFile, String encoding) throws ParsingException {
        if (StringHelper.isNotEmpty(pathToFile)) {
            parseFile(pathToFile, encoding);
        } else {
            throw new ParsingException("Некорректный путь до файла");
        }
        return list;
    }
}
