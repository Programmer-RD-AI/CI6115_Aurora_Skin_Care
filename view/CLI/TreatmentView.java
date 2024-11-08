package view.CLI;

import exception.InvalidTreatmentIDException;
import model.Treatment;
import model.enums.TreatmentType;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TreatmentView {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Displays available treatment types and gathers information based on treatment ID to return a Treatment object.
     * @return A Treatment object containing the selected treatment's data.
     */
    public Treatment getTreatmentDetails() throws InvalidTreatmentIDException {
        displayAvailableTreatments();

        int treatmentID = getValidTreatmentID();

        // Retrieve the selected treatment type by its ID
        TreatmentType selectedTreatmentType = TreatmentType.getByTreatmentID(treatmentID);
        if (selectedTreatmentType == null) {
            System.out.println("Invalid treatment ID. Please try again.");
            return getTreatmentDetails(); // Retry if the ID is invalid
        }

        // Create and return a Treatment object using the selected TreatmentType
        return new Treatment(selectedTreatmentType.getTreatmentID());
    }

    /**
     * Displays the list of available treatments to the user.
     */
    private void displayAvailableTreatments() {
        System.out.println("Available Treatments:");
        for (TreatmentType treatmentType : TreatmentType.values()) {
            System.out.printf("%d. %s - %.2f\n", treatmentType.getTreatmentID(), treatmentType.getName(), treatmentType.getPrice());
        }
    }

    /**
     * Prompts the user for a valid treatment ID and returns it.
     * @return The treatment ID entered by the user.
     */
    private int getValidTreatmentID() {
        int treatmentID = -1;
        boolean validInput = false;

        // Loop until valid input is provided
        while (!validInput) {
            System.out.print("Enter treatment ID to select a treatment: ");
            try {
                treatmentID = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (TreatmentType.getByTreatmentID(treatmentID) != null) {
                    validInput = true; // Valid treatment ID
                } else {
                    System.out.println("Invalid treatment ID. Please try again.");
                }
            } catch (InputMismatchException | InvalidTreatmentIDException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume invalid input
            }
        }

        return treatmentID;
    }
}
