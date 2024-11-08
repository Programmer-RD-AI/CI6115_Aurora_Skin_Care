# Controller Folder

This folder contains the **AppointmentController** class, which is responsible for managing the lifecycle of appointments within the application. It serves as a middle layer between the user interface (UI) and the underlying service and repository layers, facilitating operations like creating, updating, listing, and canceling appointments.

## `AppointmentController.java`

The `AppointmentController` class provides an interface for managing appointments in the application. It primarily facilitates interaction between the UI layer and the service/repository layers, ensuring that business logic and data access are properly separated.

### Key Responsibilities:
- **Creating Appointments**: The controller allows users to create new appointments by associating patients, dermatologists, treatments, times, and invoices.
- **Listing Appointments**: It provides functionality to list all appointments stored in the system.
- **Retrieving Appointments by ID**: Allows for retrieving specific appointments by their unique ID.
- **Updating Appointments**: Enables the updating of existing appointments, modifying details such as the patient, dermatologist, treatment, and time.
- **Canceling Appointments**: Allows cancellation of appointments based on their ID.
- **Filtering Appointments by Patient Name**: Provides functionality to filter and retrieve appointments associated with a specific patient by name.

### Dependencies:
- **AppointmentService**: This class handles the business logic related to appointment creation, retrieval, updating, and cancellation.
- **AppointmentRepository**: Responsible for data persistence, managing how appointments are stored and retrieved.
- **Model Classes**: The controller interacts with model classes such as `Patient`, `DermatologistModel`, `Treatment`, `Time`, and `Invoice`.

### Constructor:

```java
public AppointmentController() {
    AppointmentRepository appointmentRepository = new AppointmentRepository();
    this.appointmentService = new AppointmentService(appointmentRepository);
}
```

This constructor initializes the necessary dependencies: `AppointmentRepository` for data persistence and `AppointmentService` for managing business logic.

### Methods:

#### `createAppointment`

```java
public Appointment createAppointment(Patient patient, DermatologistModel dermatologist, Treatment treatment, Time time, Invoice invoice)
```

Creates a new appointment using the provided patient, dermatologist, treatment, time, and invoice details.

#### `listAppointments`

```java
public List<Appointment> listAppointments()
```

Retrieves a list of all appointments stored in the system.

#### `getAppointmentById`

```java
public Appointment getAppointmentById(int appointmentId)
```

Retrieves an appointment by its unique ID.

#### `updateAppointment`

```java
public boolean updateAppointment(int appointmentId, Patient patient, DermatologistModel dermatologist, Treatment treatment, Time time)
```

Updates the details of an existing appointment.

#### `cancelAppointmentById`

```java
public boolean cancelAppointmentById(int appointmentId)
```

Cancels an appointment by its ID.

#### `getAppointmentsByPatientName`

```java
public List<Appointment> getAppointmentsByPatientName(String name)
```

Retrieves all appointments associated with a given patient's name.

## Folder Structure

```plaintext
controller/
│
├── AppointmentController.java  # Main controller for managing appointments
```

## Usage

The `AppointmentController` is typically used within the application's service or UI layers. It interacts with both the repository and service layers, ensuring the separation of concerns by maintaining distinct roles for business logic and data access.

### Example Usage:

```java
AppointmentController appointmentController = new AppointmentController();
Patient patient = new Patient("John Doe");
DermatologistModel dermatologist = new DermatologistModel("Dr. Smith");
Treatment treatment = new Treatment("Acne Treatment");
Time time = new Time("2024-11-10 10:00");
Invoice invoice = new Invoice(100.0);

Appointment newAppointment = appointmentController.createAppointment(patient, dermatologist, treatment, time, invoice);
```

This example demonstrates how to create a new appointment using the `AppointmentController`.

## Future Enhancements

- **Error Handling**: Extend the controller to handle and report errors more effectively.
- **Validation**: Implement input validation to ensure appointment details are accurate and complete before creation or updating.
- **Logging**: Add logging for better traceability and debugging.
- **Extensibility**: The `AppointmentController` can serve as a template for creating additional controllers to manage other functionalities of the application. For example, controllers for managing patients, dermatologists, treatments, invoices, or scheduling can be added to the `controller` folder. By following a similar structure, you can expand the application's functionality while maintaining clear separation of concerns, making the system modular and scalable.
