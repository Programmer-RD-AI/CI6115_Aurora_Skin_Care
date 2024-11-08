# Service Layer

This folder contains service classes that encapsulate the business logic of the application. The service layer provides methods to interact with the data layer (repositories) and often implements the core functionalities, validations, and transformations required by the application. It acts as an intermediary between the controller layer (if using MVC) or other parts of the system that require business logic processing.

## Overview

The service layer is responsible for performing operations such as:

- **Creating** new entities or objects.
- **Retrieving** existing data based on specific criteria (e.g., ID, name).
- **Updating** existing data by applying changes.
- **Deleting** data when necessary.
- Ensuring **business rules** are followed, such as checking availability or validating input.

### Example Service Class Structure

Each service class typically follows this structure:

1. **Dependencies**: The service interacts with repositories or other services to retrieve or store data.
2. **Business Logic**: The core of the service, where most of the operations, validations, and business rules reside.
3. **Error Handling**: Any necessary validation, such as ensuring entities are available or meeting certain criteria before proceeding with operations.
4. **Methods**: The service class contains several methods for performing CRUD (Create, Read, Update, Delete) operations and other specific functionality.

## Features

- **CRUD Operations**: Provides methods for creating, reading, updating, and deleting data.
- **Business Rule Validation**: Ensures business logic such as availability checks, data integrity, and other domain-specific rules.
- **Interaction with Repositories**: Communicates with repositories to persist data, fetch entities, or remove them.
- **Error Handling**: Provides clear and concise error messages or returns appropriate status codes to the caller.

## Example Service Class (AppointmentService)

Below is a general structure of a typical service class that might be found in this folder. This example shows how the service could interact with repositories, manage business logic, and handle errors.

```java
package service;

import model.*;
import repository.AppointmentRepository;

import java.util.List;
import java.util.Optional;

public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    // Helper method to check availability before creating an appointment
    private boolean isEntityAvailable(Entity entity, Time time) {
        if (!entity.checkAvailability(time)) {
            System.out.println(entity.getName() + " is not available at the selected time.");
            return false;
        }
        return true;
    }

    // Create a new appointment with validation for availability
    public Appointment createAppointment(Patient patient, Dermatologist dermatologist, Treatment treatment, Time time, Invoice invoice) {
        if (!isEntityAvailable(dermatologist, time)) {
            return null;
        }
        Appointment appointment = new Appointment(patient, dermatologist, treatment, time, invoice);
        appointmentRepository.addAppointment(appointment);
        return appointment;
    }

    // Retrieve an appointment by its ID
    public Optional<Appointment> getAppointmentById(int appointmentId) {
        return appointmentRepository.getAppointmentById(appointmentId);
    }

    // Update an existing appointment with new details
    public boolean updateAppointment(int appointmentId, Patient patient, Dermatologist dermatologist, Treatment treatment, Time time) {
        Optional<Appointment> appointmentOptional = appointmentRepository.getAppointmentById(appointmentId);
        if (appointmentOptional.isEmpty()) {
            System.out.println("Appointment not found.");
            return false;
        }
        Appointment appointment = appointmentOptional.get();

        if (!isEntityAvailable(dermatologist, time)) {
            return false;
        }

        // Update appointment details
        appointment.setPatient(patient);
        appointment.setDermatologist(dermatologist);
        appointment.setTreatment(treatment);
        appointment.setTime(time);
        return true;
    }

    // Cancel an appointment
    public boolean cancelAppointment(int appointmentId) {
        return appointmentRepository.deleteAppointment(appointmentId);
    }

    // Get all appointments
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.getAppointments();
    }

    // Get appointments by patient name
    public List<Appointment> getAppointmentsByPatientName(String name) {
        return appointmentRepository.getAppointmentsByPatientName(name);
    }
}
```