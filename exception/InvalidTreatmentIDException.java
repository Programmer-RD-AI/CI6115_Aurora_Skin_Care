package exception;

/**
 * Custom exception thrown when an invalid treatment ID is encountered.
 */
public class InvalidTreatmentIDException extends Exception {

    /**
     * Constructor for InvalidTreatmentIDException with a custom error message.
     *
     * @param message The custom message to be passed with the exception
     */
    public InvalidTreatmentIDException(String message) {
        super(message);
    }
}