package parsers;

/**
 * Created by Виктор on 14.11.2014.
 */
public class ParserFactory {
    public static Parser getParser(String parserName) throws Exception {
        Parser parser = null;
        parser = (Parser)Class.forName(parserName).newInstance();
        return parser;
    }
}
