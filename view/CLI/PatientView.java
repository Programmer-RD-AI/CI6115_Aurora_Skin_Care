package view.CLI;

import model.Patient;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatientView {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Gathers information about a patient and returns a Patient object.
     * @return A Patient object containing the input data.
     */
    public Patient getPatientDetails() {
        int NIC = getValidNIC();
        String name = getValidName();
        String email = getValidEmail();
        int phoneNumber = getValidPhoneNumber();

        // Create and return a Patient object using the gathered details
        return new Patient(NIC, name, email, phoneNumber);
    }

    // Method to get a valid NIC (National Identity Card) number
    private int getValidNIC() {
        int NIC = -1;
        while (NIC <= 0) {
            System.out.print("Enter patient NIC: ");
            if (scanner.hasNextInt()) {
                NIC = scanner.nextInt();
                if (NIC <= 0) {
                    System.out.println("NIC should be a positive number. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid NIC number.");
                scanner.nextLine(); // Consume invalid input
            }
        }
        scanner.nextLine(); // Consume newline after valid input
        return NIC;
    }

    // Method to get a valid patient name
    private String getValidName() {
        String name;
        while (true) {
            System.out.print("Enter patient name: ");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty. Please enter a valid name.");
            } else {
                break;
            }
        }
        return name;
    }

    // Method to get a valid email address
    private String getValidEmail() {
        String email;
        while (true) {
            System.out.print("Enter patient email: ");
            email = scanner.nextLine().trim();
            if (isValidEmail(email)) {
                break;
            } else {
                System.out.println("Invalid email format. Please try again.");
            }
        }
        return email;
    }

    // Helper method to validate email format using regular expression
    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Method to get a valid phone number
    private int getValidPhoneNumber() {
        int phoneNumber = -1;
        while (phoneNumber <= 0) {
            System.out.print("Enter patient phone number: ");
            if (scanner.hasNextInt()) {
                phoneNumber = scanner.nextInt();
                if (phoneNumber <= 0) {
                    System.out.println("Phone number must be a positive number. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid phone number.");
                scanner.nextLine(); // Consume invalid input
            }
        }
        scanner.nextLine(); // Consume newline after valid input
        return phoneNumber;
    }
}
