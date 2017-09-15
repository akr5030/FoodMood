package analytics;

/**
 * Thrown to indicate that an error has occurred when attempting to generate one
 * of the analytics (report) views.
 *
 * @author jsm158
 */
public class AnalyticsException extends Exception {

    /**
     * Constructs a new AnalyticsException with the specified detail message.
     *
     * @param message the detail message
     */
    public AnalyticsException(String message) {
        super(message);
    }

    /**
     * Constructs a new Analytics Exception with the specified detail message
     * and cause.
     *
     * Note that the detail message associated with cause is not automatically
     * incorporated in the detail message.
     *
     * @param message the detail message
     * @param cause the cause (which is saved for later retrieval by the
     * Throwable.getCause() method). (A null value is permitted, and indicates
     * that the cause is nonexistent or unknown.)
     */
    public AnalyticsException(String message, Throwable cause) {
        super(message, cause);
    }

}
