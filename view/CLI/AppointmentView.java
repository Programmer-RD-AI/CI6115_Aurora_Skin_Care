package view.CLI;

import controller.AppointmentController;
import exception.InvalidTreatmentIDException;
import model.*;
import model.enums.Dermatologist;
import model.interfaces.Time;

import java.util.List;
import java.util.Scanner;

public class AppointmentView {
    private final Scanner scanner = new Scanner(System.in);
    private final AppointmentController appointmentController = new AppointmentController();
    private final PatientView patientView = new PatientView();
    private final DermatologistView dermatologistView = new DermatologistView();
    private final TreatmentView treatmentView = new TreatmentView();
    private final TimeView timeView = new TimeView();
    private final InvoiceView invoiceView = new InvoiceView();

    public void showAppointmentMenu() throws InvalidTreatmentIDException {
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1 -> scheduleAppointment();
                case 2 -> viewAllAppointments();
                case 3 -> updateAppointment();
                case 4 -> cancelAppointment();
                case 5 -> completeAppointment();
                case 6 -> searchAppointment();
                case 7 -> {
                    System.out.println("Returning to Main Menu...");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("""
                Appointment Management:
                1. Schedule Appointment
                2. View All Appointments
                3. Update Appointment
                4. Cancel Appointment
                5. Complete Appointment
                6. Search Appointment
                7. Back to Main Menu
                """);
    }

    private int getUserChoice() {
        System.out.print("Enter choice: ");
        return scanner.nextInt();
    }

    private void scheduleAppointment() throws InvalidTreatmentIDException {
        System.out.println("Scheduling appointment...");
        Patient patient = patientView.getPatientDetails();
        DermatologistModel dermatologist = dermatologistView.selectDermatologist();
        Treatment treatment = treatmentView.getTreatmentDetails();
        Time time = timeView.getTimeDetails(dermatologist);
        Invoice invoice = invoiceView.getInvoiceDetails(treatment);

        System.out.println(dermatologist.checkAvailability(time));

        Appointment appointment = appointmentController.createAppointment(patient, dermatologist, treatment, time, invoice);
        if (appointment != null) {
            System.out.println("Appointment successfully scheduled: " + appointment);
        } else {
            System.out.println("Failed to schedule appointment. The dermatologist may be unavailable at the selected time.");
        }
    }

    private void viewAllAppointments() {
        System.out.println("Viewing all appointments...");
        List<Appointment> appointments = appointmentController.listAppointments();
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
        } else {
            appointments.forEach(System.out::println);
        }
    }

    private void updateAppointment() throws InvalidTreatmentIDException {
        System.out.println("Updating an appointment...");
        viewAllAppointments();

        System.out.print("Enter the ID of the appointment you want to update: ");
        int appointmentId = getUserChoice();

        Appointment appointment = appointmentController.getAppointmentById(appointmentId);
        if (appointment == null) {
            System.out.println("Appointment not found.");
            return;
        }

        System.out.println("Updating details for appointment ID: " + appointmentId);
        Patient patient = patientView.getPatientDetails();
        DermatologistModel dermatologist = dermatologistView.selectDermatologist();
        Treatment treatment = treatmentView.getTreatmentDetails();
        Time time = timeView.getTimeDetails(dermatologist);

        boolean updated = appointmentController.updateAppointment(appointment.getAppointmentId(), patient, dermatologist, treatment, time);
        if (updated) {
            System.out.println("Appointment updated successfully.");
        } else {
            System.out.println("Failed to update the appointment. Please try again.");
        }
    }

    private void cancelAppointment() {
        System.out.println("Cancelling an appointment...");
        viewAllAppointments();

        System.out.print("Enter the ID of the appointment to cancel: ");
        int appointmentId = getUserChoice();

        boolean cancelled = appointmentController.cancelAppointmentById(appointmentId);
        if (cancelled) {
            System.out.println("Appointment cancelled successfully.");
        } else {
            System.out.println("Failed to cancel the appointment. It may not exist.");
        }
    }

    private void completeAppointment() {
        System.out.println("Completing an appointment...");
        viewAllAppointments();

        System.out.print("Enter the ID of the appointment to complete: ");
        int appointmentId = getUserChoice();

        Appointment appointment = appointmentController.getAppointmentById(appointmentId);
        if (appointment == null) {
            System.out.println("Appointment not found.");
            return;
        }

        Invoice invoice = appointment.getInvoice();
        if (appointment.getStatus().equals("Completed") || invoice.isPaid()) {
            System.out.println("Appointment already completed.");
            return;
        }

        processInvoicePayment(appointment, invoice);
    }

    private void processInvoicePayment(Appointment appointment, Invoice invoice) {
        if (!invoice.isPaid()) {
            System.out.println("Invoice outstanding balance: " + (invoice.getTotalAmount()-invoice.getAmountPaid()));
            System.out.print("Enter amount to pay: ");
            double paymentAmount = scanner.nextDouble();
            scanner.nextLine();  // Clear the buffer

            invoice.makePayment(paymentAmount);
            if (invoice.isPaid()) {
                appointment.setStatus("Completed");
                System.out.println("Invoice fully paid. Appointment marked as complete.");
            } else {
                System.out.println("Partial payment made. Outstanding balance: " + (invoice.getTotalAmount()-invoice.getAmountPaid()));
            }
        } else {
            System.out.println("Appointment has already been fully paid and marked as complete.");
        }
    }

    private void searchAppointment() {
        System.out.println("Search Appointment by:");
        System.out.println("1. Appointment ID");
        System.out.println("2. Patient Name");
        System.out.print("Enter choice: ");
        int choice = getUserChoice();

        List<Appointment> results = null;
        switch (choice) {
            case 1 -> {
                System.out.print("Enter Appointment ID: ");
                int appointmentId = getUserChoice();
                Appointment appointment = appointmentController.getAppointmentById(appointmentId);
                if (appointment != null) {
                    results = List.of(appointment);
                }
            }
            case 2 -> {
                System.out.print("Enter Patient Name: ");
                String patientName = scanner.nextLine();
                results = appointmentController.getAppointmentsByPatientName(patientName);
            }
            default -> System.out.println("Invalid choice. Please try again.");
        }

        if (results == null || results.isEmpty()) {
            System.out.println("No matching appointments found.");
        } else {
            results.forEach(System.out::println);
        }
    }
}
