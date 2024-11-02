package util.availability;

import java.time.DayOfWeek;
import java.time.LocalTime;

public enum AvailabilityDataType {
    MONDAY_10_TO_13(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(13, 0)),
    WEDNESDAY_14_TO_17(DayOfWeek.WEDNESDAY, LocalTime.of(14, 0), LocalTime.of(17, 0)),
    FRIDAY_16_TO_20(DayOfWeek.FRIDAY, LocalTime.of(16, 0), LocalTime.of(20, 0)),
    SATURDAY_9_TO_13(DayOfWeek.SATURDAY, LocalTime.of(9, 0), LocalTime.of(13, 0));

    private final DayOfWeek day;      // Type: DayOfWeek
    private final LocalTime startTime; // Type: LocalTime
    private final LocalTime endTime;   // Type: LocalTime

    AvailabilityDataType(DayOfWeek day, LocalTime startTime, LocalTime endTime) {
        this.day = day;          // Initializing the day field
        this.startTime = startTime; // Initializing the start time field
        this.endTime = endTime;    // Initializing the end time field
    }

    public DayOfWeek getDay() {
        return day; // Returns the day
    }

    public LocalTime getStartTime() {
        return startTime; // Returns the start time
    }

    public LocalTime getEndTime() {
        return endTime;   // Returns the end time
    }
}
