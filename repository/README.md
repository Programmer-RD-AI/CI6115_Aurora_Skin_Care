# Repository Package

This package contains classes for managing various entities in a healthcare management system. It includes repositories for managing patients, appointments, dermatologists' schedules, and invoices. Each repository provides basic CRUD (Create, Read, Update, Delete) operations and ensures thread safety where applicable.

## Classes

### 1. **`AppointmentRepository`**
Manages the appointments of patients. It supports adding, retrieving, deleting, and searching appointments.

#### Constructor(s):
- `AppointmentRepository(List<Appointment> initialAppointmentList)` - Initializes the repository with an existing list of appointments.
- `AppointmentRepository()` - Initializes the repository with an empty list of appointments.

#### Methods:
- `void addAppointment(Appointment appointment)` - Adds a new appointment to the list.
- `List<Appointment> getAppointments()` - Retrieves all appointments.
- `Optional<Appointment> getAppointmentById(int appointmentId)` - Retrieves an appointment by its ID, returning an empty `Optional` if not found.
- `boolean deleteAppointmentById(int appointmentId)` - Deletes an appointment by its ID. Returns `true` if successful, otherwise `false`.
- `List<Appointment> getAppointmentsByPatientName(String patientName)` - Retrieves all appointments for a specific patient (case-insensitive).

### 2. **`DermatologistRepository`**
Manages dermatologists' schedules. It supports adding time slots, checking availability, and retrieving available time slots for each dermatologist.

#### Constructor(s):
- `DermatologistRepository()` - Initializes the repository with default dermatologist schedules.

#### Methods:
- `boolean isTimeSlotAvailable(Dermatologist dermatologist, Time time)` - Checks if the given time slot is available for the specified dermatologist.
- `boolean addTimeSlot(Dermatologist dermatologist, Time time)` - Adds a time slot for a dermatologist if it's available.
- `List<Time> getSchedule(Dermatologist dermatologist)` - Retrieves the available time slots for the given dermatologist.
- `void clearSchedule()` - Clears all schedules (useful for testing or resetting the repository).

### 3. **`InvoiceRepository`**
Manages invoices for patients. It supports adding, deleting, and retrieving invoices.

#### Constructor(s):
- `InvoiceRepository(List<Invoice> invoiceList)` - Initializes the repository with an existing list of invoices.
- `InvoiceRepository()` - Initializes the repository with an empty list of invoices.

#### Methods:
- `void addInvoice(Invoice invoice)` - Adds a new invoice to the list.
- `void deleteInvoice(Invoice invoice)` - Deletes an invoice by object reference.
- `void deleteInvoiceByIndex(int idx)` - Deletes an invoice by index.
- `List<Invoice> getInvoiceList()` - Retrieves an unmodifiable list of invoices.
- `Invoice getInvoiceByIndex(int idx)` - Retrieves an invoice by its index.
- `int getInvoiceCount()` - Retrieves the total number of invoices.

### 4. **`PatientRepository`**
Manages patients. It supports adding, deleting, and retrieving patients.

#### Constructor(s):
- `PatientRepository(List<Patient> initialPatientList)` - Initializes the repository with an existing list of patients.
- `PatientRepository()` - Initializes the repository with an empty list of patients.

#### Methods:
- `boolean addPatient(Patient patient)` - Adds a new patient to the list if they are not already present.
- `boolean existPatient(Patient patient)` - Checks if a patient exists in the list.
- `Patient getPatient(int patientIdx)` - Retrieves a patient by their index.
- `void deletePatient(Patient patient)` - Deletes a patient by object reference.
- `List<Patient> getPatientList()` - Retrieves an unmodifiable list of patients.
- `int getPatientCount()` - Retrieves the total number of patients.

## Notes:
- All repositories ensure thread-safety where needed, such as `AppointmentRepository` using a `CopyOnWriteArrayList` and `DermatologistRepository` using a `ConcurrentHashMap`.
- Optional methods like `clearSchedule()` or `getPatientCount()` are included for more advanced usage scenarios or testing purposes.

## Dependencies:
- The `AppointmentRepository`, `DermatologistRepository`, `InvoiceRepository`, and `PatientRepository` classes rely on models from the `model` package. Make sure the `Appointment`, `Dermatologist`, `Invoice`, `Patient`, and related model classes are implemented and imported correctly in your project.

## Example Usage:

```java
// Create a repository for appointments
AppointmentRepository appointmentRepo = new AppointmentRepository();

// Add a new appointment
Appointment appointment = new Appointment(1, "John Doe", "2024-11-09 10:00");
appointmentRepo.addAppointment(appointment);

// Get all appointments
List<Appointment> appointments = appointmentRepo.getAppointments();

// Check if a time slot is available for a dermatologist
DermatologistRepository dermatologistRepo = new DermatologistRepository();
boolean isAvailable = dermatologistRepo.isTimeSlotAvailable(Dermatologist.DERMATOLOGIST_A, new Time(10, 0));

// Add a time slot for a dermatologist
dermatologistRepo.addTimeSlot(Dermatologist.DERMATOLOGIST_A, new Time(10, 0));
```