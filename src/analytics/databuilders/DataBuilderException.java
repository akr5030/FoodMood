package analytics.databuilders;

/**
 * Custom exception class for DataBuilder-related exceptions
 *
 * @author jsm158
 * 
 */
public class DataBuilderException extends Exception {

    public DataBuilderException() {
        super();
    }

    public DataBuilderException(String message) {
        super(message);
    }

    public DataBuilderException(String message, Throwable cause) {
        super(message, cause);
    }

}
