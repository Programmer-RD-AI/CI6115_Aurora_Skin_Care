//package view.GUI;
//
//import javax.swing.*;
//import java.awt.*;
//import java.time.LocalDate;
//import java.time.LocalTime;
//
//import controller.AppointmentController;
//import exception.InvalidTreatmentIDException;
//import model.*;
//import model.enums.Dermatologist;
//import model.enums.TreatmentType;
//import model.interfaces.Time;
//
//public class AppointmentGUI {
//    private final AppointmentController appointmentController = new AppointmentController();
//
//    public void showAppointmentMenu() {
//        JFrame frame = new JFrame("Appointment Management");
//        frame.setSize(400, 300);
//        frame.setLocationRelativeTo(null);
//        JPanel panel = new JPanel(new GridLayout(5, 1));
//
//        JButton scheduleButton = new JButton("Schedule Appointment");
//        JButton viewButton = new JButton("View All Appointments");
//        JButton updateButton = new JButton("Update Appointment");
//        JButton cancelButton = new JButton("Cancel Appointment");
//        JButton backButton = new JButton("Back to Main Menu");
//
//        scheduleButton.addActionListener(e -> scheduleAppointment());
//        viewButton.addActionListener(e -> viewAllAppointments());
//        updateButton.addActionListener(e -> updateAppointment());
//        cancelButton.addActionListener(e -> cancelAppointment());
//        backButton.addActionListener(e -> frame.dispose());
//
//        panel.add(scheduleButton);
//        panel.add(viewButton);
//        panel.add(updateButton);
//        panel.add(cancelButton);
//        panel.add(backButton);
//        frame.add(panel);
//        frame.setVisible(true);
//    }
//
//    private void scheduleAppointment() {
//        DermatologistModel dermatologist = selectDermatologistGUI();
//        if (dermatologist == null) return;
//
//        Time time = getTimeDetailsGUI(dermatologist);
//        if (time == null) return;
//
//        Treatment treatment = getTreatmentDetailsGUI();
//        if (treatment == null) return;
//
//        JFrame frame = new JFrame("Enter Patient Details");
//        frame.setSize(400, 300);
//        JPanel panel = new JPanel(new GridLayout(5, 2));
//
//        JTextField nicField = new JTextField();
//        JTextField nameField = new JTextField();
//        JTextField emailField = new JTextField();
//        JTextField phoneField = new JTextField();
//        JButton submitButton = new JButton("Schedule");
//
//        panel.add(new JLabel("Patient NIC:"));
//        panel.add(nicField);
//        panel.add(new JLabel("Patient Name:"));
//        panel.add(nameField);
//        panel.add(new JLabel("Patient Email:"));
//        panel.add(emailField);
//        panel.add(new JLabel("Patient Phone:"));
//        panel.add(phoneField);
//        panel.add(submitButton);
//
//        submitButton.addActionListener(e -> {
//            int nic = Integer.parseInt(nicField.getText());
//            String name = nameField.getText();
//            String email = emailField.getText();
//            int phone = Integer.parseInt(phoneField.getText());
//
//            Patient patient = new Patient(nic, name, email, phone);
//            Appointment appointment = appointmentController.createAppointment(patient, dermatologist, treatment, time, null);
//            JOptionPane.showMessageDialog(frame, appointment != null ? "Appointment scheduled." : "Scheduling failed.");
//            frame.dispose();
//        });
//
//        frame.add(panel);
//        frame.setVisible(true);
//    }
//
//    private void viewAllAppointments() {
//        JFrame frame = new JFrame("All Appointments");
//        frame.setSize(400, 300);
//        frame.setLocationRelativeTo(null);
//        JTextArea textArea = new JTextArea();
//
//        for (Appointment appointment : appointmentController.listAppointments()) {
//            textArea.append(appointment.toString() + "\n");
//        }
//
//        frame.add(new JScrollPane(textArea));
//        frame.setVisible(true);
//    }
//
//    private void updateAppointment() {
//        JOptionPane.showMessageDialog(null, "Update Appointment is under development.");
//    }
//
//    private void cancelAppointment() {
//        JOptionPane.showMessageDialog(null, "Cancel Appointment is under development.");
//    }
//
//    private Treatment getTreatmentDetailsGUI() {
//        JComboBox<String> treatmentComboBox = new JComboBox<>();
//        for (TreatmentType treatment : TreatmentType.values()) {
//            treatmentComboBox.addItem(treatment.getName() + " - $" + treatment.getPrice());
//        }
//
//        JPanel panel = new JPanel();
//        panel.add(new JLabel("Available Treatments:"));
//        panel.add(treatmentComboBox);
//
//        int option = JOptionPane.showConfirmDialog(null, panel, "Select Treatment", JOptionPane.OK_CANCEL_OPTION);
//        if (option == JOptionPane.OK_OPTION) {
//            int selectedIndex = treatmentComboBox.getSelectedIndex();
//            TreatmentType selectedTreatmentType = TreatmentType.values()[selectedIndex];
//            try {
//                return new Treatment(selectedTreatmentType.getTreatmentID());
//            } catch (InvalidTreatmentIDException ex) {
//                JOptionPane.showMessageDialog(null, "Invalid Treatment ID: " + ex.getMessage());
//            }
//        }
//        return null;
//    }
//
//    private Time getTimeDetailsGUI(DermatologistModel dermatologist) {
//        JTextField dateField = new JTextField("YYYY-MM-DD");
//        JTextField timeField = new JTextField("HH:MM");
//
//        JPanel panel = new JPanel(new GridLayout(3, 2));
//        panel.add(new JLabel("Date:"));
//        panel.add(dateField);
//        panel.add(new JLabel("Time:"));
//        panel.add(timeField);
//
//        int option = JOptionPane.showConfirmDialog(null, panel, "Select Time", JOptionPane.OK_CANCEL_OPTION);
//        if (option == JOptionPane.OK_OPTION) {
//            try {
//                LocalDate date = LocalDate.parse(dateField.getText());
//                LocalTime time = LocalTime.parse(timeField.getText());
//                TimeImpl timeImpl = new TimeImpl(date, time);
//
//                if (dermatologist.checkAvailability(timeImpl)) {
//                    return timeImpl;
//                } else {
//                    JOptionPane.showMessageDialog(null, "Selected time is unavailable.");
//                }
//            } catch (Exception ex) {
//                JOptionPane.showMessageDialog(null, "Invalid date or time format.");
//            }
//        }
//        return null;
//    }
//
//    private DermatologistModel selectDermatologistGUI() {
//        JComboBox<String> dermatologistComboBox = new JComboBox<>();
//        for (Dermatologist dermatologist : Dermatologist.values()) {
//            dermatologistComboBox.addItem(dermatologist.getName());
//        }
//
//        JPanel panel = new JPanel();
//        panel.add(new JLabel("Choose a Dermatologist:"));
//        panel.add(dermatologistComboBox);
//
//        int option = JOptionPane.showConfirmDialog(null, panel, "Select Dermatologist", JOptionPane.OK_CANCEL_OPTION);
//        if (option == JOptionPane.OK_OPTION) {
//            int selectedIndex = dermatologistComboBox.getSelectedIndex();
//            return new DermatologistModel(Dermatologist.values()[selectedIndex]);
//        }
//        return null;
//    }
//}
