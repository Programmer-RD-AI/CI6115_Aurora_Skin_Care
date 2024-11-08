# Time Interface in Model/Interfaces

This repository contains an interface named `Time` in the `model.interfaces` package. It defines methods to handle time-related data, including start time, end time, and date. The interface also implements basic error handling and logging to ensure that the provided times and dates are valid.

## Purpose

The `Time` interface is designed to:
- Provide a standardized way to handle and validate time and date data.
- Offer getter and setter methods for the start time, end time, and date.
- Include validation for ensuring that times and dates are logically correct.
- Log errors and warnings related to invalid data.

## Structure

The `Time` interface consists of the following key components:

### Instance Variables
- `LocalTime startTime`: Represents the start time (default is `null`).
- `LocalTime endTime`: Represents the end time (default is `null`).
- `Date date`: Represents the date (default is `null`).
- `Logger logger`: A logger instance for error and warning logging.

### Methods

#### Getters
- `LocalTime getStartTime()`: Retrieves the start time. Throws an `IllegalArgumentException` if the start time is invalid.
- `LocalTime getEndTime()`: Retrieves the end time. Throws an `IllegalArgumentException` if the end time is invalid.
- `LocalDate getDate()`: Retrieves the date. Throws an `IllegalArgumentException` if the date is invalid.

#### Setters
- `void setStartTime(LocalTime startTime)`: Sets the start time. Throws an `IllegalArgumentException` if the time is invalid.
- `void setEndTime(LocalTime endTime)`: Sets the end time. Throws an `IllegalArgumentException` if the time is invalid.
- `void setDate(Date date)`: Sets the date. Throws an `IllegalArgumentException` if the date is invalid.

### Validation Methods
- `default void validateStartTime(LocalTime startTime)`: Validates that the start time is not null or in the future.
- `default void validateEndTime(LocalTime endTime)`: Validates that the end time is not null and is after the start time.
- `default void validateDate(Date date)`: Validates that the date is not null or in the past.

## Error Handling and Logging

The `Time` interface includes built-in error handling to ensure that the times and dates are valid. If the provided start time, end time, or date is invalid, an `IllegalArgumentException` is thrown. The interface also uses a `Logger` to log warnings and errors related to invalid inputs.

### Example Usage:

```java
public class TimeExample implements Time {
    private LocalTime startTime;
    private LocalTime endTime;
    private Date date;

    @Override
    public LocalTime getStartTime() {
        return startTime;
    }

    @Override
    public void setStartTime(LocalTime startTime) {
        validateStartTime(startTime);
        this.startTime = startTime;
    }

    @Override
    public LocalTime getEndTime() {
        return endTime;
    }

    @Override
    public void setEndTime(LocalTime endTime) {
        validateEndTime(endTime);
        this.endTime = endTime;
    }

    @Override
    public LocalDate getDate() {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    @Override
    public void setDate(Date date) {
        validateDate(date);
        this.date = date;
    }
}
```