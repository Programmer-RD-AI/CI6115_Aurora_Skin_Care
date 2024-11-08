package model;

import repository.AppointmentRepository;
import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {
    private List<Appointment> appointments; // Store appointments directly, not the repository

    /**
     * Constructs a Patient object with the provided details.
     * @param NIC The National Identity Card number of the patient.
     * @param name The name of the patient.
     * @param email The email address of the patient.
     * @param phoneNumber The phone number of the patient.
     */
    public Patient(int NIC, String name, String email, int phoneNumber) {
        super(NIC, name, email, phoneNumber);
        this.appointments = new ArrayList<>(); // Initialize with an empty list
    }

    /**
     * Adds an appointment to the patient's list of appointments.
     * @param appointment The appointment to be added.
     */
    public void addAppointment(Appointment appointment) {
        if (appointment != null) {
            appointments.add(appointment);
        }
    }

    /**
     * Returns a list of the patient's appointments.
     * @return A list of appointments.
     */
    public List<Appointment> getAppointments() {
        return new ArrayList<>(appointments); // Return a copy to preserve encapsulation
    }

    /**
     * Returns the number of appointments the patient has.
     * @return The number of appointments.
     */
    public int getAppointmentCount() {
        return appointments.size();
    }

    @Override
    public String toString() {
        return "Patient{" +
                "appointments=" + appointments +
                ", name='" + getName() +
                '}';
    }
}
