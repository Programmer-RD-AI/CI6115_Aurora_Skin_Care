# Clinic Management System

## Overview

The **Clinic Management System** (CMS) is a robust software application designed to streamline and automate various aspects of a clinic's operations, such as patient appointments, treatments, invoices, and more. The system features both **Command-Line Interface (CLI)** and **Graphical User Interface (GUI)** views to cater to different user needs, including administrators, doctors, and patients. 

This system helps clinics manage patient data, appointments, treatment details, and billing processes efficiently, ensuring a smooth workflow within the clinic environment.

## Features

- **Appointment Management**: Schedule, view, and manage appointments.
- **Patient Management**: Track patient details, treatments, and medical history.
- **Treatment Management**: Manage treatments offered by the clinic, including creating and viewing treatments.
- **Invoice Management**: Generate, view, and process invoices.
- **Error Handling**: A set of custom exceptions to ensure smooth operation and error-free processing.

## Technologies Used

- **Java**: The primary programming language for the system.
- **Swing**: For creating the GUI (Graphical User Interface) components.
- **CLI**: For the Command-Line Interface (CLI) interaction for users who prefer a terminal-based approach.
- **Exception Handling**: Custom exception classes to manage errors and provide meaningful feedback.

## System Structure

The project is divided into several packages and components, each handling specific tasks or features of the system.

### Main Components

1. **`view.GUI`**: Contains all GUI-based views for the system.
   - `AppointmentGUI.java`: Handles the graphical user interface for managing appointments.
   - `InvoiceGUI.java`: GUI for managing invoices.
   - `MainGUI.java`: The main menu of the Clinic Management System, allowing users to navigate between different features.

2. **`view.CLI`**: Contains all CLI-based views for the system.
   - `AppointmentView.java`: CLI interface for managing appointments.
   - `InvoiceView.java`: CLI interface for handling invoices.
   - `PatientView.java`: CLI interface for managing patient records.
   - `TreatmentView.java`: CLI interface for managing treatments.
   - `TimeView.java`: CLI interface for managing available times and scheduling.

3. **`model`**: Contains the main data models of the system, including `Invoice`, `Appointment`, `Treatment`, and `Patient`.

4. **`exceptions`**: Contains custom exception classes for handling various errors in the system:
   - `AppointmentAlreadyExistsException.java`
   - `AppointmentNotFoundException.java`
   - `InvalidAppointmentTimeException.java`
   - `InvalidAppointmentDataException.java`
   - `InvalidTreatmentIDException.java`
   - `ServiceException.java`

5. **`controller`**: The controller layer which connects the model and the view, and handles the business logic of the system (not mentioned explicitly but typically exists in MVC architecture).

## Installation

### Prerequisites
Make sure you have the following installed on your machine:
- **Java Development Kit (JDK)**: Version 8 or higher.
- **Maven** (Optional for building): If you plan to build the project with Maven.

### Steps

1. **Clone the Repository**:
   Clone this repository to your local machine using the following command:
   ```bash
   git clone https://github.com/yourusername/clinic-management-system.git
   ```

2. **Build the Project** (Optional if using Maven):
   If you're using Maven, run the following command in the project directory to build the project:
   ```bash
   mvn clean install
   ```

3. **Run the Project**:
    - **For GUI**: Navigate to the `view.GUI` package and run the `MainGUI.java` file. This will launch the graphical user interface for the system.
    - **For CLI**: Navigate to the `view.CLI` package and run the appropriate view classes (`AppointmentView`, `InvoiceView`, etc.) to interact with the system via the command line.

## How to Use

### Main Menu (GUI)
Upon running the application, you'll be greeted with the main menu, which provides options to:
- **Manage Appointments**: Allows you to schedule, view, and modify appointments.
- **Manage Invoices**: Lets you generate and view invoices for treatments.
- **Exit**: Closes the application.

### Appointment Management (GUI and CLI)
- **Create Appointment**: Schedule new appointments for patients.
- **View Appointments**: Display scheduled appointments for a given date or patient.
- **Cancel Appointment**: Cancel any upcoming appointment.

### Invoice Management (GUI and CLI)
- **Generate Invoice**: After a treatment, an invoice can be generated based on the services provided.
- **Pay Invoice**: Allows patients to mark an invoice as paid.
- **View Invoice**: Displays a detailed view of an invoice.

### Error Handling
Custom exceptions are thrown in scenarios such as:
- Duplicate appointments (`AppointmentAlreadyExistsException`).
- Invalid appointment data (`InvalidAppointmentDataException`).
- Treatment ID issues (`InvalidTreatmentIDException`).
- Service-related errors (`ServiceException`).

### CLI Interaction
In the CLI views, users will be prompted with a menu system where they can:
- Enter appointment details.
- View patient records.
- Process treatments.
- Generate invoices.

## Exception Handling

The system utilizes a set of custom exceptions for error handling:

- **`AppointmentAlreadyExistsException`**: Thrown when an appointment already exists.
- **`AppointmentNotFoundException`**: Thrown when an appointment cannot be found.
- **`InvalidAppointmentTimeException`**: Thrown when an appointment time is invalid.
- **`InvalidAppointmentDataException`**: Thrown when appointment data is invalid.
- **`InvalidTreatmentIDException`**: Thrown when an invalid treatment ID is provided.
- **`ServiceException`**: A general-purpose exception for system-related errors.

These exceptions provide clear and user-friendly messages to ensure a smooth user experience and aid in debugging.

## Contributing

We welcome contributions to improve and enhance the Clinic Management System! To contribute:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature-name`).
3. Commit your changes (`git commit -am 'Add feature'`).
4. Push to the branch (`git push origin feature-name`).
5. Create a new pull request.

Please make sure to write tests for your contributions and follow the project's code conventions.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Thanks to all contributors for their hard work in making this project successful.
- Special thanks to the community for providing valuable feedback and suggestions.

---

For any issues or questions, feel free to open an issue in the repository or contact the project maintainers.