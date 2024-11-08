package view.CLI;

import model.DermatologistModel;
import model.TimeImpl;
import model.enums.Dermatologist;
import model.interfaces.Time;
import repository.DermatologistRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class DermatologistView {
    private final Scanner scanner = new Scanner(System.in);
    private final DermatologistRepository dermatologistRepository;

    // Constructor to initialize repository
    public DermatologistView(DermatologistRepository repository) {
        this.dermatologistRepository = repository;
    }

    public DermatologistView() {
        this.dermatologistRepository = new DermatologistRepository();
    }

    // Select a dermatologist from the predefined list
    public DermatologistModel selectDermatologist() {
        System.out.println("Select a dermatologist:");

        // List dermatologists
        for (Dermatologist dermatologist : Dermatologist.values()) {
            System.out.println((dermatologist.ordinal() + 1) + ". " + dermatologist.getName());
        }

        // User input handling with validation
        int choice = getValidInputFromUser("Enter the number corresponding to the dermatologist: ", 1, Dermatologist.values().length);
        return new DermatologistModel(Dermatologist.values()[choice - 1]);
    }

    // Add a time slot for the selected dermatologist
    public void addTimeSlotForDermatologist() {
        DermatologistModel selectedDermatologist = selectDermatologist();
        LocalDate date = getValidDateFromUser();
        LocalTime startTime = getValidStartTimeFromUser();

        // Create time slot and try to add
        Time timeSlot = new TimeImpl(date, startTime);
        if (dermatologistRepository.addTimeSlot(selectedDermatologist, timeSlot)) {
            System.out.println("Appointment successfully scheduled for " + selectedDermatologist.getName() + " on " + date + " from " + startTime + " to " + timeSlot.getEndTime());
        } else {
            System.out.println("The selected time slot is not available for " + selectedDermatologist.getName() + ". Please try another time.");
        }
    }

    // Get valid date from the user
    private LocalDate getValidDateFromUser() {
        return getValidInputFromUser("Enter the appointment date (YYYY-MM-DD): ", LocalDate::parse);
    }

    // Get valid start time from the user
    private LocalTime getValidStartTimeFromUser() {
        return getValidInputFromUser("Enter the start time (HH:MM): ", LocalTime::parse);
    }

    // Generic method for valid input parsing
    private <T> T getValidInputFromUser(String prompt, java.util.function.Function<String, T> parser) {
        T result = null;
        while (result == null) {
            try {
                System.out.print(prompt);
                result = parser.apply(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input format. Please try again.");
            }
        }
        return result;
    }

    // Overloaded method to handle integer choices with range validation
    private int getValidInputFromUser(String prompt, int min, int max) {
        Integer result = null;
        while (result == null) {
            try {
                System.out.print(prompt);
                result = Integer.parseInt(scanner.nextLine());
                if (result < min || result > max) {
                    System.out.println("Invalid choice. Please enter a number between " + min + " and " + max + ".");
                    result = null;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
            }
        }
        return result;
    }
}
