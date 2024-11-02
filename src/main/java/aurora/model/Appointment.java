package model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Appointment {
    private final Dermatologist dermatologist;
    private final Invoice invoice;
    private final Patient patient;
    private final List<Treatment> treatments;
    private final int appointmentID;
    private static int appointmentCounter = 0; // Initialize counter to zero
    private LocalTime startTime;
    private LocalTime endTime;

    public Appointment(Dermatologist dermatologist, List<Treatment> treatments, Invoice invoice, Patient patient, LocalTime startTime, LocalTime endTime) {
        if (dermatologist == null || treatments == null || invoice == null || patient == null) {
            throw new IllegalArgumentException("All parameters must be non-null");
        }
        this.dermatologist = dermatologist;
        this.treatments = Collections.unmodifiableList(new ArrayList<>(treatments)); // Make it immutable
        this.invoice = invoice;
        this.patient = patient;
        this.appointmentID = ++appointmentCounter; // Increment and assign
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Getters
    public List<Treatment> getTreatments() {
        return treatments;
    }

    public Dermatologist getDermatologist() {
        return dermatologist;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public Patient getPatient() {
        return patient;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentID=" + appointmentID +
                ", patient=" + patient.getName() +
                ", dermatologist=" + dermatologist.getName() +
                ", treatments=" + treatments.size() +
                '}';
    }
}
