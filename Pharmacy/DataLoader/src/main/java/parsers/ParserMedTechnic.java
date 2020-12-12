package parsers;

import fileService.FileManager;
import form.UpdateRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

/**
 * Created by Виктор on 25.03.2015.
 */
public class ParserMedTechnic implements Parser {

    private List<UpdateRecord> list = new LinkedList<UpdateRecord>();
    private String encoding;
    private String s;
    private UpdateRecord parseRecord;
    private final char DIVIDER_CHARACTER = '^';
    protected final Logger LOG = LogManager.getLogger(ParserMedTechnic.class);

    private Integer getNumber(String number) {
        return Integer.parseInt(number);
    }

    private Double getRealNumber(String real) {
        return Double.parseDouble(real);
    }

    private String getPrice() {
        return s.substring(s.indexOf(DIVIDER_CHARACTER) + 1, s.lastIndexOf(DIVIDER_CHARACTER));
    }

    private String getName() {
        return s.substring(0, s.indexOf(DIVIDER_CHARACTER));
    }

    private String getCount() {
        return s.substring(s.lastIndexOf(DIVIDER_CHARACTER) + 1, s.length());
    }

    /**
     * Парсит строку
     * @throws ParsingException
     */
    private void parseString() throws ParsingException {
        try {
            parseRecord = new UpdateRecord();
            parseRecord.setName(getName());
            parseRecord.setCost(getRealNumber(getPrice()));
            parseRecord.setAmount(getNumber(getCount()) == 1 ? -1 : 0);
        } catch (PatternSyntaxException e) {
            throw new ParsingException("Не могу распарсить строку " + s + " " + e.toString());
        }
    }

    /**
     * Распарсить файл
     *@param pathToFile путь до файла
     */
    private void parseFile(String pathToFile) {
        Scanner scanner = new FileManager(pathToFile).getScanner();
        while (scanner.hasNextLine()) {
            try {
                s = new String(scanner.nextLine().getBytes(), Charset.forName(encoding));

                //TODO Почему-то не считывается в нужной кодировке буква 'И', пришлось ставить этот if
                if (s.indexOf((char) 65533) > -1) {
                    s = s.replace(s.charAt(s.indexOf((char) 65533)), 'И').replace("?", "");
                }
                parseString();
                if (parseRecord != null) {
                    list.add(parseRecord);
                }
            } catch (NullPointerException e) {
                LOG.error("Ошибка при попытке поместить строку в лист распарсенных данных " + e.toString());
            } catch (ParsingException e) {
                LOG.error(e.toString());
            }
        }

    }

    public List<UpdateRecord> getRecords(String pathToFile, String encoding) throws ParsingException {
        if (pathToFile != null && !pathToFile.equals("")) {
            this.encoding = encoding;
            parseFile(pathToFile);
        } else {
            throw new ParsingException("Некорректный путь до файла");
        }
        if (!list.isEmpty()) {
            return list;
        } else {
            throw new ParsingException("Нет распарсенных данных");
        }

    }
}
