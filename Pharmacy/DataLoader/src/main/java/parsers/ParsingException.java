package parsers;

/**
 * Created by Виктор on 26.11.2014.
 */
public class ParsingException extends Exception {

    public ParsingException(String message) {
        super(message);
    }

    public ParsingException(String message, Throwable cause) {
        super(message, cause);
    }
}
