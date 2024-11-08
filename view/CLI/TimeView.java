package view.CLI;

import model.TimeImpl;
import model.DermatologistModel;
import model.interfaces.Time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeView {
    private final Scanner scanner = new Scanner(System.in);
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    /**
     * Gathers information about the time and checks if the dermatologist is available at the chosen time.
     * @param dermatologist The dermatologist whose availability needs to be checked.
     * @return A Time object containing the input data, if the dermatologist is available.
     */
    public Time getTimeDetails(DermatologistModel dermatologist) {
        LocalDate date;
        LocalTime startTime;
        Time time = null;

        // Loop until a valid time is found
        boolean validTime = false;
        while (!validTime) {
            date = getValidDate();
            startTime = getValidStartTime();

            // Check dermatologist availability
            if (isDermatologistAvailable(dermatologist, date, startTime)) {
                validTime = true;
                // Create a TimeImpl object using the date and startTime
                time = new TimeImpl(date, startTime);
            } else {
                System.out.println("The dermatologist is unavailable at this time. Please choose another time.");
            }
        }
        return time;
    }

    /**
     * Gets a valid date from the user input.
     * @return A valid LocalDate object.
     */
    private LocalDate getValidDate() {
        LocalDate date = null;
        while (date == null) {
            System.out.print("Enter appointment date (yyyy-MM-dd): ");
            String input = scanner.nextLine();
            try {
                date = LocalDate.parse(input, dateFormatter);
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
            }
        }
        return date;
    }

    /**
     * Gets a valid start time from the user input.
     * @return A valid LocalTime object.
     */
    private LocalTime getValidStartTime() {
        LocalTime startTime = null;
        while (startTime == null) {
            System.out.print("Enter appointment start time (HH:mm): ");
            String input = scanner.nextLine();
            try {
                startTime = LocalTime.parse(input, timeFormatter);
            } catch (Exception e) {
                System.out.println("Invalid time format. Please enter the time in the format HH:mm.");
            }
        }
        return startTime;
    }

    /**
     * Checks if the dermatologist is available at the given time.
     * @param dermatologist The dermatologist whose availability needs to be checked.
     * @param date The date of the appointment.
     * @param startTime The start time of the appointment.
     * @return true if the dermatologist is available, false otherwise.
     */
    private boolean isDermatologistAvailable(DermatologistModel dermatologist, LocalDate date, LocalTime startTime) {
        // Implement the logic to check if the dermatologist is available on the given date and time
        return dermatologist.checkAvailability(new TimeImpl(date, startTime));
    }
}
