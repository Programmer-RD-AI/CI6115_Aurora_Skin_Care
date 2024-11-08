package service;

import model.*;
import model.interfaces.Time;
import repository.AppointmentRepository;

import java.util.List;
import java.util.Optional;

public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    // Helper method to check availability and create an appointment
    private boolean isDermatologistAvailable(DermatologistModel dermatologist, Time time) {
        if (!dermatologist.checkAvailability(time)) {
            System.out.println("Dermatologist not available at the chosen time.");
            return false;
        }
        return true;
    }

    // Create a new appointment if the dermatologist is available at the selected time
    public Appointment createAppointment(Patient patient, DermatologistModel dermatologist, Treatment treatment, Time time, Invoice invoice) {
        if (!isDermatologistAvailable(dermatologist, time)) {
            return null;
        }
        Appointment appointment = new Appointment(patient, dermatologist, treatment, time, invoice);
        appointmentRepository.addAppointment(appointment);
        dermatologist.addTimeSlot(time);
        return appointment;
    }

    // Retrieve an appointment by ID (returns Optional for better error handling)
    public Optional<Appointment> getAppointmentById(int appointmentId) {
        return appointmentRepository.getAppointmentById(appointmentId);
    }

    // Update an existing appointment if it's found and the dermatologist is available at the new time
    public boolean updateAppointment(int appointmentId, Patient patient, DermatologistModel dermatologist, Treatment treatment, Time time) {
        Optional<Appointment> appointmentOptional = appointmentRepository.getAppointmentById(appointmentId);
        if (appointmentOptional.isEmpty()) {
            System.out.println("Appointment not found.");
            return false;
        }
        Appointment appointment = appointmentOptional.get();

        // Check if the dermatologist is available at the new time
        if (!isDermatologistAvailable(dermatologist, time)) {
            return false;
        }

        // Update the appointment details
        appointment.setPatient(patient);
        appointment.setDermatologist(dermatologist);
        appointment.setTreatment(treatment);
        appointment.setTime(time);
        appointment.setInvoice(new Invoice(0, treatment)); // You may want to adjust this invoice creation logic
        return true;
    }

    // Cancel an appointment by its ID
    public boolean cancelAppointmentById(int appointmentId) {
        return appointmentRepository.deleteAppointmentById(appointmentId);
    }

    // Retrieve all appointments
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.getAppointments();
    }

    // Retrieve appointments by patient name
    public List<Appointment> getAppointmentsByPatientName(String name) {
        return appointmentRepository.getAppointmentsByPatientName(name);
    }
}
