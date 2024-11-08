package model;

import model.interfaces.Time;
import java.util.Objects;
import java.util.logging.Logger;

public class Appointment {
    private static final Logger logger = Logger.getLogger(Appointment.class.getName());
    private static int idCounter = 0;
    private final int appointmentId;
    private Patient patient;
    private DermatologistModel dermatologist;
    private Treatment treatment;
    private Time time;
    private Invoice invoice;
    private String status;

    // Constants for statuses to avoid hardcoded strings
    public static final String STATUS_SCHEDULED = "SCHEDULED";
    public static final String STATUS_COMPLETED = "COMPLETED";
    public static final String STATUS_CANCELLED = "CANCELLED";

    /**
     * Constructor to create a new appointment.
     * @param patient the patient for the appointment (must not be null)
     * @param dermatologist the dermatologist for the appointment (must not be null)
     * @param treatment the treatment for the appointment (must not be null)
     * @param time the time for the appointment (must not be null)
     * @param invoice the invoice associated with the appointment (must not be null)
     * @throws IllegalArgumentException if any required parameter is null
     */
    public Appointment(Patient patient, DermatologistModel dermatologist, Treatment treatment, Time time, Invoice invoice) {
        // Validate non-null parameters
        this.appointmentId = ++idCounter;
        this.patient = Objects.requireNonNull(patient, "Patient must not be null");
        this.dermatologist = Objects.requireNonNull(dermatologist, "Dermatologist must not be null");
        this.treatment = Objects.requireNonNull(treatment, "Treatment must not be null");
        this.time = Objects.requireNonNull(time, "Time must not be null");
        this.invoice = Objects.requireNonNull(invoice, "Invoice must not be null");

        this.status = STATUS_SCHEDULED; // Default status is SCHEDULED

        logger.info("Appointment created with ID: " + appointmentId + " for patient: " + patient.getName());
    }

    // Getter and Setter methods

    public int getAppointmentId() {
        return appointmentId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = Objects.requireNonNull(patient, "Patient must not be null");
        logger.info("Patient set for appointment ID: " + appointmentId);
    }

    public DermatologistModel getDermatologist() {
        return dermatologist;
    }

    public void setDermatologist(DermatologistModel dermatologist) {
        this.dermatologist = Objects.requireNonNull(dermatologist, "Dermatologist must not be null");
        logger.info("Dermatologist set for appointment ID: " + appointmentId);
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = Objects.requireNonNull(treatment, "Treatment must not be null");
        logger.info("Treatment set for appointment ID: " + appointmentId);
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = Objects.requireNonNull(time, "Time must not be null");
        logger.info("Time set for appointment ID: " + appointmentId);
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = Objects.requireNonNull(invoice, "Invoice must not be null");
        logger.info("Invoice set for appointment ID: " + appointmentId);
    }

    public String getStatus() {
        return status;
    }

    /**
     * Set the status of the appointment. Valid statuses are "SCHEDULED", "COMPLETED", "CANCELLED".
     * @param status the status of the appointment
     * @throws IllegalArgumentException if the status is invalid
     */
    public void setStatus(String status) {
        if (status == null || (!status.equals(STATUS_SCHEDULED) && !status.equals(STATUS_COMPLETED) && !status.equals(STATUS_CANCELLED))) {
            throw new IllegalArgumentException("Invalid status: " + status);
        }
        this.status = status;
        logger.info("Status set to " + status + " for appointment ID: " + appointmentId);
    }

    @Override
    public String toString() {
        return String.format("Appointment{id=%d, patient=%s, dermatologist=%s, treatment=%s, time=%s, invoice=%s, status='%s'}",
                appointmentId, patient.getName(), dermatologist.getName(), treatment.getTreatmentID(), time, invoice, status);
    }
}
