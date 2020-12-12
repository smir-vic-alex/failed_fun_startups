package parsers;

import fileService.FileManager;
import form.UpdateRecord;
import helpers.StringHelper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Виктор on 07.04.2015.
 */
public class ParserSOPharmCSV implements Parser{

    private List<UpdateRecord> list = new LinkedList<UpdateRecord>();
    private String encoding;
    private String s;
    private StringReader stringReader;
    private UpdateRecord parseRecord;
    private Scanner scanner;
    private final char DIVIDER_CHARACTER = ';';
    private final String COMMA = ",";
    private final String POINT = ".";
    private final String QUOTE = "\"";
    private final String EMPTY = "";
    private CSVRecord csvRecord;
    private final int NAME = 2;
    private final int COST = 5;

    protected final Logger LOG = LogManager.getLogger(ParserSOPharmCSV.class);

    private void skipHeader() {
        s = new String(scanner.nextLine().getBytes(), Charset.forName(encoding));
        while (s.charAt(0) != '8') {
            s = new String(scanner.nextLine().getBytes(), Charset.forName(encoding));
        }
        stringReader = new StringReader(s);
    }

    /**
     * Распарсить файл
     *
     * @param pathToFile путь до файла
     */
    private void parseFile(String pathToFile) {

        scanner = new FileManager(pathToFile).getScanner();
        skipHeader();
        while (scanner.hasNextLine()) {
            try {
                parseRecord = new UpdateRecord();
                csvRecord = CSVFormat.EXCEL.withDelimiter(DIVIDER_CHARACTER).parse(stringReader).getRecords().get(0);
                parseRecord.setName(csvRecord.get(NAME).trim().replaceAll(QUOTE, EMPTY));
                parseRecord.setCost(Double.parseDouble(csvRecord.get(COST).trim().replaceAll(COMMA, POINT)));
                parseRecord.setAmount(-1);
                if(parseRecord != null && parseRecord.getAmount() != null && parseRecord.getCost() != null && parseRecord.getName() != null){
                    list.add(parseRecord);
                }

               //TODO Почему-то не считывается в нужной кодировке буква 'И'
                s = new String(scanner.nextLine().getBytes(), Charset.forName(encoding));
                if (s.indexOf((char) 65533) > -1) {
                    s = s.replace(s.charAt(s.indexOf((char) 65533)), 'И').replace("?", EMPTY);
                }

                stringReader = new StringReader(s);

            } catch (IOException e) {
                LOG.error("Ошибка при попытке поместить строку в лист распарсенных данных " + e.toString());
            }
        }
    }

    public List<UpdateRecord> getRecords(String pathToFile, String encoding) throws ParsingException {
        if (StringHelper.isNotEmpty(pathToFile)) {
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
