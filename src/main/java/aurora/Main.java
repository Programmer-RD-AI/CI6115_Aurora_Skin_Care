// Main.java
import model.*;
import service.TreatmentService;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        // Create patient and dermatologist
        Patient patient = new Patient("123", "Ranuga", "go2ranuga@gmail.com", 777169804);
        Dermatologist dermatologist = new Dermatologist("456", "Devin", "ranugadisansa@ieee.org", 718024596);

        // Create and add treatment
        Treatment treatment = new Treatment("Acne", 2750.0);
        TreatmentService treatmentService = new TreatmentService();
        treatmentService.addTreatment(treatment);

        // Generate invoice using the treatment list from the service
        Invoice invoice = new Invoice(patient, treatmentService.getTreatmentList());

        // Create appointment using dermatologist, patient, and invoice details
        Appointment appointment = new Appointment(dermatologist, treatmentService.getTreatmentList(), invoice, patient,
                LocalTime.of(10, 0), LocalTime.of(19, 0));
        System.out.println(appointment.getAppointmentID());
        System.out.println(dermatologist.getAvailabilityTracker());
        System.out.println(dermatologist.getTimeAllocations());
        System.out.println("Appointment created successfully.");
        System.out.println("Invoice Details: " + invoice);
    }
}
