package view.CLI;

import exception.InvalidTreatmentIDException;

import java.util.Scanner;

public class GeneralView {
    private final Scanner scanner = new Scanner(System.in);
    private final AppointmentView appointmentView = new AppointmentView();

    // Entry point to start the menu loop
    public void start() throws InvalidTreatmentIDException {
        boolean continueRunning = true;

        while (continueRunning) {
            showMainMenu();
            int choice = getUserChoice(1, 3);

            switch (choice) {
                case 1 -> handleAppointmentChoice();
                case 2 -> handleInvoiceChoice();
                case 3 -> {
                    System.out.println("Exiting...");
                    continueRunning = false; // Exit loop
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Display the main menu
    private void showMainMenu() {
        System.out.println("""
                Choose an option:
                1. Appointments
                2. Invoices
                3. Exit
                """);
    }

    // Get a valid choice from the user, ensuring it's within the expected range
    private int getUserChoice(int min, int max) {
        int choice = -1;
        while (choice < min || choice > max) {
            System.out.print("Enter choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();  // Clear the buffer
            } else {
                scanner.nextLine(); // Clear invalid input
                System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
            }
        }
        return choice;
    }

    // Handle the appointment choice
    private void handleAppointmentChoice() throws InvalidTreatmentIDException {
        appointmentView.showAppointmentMenu(); // Call Appointment menu in AppointmentView
    }

    // Handle the invoice choice (for future implementation)
    private void handleInvoiceChoice() {
        System.out.println("Invoice management is currently under development.");
        // Future invoice management logic can be added here
    }
}
