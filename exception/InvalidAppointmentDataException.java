package exception;

// Custom exception for invalid appointment data (e.g., missing or incorrect input)
public class InvalidAppointmentDataException extends RuntimeException {
    public InvalidAppointmentDataException(String message) {
        super(message);
    }
}