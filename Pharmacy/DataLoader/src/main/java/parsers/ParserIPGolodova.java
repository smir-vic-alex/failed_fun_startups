package parsers;


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
 * Created by Виктор on 15.03.2015.
 */
public class ParserIPGolodova implements Parser {

    private static final String EMPTY = "";
    private static final String END_BODY = "<\\BODY>";
    private static final String END_HTML = "<\\HTML>";
    private List<UpdateRecord> list = new LinkedList<UpdateRecord>();
    private String encoding;
    private String currentRow;
    private UpdateRecord parseRecord;
    private Scanner scanner;

    protected final Logger LOG = LogManager.getLogger(ParserIPGolodova.class);


    private String nextTextStyle() {
        if (scanner.hasNextLine()) {
            currentRow = new String(scanner.nextLine().getBytes(), Charset.forName(encoding));
        }
        while (scanner.hasNextLine() && !currentRow.contains("TextStyle")) {
            currentRow = new String(scanner.nextLine().getBytes(), Charset.forName(encoding));
        }
        return currentRow;
    }

    private void skipHeader() {
        currentRow = EMPTY;
        while (scanner.hasNextLine() && !currentRow.contains("Срок годн.")) {
            currentRow = new String(scanner.nextLine().getBytes(), Charset.forName(encoding));
        }
        if (scanner.hasNextLine()) {
            currentRow = scanner.nextLine();
        }
    }

    private String getPrice() {
        String price = null;
        nextTextStyle();
        nextTextStyle();
        currentRow = nextTextStyle();

        if (currentRow.contains("TextStyle2") && currentRow.contains(".") && !currentRow.equals("<\\HTML>")&& !currentRow.equals("")) {
            price =  (currentRow.substring(currentRow.indexOf(">") + 1, currentRow.indexOf("</SPAN>")).replaceAll(" ", ""));
            if(price.contains(",")) {
                price = price.substring(0,price.indexOf(",")) +  price.substring(price.indexOf(",")+1);
            }

        }
        currentRow = nextTextStyle();
        return price;
    }

    private String getName() {
        String name = new String();
        if (currentRow.contains("TextStyle6")&& !currentRow.equals("<\\HTML>")&& !currentRow.equals("")) {
            name = currentRow.substring(currentRow.indexOf(">") + 1, currentRow.indexOf("</SPAN>")).toUpperCase();
        }
        currentRow = nextTextStyle();
        if (currentRow.contains("TextStyle6")&& !currentRow.equals("<\\HTML>")&& !currentRow.equals("")) {
            name = currentRow.substring(currentRow.indexOf(">") + 1, currentRow.indexOf("</SPAN>")).toUpperCase();
            currentRow = nextTextStyle();
        }
        return name;
    }

    private String getCount() {
        String count = new String();
        if (currentRow.contains("TextStyle5") && currentRow.contains(".")&& !currentRow.equals("<\\HTML>")&& !currentRow.equals("")) {
            //Если нужно выводить колличество товара на складе, то требуется раскоментировать эту строчку:
            //count = currentRow.substring(currentRow.indexOf(">") + 1, currentRow.indexOf("</SPAN>")).replaceAll(" ", "");
            count = "-1";
        }
        currentRow = nextTextStyle();
        return count;
    }


    /**
     * @return обновленные данные из распарсенной строки, где все распарсенные данные являются типом String
     */
    private UpdateRecord getParseRecord() throws ParsingException {
        try {
            if(StringHelper.isNotEmpty(currentRow) && !END_BODY.equals(currentRow)&& !END_HTML.equals(currentRow)) {
                parseRecord = new UpdateRecord();
                String price = getPrice();
                String name = getName();
                String count = getCount();
                if(StringHelper.isNotEmpty(price) && StringHelper.isNotEmpty(name) && StringHelper.isNotEmpty(count)) {
                    parseRecord.setCost(Double.parseDouble(price));
                    parseRecord.setName(name);
                    parseRecord.setAmount(Integer.parseInt(count));
                }
            }

        } catch (PatternSyntaxException | IndexOutOfBoundsException e) {
            throw new ParsingException("Не могу распарсить строку " + currentRow + " " + e.toString());
        }
        return parseRecord;
    }

    /**
     * Распарсить файл
     *
     * @param pathToFile путь до файла
     */
    private void parseFile(String pathToFile) {
        UpdateRecord updateRecord;
        scanner = new FileManager(pathToFile).getScanner();
        skipHeader();
        while (scanner.hasNextLine() && !END_BODY.equals(scanner.nextLine())&& !END_HTML.equals(scanner.nextLine())) {

            try {
                updateRecord = getParseRecord();
                if (updateRecord != null && updateRecord.getAmount() != null && updateRecord.getCost() != null && updateRecord.getName() != null){
                    list.add(updateRecord);
                }
            }catch (ParsingException e) {
                LOG.error(e);
            }
        }

    }

    public List<UpdateRecord> getRecords(String pathToFile, String encoding)throws ParsingException{
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
