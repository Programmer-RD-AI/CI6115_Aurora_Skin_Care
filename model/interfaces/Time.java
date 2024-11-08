package model.interfaces;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.logging.Logger;

/**
 * Interface defining methods for handling time-related data.
 * This interface provides getters and setters for start time, end time, and date.
 * It also includes basic error handling considerations for invalid time or date input.
 */
public interface Time {

    // Default values for time and date; can be overridden by implementing classes
    LocalTime startTime = null;  // Represents the start time (default is null)
    LocalTime endTime = null;    // Represents the end time (default is null)
    Date date = null;            // Represents the date (default is null)

    // Logger instance for logging errors or warnings
    Logger logger = Logger.getLogger(Time.class.getName());

    /**
     * Retrieves the start time for this time period.
     *
     * @return The start time as a LocalTime object.
     * @throws IllegalArgumentException if start time is not valid (null or in the future).
     */
    LocalTime getStartTime();

    /**
     * Retrieves the end time for this time period.
     *
     * @return The end time as a LocalTime object.
     * @throws IllegalArgumentException if end time is not valid (null or earlier than start time).
     */
    LocalTime getEndTime();

    /**
     * Retrieves the date for this time period.
     *
     * @return The date as a LocalDate object.
     * @throws IllegalArgumentException if the date is not valid (null or in the past).
     */
    LocalDate getDate();

    /**
     * Sets the start time for this time period.
     *
     * @param startTime The start time as a LocalTime object.
     * @throws IllegalArgumentException if the start time is null or in the future.
     */
    void setStartTime(LocalTime startTime);

    /**
     * Sets the end time for this time period.
     *
     * @param endTime The end time as a LocalTime object.
     * @throws IllegalArgumentException if the end time is null or earlier than the start time.
     */
    void setEndTime(LocalTime endTime);

    /**
     * Sets the date for this time period.
     *
     * @param date The date as a Date object.
     * @throws IllegalArgumentException if the date is null or in the past.
     */
    void setDate(Date date);

    /**
     * Validates if the given start time is valid.
     * This method ensures that the start time is not in the future.
     *
     * @param startTime The start time to validate.
     * @throws IllegalArgumentException if the start time is invalid.
     */
    default void validateStartTime(LocalTime startTime) {
        if (startTime == null) {
            logger.severe("Start time cannot be null.");
            throw new IllegalArgumentException("Start time cannot be null.");
        }
        if (startTime.isAfter(LocalTime.now())) {
            logger.warning("Start time is in the future.");
            throw new IllegalArgumentException("Start time cannot be in the future.");
        }
    }

    /**
     * Validates if the given end time is valid.
     * This method ensures that the end time is not earlier than the start time.
     *
     * @param endTime The end time to validate.
     * @throws IllegalArgumentException if the end time is invalid.
     */
    default void validateEndTime(LocalTime endTime) {
        if (endTime == null) {
            logger.severe("End time cannot be null.");
            throw new IllegalArgumentException("End time cannot be null.");
        }
        if (endTime.isBefore(getStartTime())) {
            logger.warning("End time cannot be before start time.");
            throw new IllegalArgumentException("End time cannot be before start time.");
        }
    }

    /**
     * Validates if the given date is valid.
     * This method ensures that the date is not in the past.
     *
     * @param date The date to validate.
     * @throws IllegalArgumentException if the date is invalid.
     */
    default void validateDate(Date date) {
        if (date == null) {
            logger.severe("Date cannot be null.");
            throw new IllegalArgumentException("Date cannot be null.");
        }
        if (date.before(new Date())) {
            logger.warning("Date cannot be in the past.");
            throw new IllegalArgumentException("Date cannot be in the past.");
        }
    }
}
