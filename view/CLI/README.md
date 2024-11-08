# CLI Views

This project implements a set of Command-Line Interface (CLI) views for managing different aspects of a clinic's operations. The views provide a simple, structured way to interact with various clinic management functions, including patient management, appointments, invoices, and treatments.

## Classes

### 1. **DermatologistView.java**
**Purpose**: Manages and displays options related to the dermatologist services in the clinic.

**Features**:
- Displays available treatments for dermatology.
- Allows users to view dermatology-related appointments and treatment history.
- Provides options for managing dermatologist-specific records.

**Usage**:
- Run the view to display dermatologist-related actions and interact with the data.

### 2. **AppointmentView.java**
**Purpose**: Manages appointment-related features for patients and doctors.

**Features**:
- Schedule new appointments.
- View, edit, and cancel existing appointments.
- Search appointments by date, patient, or doctor.

**Usage**:
- Users can manage appointments by selecting options to book, view, or cancel appointments.

### 3. **GeneralView.java**
**Purpose**: The general view serves as the main menu of the clinic management system.

**Features**:
- Provides options to navigate to various sections of the clinic management system, such as patient management, invoice management, and treatment options.
- Acts as a central hub for accessing all other views in the system.

**Usage**:
- Once the application starts, this view will present the user with a main menu to choose where they want to go (e.g., appointments, invoices, etc.).

### 4. **InvoiceView.java**
**Purpose**: Handles all invoice-related tasks within the clinic management system.

**Features**:
- View and manage invoices for patients.
- Add new invoice entries for treatments or consultations.
- Mark invoices as paid or unpaid.

**Usage**:
- This view allows users to navigate through invoice actions, view unpaid invoices, and manage billing for services provided by the clinic.

### 5. **PatientView.java**
**Purpose**: Manages patient-related data and actions in the clinic management system.

**Features**:
- View, add, and update patient details (e.g., name, contact, medical history).
- Search and manage patient records.
- View patient treatment history.

**Usage**:
- Use this view to manage patient information, from adding new patients to updating or viewing existing patient records.

### 6. **TreatmentView.java**
**Purpose**: Manages treatment-related actions and records within the system.

**Features**:
- View available treatments in the clinic (e.g., dermatological treatments, general treatments).
- Add and update treatment records for patients.
- Search and filter treatments based on different criteria.

**Usage**:
- Interact with this view to manage treatment options, assign treatments to patients, and track the progress of treatments.

### 7. **TimeView.java**
**Purpose**: Manages time-based features such as scheduling and time slots for appointments and treatments.

**Features**:
- View and manage available time slots for appointments.
- Schedule and edit appointments according to available times.
- Handle time conflicts or overlaps in appointments.

**Usage**:
- Use this view to check available times for appointments and treatments, and ensure that schedules are maintained without conflicts.

## Setup and Usage

1. Clone or download the repository to your local machine.

2. Navigate to the project directory and compile the Java classes using the following command:

    ```bash
    javac *.java
    ```

3. Run the `GeneralView` class to start the application and access the main menu:

    ```bash
    java GeneralView
    ```

4. Use the interactive CLI to navigate through the different views and manage various clinic operations (appointments, invoices, treatments, patients, etc.).

## Contributing

If you'd like to contribute to this project, feel free to fork the repository, make changes, and submit a pull request. Contributions are always welcome to improve the functionality and user experience of the system!

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.