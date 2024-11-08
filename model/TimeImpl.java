package model;

import model.interfaces.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class TimeImpl implements Time {
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    // Duration for each appointment in minutes
    private static final int APPOINTMENT_DURATION_MINUTES = 15;

    /**
     * Constructs a TimeImpl object with the specified date and start time.
     * The end time is automatically calculated based on the appointment duration.
     *
     * @param date The date of the appointment.
     * @param startTime The start time of the appointment.
     */
    public TimeImpl(LocalDate date, LocalTime startTime) {
        if (date == null || startTime == null) {
            throw new IllegalArgumentException("Date and start time cannot be null.");
        }
        this.date = date;
        this.startTime = startTime;
        this.endTime = startTime.plusMinutes(APPOINTMENT_DURATION_MINUTES); // Automatically set end time
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public LocalTime getStartTime() {
        return startTime;
    }

    @Override
    public LocalTime getEndTime() {
        return endTime;
    }

    /**
     * Sets a new start time for the appointment.
     * Automatically updates the end time based on the appointment duration.
     *
     * @param startTime The new start time for the appointment.
     * @throws IllegalArgumentException If the start time is null.
     */
    @Override
    public void setStartTime(LocalTime startTime) {
        if (startTime == null) {
            throw new IllegalArgumentException("Start time cannot be null.");
        }
        this.startTime = startTime;
        this.endTime = startTime.plusMinutes(APPOINTMENT_DURATION_MINUTES); // Update end time accordingly
    }

    /**
     * Sets a new end time for the appointment.
     *
     * @param endTime The new end time for the appointment.
     * @throws IllegalArgumentException If the end time is before the start time.
     */
    @Override
    public void setEndTime(LocalTime endTime) {
        if (endTime == null) {
            throw new IllegalArgumentException("End time cannot be null.");
        }
        if (endTime.isBefore(startTime)) {
            throw new IllegalArgumentException("End time cannot be before start time.");
        }
        this.endTime = endTime;
    }

    /**
     * Sets the date for the appointment using a java.util.Date object.
     *
     * @param date The date of the appointment.
     */
    @Override
    public void setDate(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null.");
        }
        this.date = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate(); // Convert java.util.Date to LocalDate
    }

    /**
     * Provides a string representation of the TimeImpl object.
     *
     * @return A string describing the time object.
     */
    @Override
    public String toString() {
        return "TimeImpl{" +
                "date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
