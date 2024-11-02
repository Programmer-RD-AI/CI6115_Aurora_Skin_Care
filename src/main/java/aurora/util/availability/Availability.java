package util.availability;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Availability {
    private DayOfWeek day;
    private LocalTime startTime;
    private LocalTime endTime;

    public Availability(DayOfWeek day, LocalTime startTime, LocalTime endTime) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}
