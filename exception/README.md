# Exception Handling

This project uses a series of custom exception classes to handle various error scenarios in the Clinic Management System. These exceptions are designed to provide clear and specific error messages when something goes wrong during appointment scheduling, treatment handling, or general system errors.

## Exception Classes

### 1. **AppointmentAlreadyExistsException.java**
   **Purpose**: This exception is thrown when an attempt is made to create an appointment that already exists in the system (e.g., a duplicate appointment for the same patient at the same time).

   **Usage**:
   - This exception ensures that the clinic staff cannot double-book appointments, which could lead to conflicts in the schedule and patient dissatisfaction.
   - It is thrown when checking if an appointment already exists before scheduling a new one.

   **Example**:
   ```java
   if (appointmentExists(patientId, appointmentTime)) {
       throw new AppointmentAlreadyExistsException("An appointment already exists for this patient at the selected time.");
   }
   ```

### 2. **AppointmentNotFoundException.java**
**Purpose**: This exception is thrown when an appointment cannot be found in the system.

**Usage**:
- This exception is useful when attempting to view, update, or cancel an appointment that does not exist in the system.
- It helps avoid errors or inconsistencies when performing actions on non-existing appointments.

**Example**:
   ```java
   if (!appointmentExists(appointmentId)) {
       throw new AppointmentNotFoundException("Appointment with the given ID does not exist.");
   }
   ```

### 3. **InvalidAppointmentTimeException.java**
**Purpose**: This exception is thrown when the scheduled appointment time is invalid (e.g., a time in the past, a time outside clinic hours, or overlapping with another appointment).

**Usage**:
- This ensures that appointments are scheduled during valid time slots and within clinic working hours.
- It is thrown if an appointment time is not within acceptable parameters (e.g., outside of the clinic's operating hours).

**Example**:
   ```java
   if (!isValidAppointmentTime(appointmentTime)) {
       throw new InvalidAppointmentTimeException("The selected appointment time is invalid.");
   }
   ```

### 4. **InvalidAppointmentDataException.java**
**Purpose**: This exception is thrown when the provided appointment data is invalid (e.g., missing patient details, invalid doctor selection, or incomplete information).

**Usage**:
- This exception helps ensure that all necessary data is provided for appointment creation.
- It is thrown when required fields like patient ID, doctor, or time are missing or incorrectly formatted.

**Example**:
   ```java
   if (appointmentDataIsInvalid(appointment)) {
       throw new InvalidAppointmentDataException("The appointment data provided is incomplete or invalid.");
   }
   ```

### 5. **InvalidTreatmentIDException.java**
**Purpose**: This exception is thrown when an invalid treatment ID is provided (e.g., attempting to apply a treatment that does not exist).

**Usage**:
- This ensures that only valid treatments are associated with appointments or patient records.
- It is used when the system cannot find a treatment matching the provided ID.

**Example**:
   ```java
   if (!isValidTreatmentID(treatmentId)) {
       throw new InvalidTreatmentIDException("The treatment ID provided does not exist.");
   }
   ```

### 6. **ServiceException.java**
**Purpose**: This general-purpose exception is used to handle any other errors related to the service layer, such as database errors, network issues, or unexpected failures that do not fit into more specific exceptions.

**Usage**:
- This is a catch-all exception for errors that occur during interactions with external systems or critical operations like saving or fetching data from the database.
- It helps in identifying issues that are not related to specific input or data validation but rather to system failures or unhandled scenarios.

**Example**:
   ```java
   try {
       // Service operation
   } catch (Exception e) {
       throw new ServiceException("An unexpected error occurred while processing the service operation.", e);
   }
   ```

## Exception Hierarchy and Customization

All of the above exceptions extend from `Exception` or a custom base class, allowing you to catch specific exceptions or handle all of them at once using generic exception handling mechanisms.

### Customizing Exceptions:
Each exception class is designed to provide a detailed error message that can be passed to the constructor when throwing the exception. These messages can be customized based on the specific error scenario to provide clear feedback to the user or developer.

## Example Usage

### Throwing Exceptions:
You can throw these exceptions in relevant methods like so:
```java
public void createAppointment(Appointment appointment) throws AppointmentAlreadyExistsException, InvalidAppointmentTimeException {
    if (appointmentExists(appointment)) {
        throw new AppointmentAlreadyExistsException("This appointment already exists.");
    }
    if (!isValidAppointmentTime(appointment.getTime())) {
        throw new InvalidAppointmentTimeException("The appointment time is invalid.");
    }
}
```

### Catching Exceptions:
You can handle the exceptions in the calling methods to gracefully manage errors:
```java
try {
    appointmentService.createAppointment(newAppointment);
} catch (AppointmentAlreadyExistsException e) {
    System.out.println(e.getMessage());
} catch (InvalidAppointmentTimeException e) {
    System.out.println(e.getMessage());
} catch (Exception e) {
    // Handle generic errors
}
```

## Benefits of Using Custom Exceptions:
- **Clarity**: Each exception clearly communicates the problem with specific error messages.
- **Maintainability**: By using custom exceptions, we can easily modify how exceptions are handled without affecting other parts of the system.
- **User Experience**: Provides better feedback and control over the clinic management system, ensuring smooth and efficient operation.

## Conclusion

This exception handling mechanism is essential for ensuring the clinic management system runs smoothly without running into issues caused by invalid data or operations. It makes the system robust by providing clear error handling and user-friendly messages, allowing for better debugging and system maintenance.