package controller;

import model.*;
import model.interfaces.Time;
import repository.*;
import service.AppointmentService;
import util.LoggerUtil;
import exception.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controller class that handles the logic for appointment management.
 * It interacts with the AppointmentService to create, update, list, and cancel appointments.
 */
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final Logger logger = LoggerUtil.getInstance().getLogger();

    public AppointmentController() {
        AppointmentRepository appointmentRepository = new AppointmentRepository();
        this.appointmentService = new AppointmentService(appointmentRepository);
    }

    public Appointment createAppointment(Patient patient, DermatologistModel dermatologist, Treatment treatment, Time time, Invoice invoice) {
        try {
            logger.info("Attempting to create appointment for patient: " + patient.getName());
            Appointment appointment = this.appointmentService.createAppointment(patient, dermatologist, treatment, time, invoice);
            logger.info("Appointment created successfully with ID: " + appointment.getAppointmentId());
            return appointment;
        } catch (AppointmentAlreadyExistsException e) {
            logger.log(Level.WARNING, "Appointment already exists for patient: " + patient.getName(), e);
            throw e;  // rethrow after logging
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error creating appointment for patient: " + patient.getName(), e);
            throw new ServiceException("Failed to create appointment");
        }
    }

    public List<Appointment> listAppointments() {
        try {
            logger.info("Fetching all appointments.");
            List<Appointment> appointments = this.appointmentService.getAllAppointments();
            logger.info("Fetched " + appointments.size() + " appointments.");
            return appointments;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error fetching appointments.", e);
            throw new ServiceException("Failed to retrieve appointments");
        }
    }

    public Appointment getAppointmentById(int appointmentId) {
        try {
            logger.info("Fetching appointment with ID: " + appointmentId);
            Appointment appointment = this.appointmentService.getAppointmentById(appointmentId)
                    .orElseThrow(() -> new AppointmentNotFoundException("Appointment not found with ID: " + appointmentId));
            if (appointment == null) {
                throw new AppointmentNotFoundException("Appointment not found with ID: " + appointmentId);
            }
            logger.info("Found appointment with ID: " + appointmentId);
            return appointment;
        } catch (AppointmentNotFoundException e) {
            logger.log(Level.WARNING, "Appointment not found with ID: " + appointmentId, e);
            throw e;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error fetching appointment with ID: " + appointmentId, e);
            throw new ServiceException("Failed to retrieve appointment");
        }
    }

    public boolean updateAppointment(int appointmentId, Patient patient, DermatologistModel dermatologist, Treatment treatment, Time time) {
        try {
            logger.info("Attempting to update appointment with ID: " + appointmentId);
            boolean updated = this.appointmentService.updateAppointment(appointmentId, patient, dermatologist, treatment, time);
            if (updated) {
                logger.info("Successfully updated appointment with ID: " + appointmentId);
            } else {
                logger.log(Level.WARNING, "Failed to update appointment with ID: " + appointmentId);
            }
            return updated;
        } catch (InvalidAppointmentTimeException e) {
            logger.log(Level.WARNING, "Invalid time for appointment update with ID: " + appointmentId, e);
            throw e;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error updating appointment with ID: " + appointmentId, e);
            throw new ServiceException("Failed to update appointment");
        }
    }

    public boolean cancelAppointmentById(int appointmentId) {
        try {
            logger.info("Attempting to cancel appointment with ID: " + appointmentId);
            boolean cancelled = this.appointmentService.cancelAppointmentById(appointmentId);
            if (cancelled) {
                logger.info("Successfully cancelled appointment with ID: " + appointmentId);
            } else {
                logger.log(Level.WARNING, "Failed to cancel appointment with ID: " + appointmentId);
            }
            return cancelled;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error cancelling appointment with ID: " + appointmentId, e);
            throw new ServiceException("Failed to cancel appointment");
        }
    }

    public List<Appointment> getAppointmentsByPatientName(String name) {
        try {
            logger.info("Fetching appointments for patient: " + name);
            List<Appointment> appointments = this.appointmentService.getAppointmentsByPatientName(name);
            logger.info("Fetched " + appointments.size() + " appointments for patient: " + name);
            return appointments;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error fetching appointments for patient: " + name, e);
            throw new ServiceException("Failed to retrieve appointments for patient");
        }
    }
}
