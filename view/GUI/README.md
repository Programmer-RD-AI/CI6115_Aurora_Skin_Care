# Clinic Management System - GUI Views

This project provides a graphical user interface (GUI) for managing various aspects of a clinic's operations. The views include functionalities for managing appointments, invoices, and the main menu of the clinic management system. The application is built using Java Swing, which offers an intuitive interface for clinic staff to interact with different modules.

## Classes

### 1. **AppointmentGUI.java**
**Purpose**: Manages the appointment-related functionalities in the clinic.

**Features**:
- **View Appointments**: Displays a list of scheduled appointments, with options to view detailed information.
- **Schedule Appointment**: Allows users to create new appointments by selecting a patient, doctor, and preferred time slot.
- **Cancel Appointment**: Provides an option to cancel existing appointments.
- **Search Appointments**: Allows users to search for specific appointments based on patient name, date, or doctor.

**Usage**:
- This GUI allows clinic staff to manage patient appointments effectively. It provides an interface to view, schedule, and cancel appointments, making appointment management efficient.

### 2. **InvoiceGUI.java**
**Purpose**: Manages the invoice-related operations within the clinic management system.

**Features**:
- **View Invoices**: Displays a list of all invoices, including those that are paid or unpaid.
- **Pay Invoice**: Provides functionality to mark invoices as paid after receiving payments from patients.
- **Generate New Invoice**: Allows clinic staff to create new invoices for treatments or consultations.
- **Search Invoices**: Search for invoices by patient name, date, or status.

**Usage**:
- Use this GUI to manage invoices in the clinic, including viewing unpaid invoices, marking them as paid, and generating new invoices for services rendered.

### 3. **MainGUI.java**
**Purpose**: The main menu view that serves as the entry point for users to navigate the clinic management system.

**Features**:
- **Manage Appointments**: Redirects to the `AppointmentGUI` for managing appointments.
- **Manage Invoices**: Redirects to the `InvoiceGUI` for managing invoices.
- **Exit**: Closes the application.

**Usage**:
- This view is the main dashboard of the clinic management system. It offers an easy interface for users to access the appointment management and invoice management modules. From this screen, users can choose to manage appointments, view and pay invoices, or exit the application.

## Setup and Usage

1. **Clone the repository** to your local machine using the following command:

    ```bash
    git clone <repository_url>
    ```

2. **Navigate to the project directory** and compile the Java classes using:

    ```bash
    javac *.java
    ```

3. **Run the MainGUI** to launch the clinic management system:

    ```bash
    java MainGUI
    ```

4. The **MainGUI** will launch, and you will have options to either:
    - **Manage Appointments**: This will open the `AppointmentGUI` where you can manage appointments.
    - **Manage Invoices**: This will open the `InvoiceGUI` to manage invoice-related tasks.
    - **Exit**: Close the application.

5. Follow the on-screen prompts to perform actions like viewing or scheduling appointments, paying invoices, and more.
