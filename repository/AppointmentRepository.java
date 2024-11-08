package repository;

import model.Appointment;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class AppointmentRepository {

    // Use a thread-safe list (CopyOnWriteArrayList) to avoid issues in multi-threaded environments
    private final List<Appointment> appointmentList;

    // Constructor to initialize with existing list or create an empty list
    public AppointmentRepository(List<Appointment> initialAppointmentList) {
        this.appointmentList = new CopyOnWriteArrayList<>(initialAppointmentList);
    }

    public AppointmentRepository() {
        this.appointmentList = new CopyOnWriteArrayList<>();
    }

    // Add a new appointment
    public void addAppointment(Appointment appointment) {
        if (appointment != null) {
            appointmentList.add(appointment);
        }
    }

    // Get all appointments
    public List<Appointment> getAppointments() {
        return appointmentList;
    }

    // Get an appointment by ID using Optional to handle cases where the appointment doesn't exist
    public Optional<Appointment> getAppointmentById(int appointmentId) {
        return appointmentList.stream()
                .filter(appointment -> appointment.getAppointmentId() == appointmentId)
                .findFirst();
    }

    // Delete appointment by ID
    public boolean deleteAppointmentById(int appointmentId) {
        Optional<Appointment> appointmentOptional = getAppointmentById(appointmentId);
        if (appointmentOptional.isPresent()) {
            appointmentList.remove(appointmentOptional.get());
            return true;
        }
        return false;
    }

    // Get appointments by patient's name, case insensitive
    public List<Appointment> getAppointmentsByPatientName(String patientName) {
        if (patientName == null || patientName.isEmpty()) {
            return List.of();
        }

        return appointmentList.stream()
                .filter(a -> a.getPatient().getName().equalsIgnoreCase(patientName))
                .collect(Collectors.toList());
    }
}
