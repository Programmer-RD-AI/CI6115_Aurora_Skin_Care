//package view.GUI;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class MainGUI {
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            JFrame frame = createMainFrame();
//
//            JPanel mainPanel = createMainPanel();
//
//            frame.add(mainPanel);
//            frame.setVisible(true);
//        });
//    }
//
//    // Creates and configures the main JFrame
//    private static JFrame createMainFrame() {
//        JFrame frame = new JFrame("Clinic Management System");
//        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Handle custom close operation
//        frame.setSize(400, 200);
//        frame.setLocationRelativeTo(null); // Center the window
//        frame.addWindowListener(new java.awt.event.WindowAdapter() {
//            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
//                int response = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?",
//                        "Exit Confirmation", JOptionPane.YES_NO_OPTION);
//                if (response == JOptionPane.YES_OPTION) {
//                    System.exit(0);
//                }
//            }
//        });
//        return frame;
//    }
//
//    // Creates and configures the main panel with buttons
//    private static JPanel createMainPanel() {
//        JPanel panel = new JPanel(new GridLayout(3, 1)); // Using GridLayout for a neat vertical arrangement
//
//        JButton appointmentButton = createButton("Manage Appointments", e -> new AppointmentGUI().showAppointmentMenu());
//        JButton invoiceButton = createButton("Manage Invoices", e -> new InvoiceGUI().showInvoiceMenu());
//        JButton exitButton = createButton("Exit", e -> System.exit(0));
//
//        panel.add(appointmentButton);
//        panel.add(invoiceButton);
//        panel.add(exitButton);
//
//        return panel;
//    }
//
//    // Creates a JButton with action listener
//    private static JButton createButton(String label, Runnable action) {
//        JButton button = new JButton(label);
//        button.addActionListener(e -> action.run());
//        return button;
//    }
//}
