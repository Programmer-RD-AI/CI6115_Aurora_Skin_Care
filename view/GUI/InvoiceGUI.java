//package view.GUI;
//
//import javax.swing.*;
//
//import exception.InvalidTreatmentIDException;
//import model.Invoice;
//import model.Treatment;
//
//import java.awt.*;
//
//public class InvoiceGUI {
//
//    private JFrame frame;
//    private JPanel panel;
//
//    public void showInvoiceMenu() {
//        frame = new JFrame("Invoice Management");
//        frame.setSize(400, 300);
//        frame.setLocationRelativeTo(null);
//
//        panel = new JPanel(new GridLayout(4, 1));  // Adjusted grid layout for better arrangement
//
//        // Initialize buttons with appropriate listeners
//        JButton viewInvoiceButton = createButton("View Invoice", e -> {
//            try {
//                viewInvoice(0, new Treatment(1));
//            } catch (InvalidTreatmentIDException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//        JButton payInvoiceButton = createButton("Pay Invoice", e -> {
//            try {
//                payInvoice(0, new Treatment(1));
//            } catch (InvalidTreatmentIDException ex) {
//                throw new RuntimeException(ex);
//            }
//        }));
//        JButton backButton = createButton("Back to Main Menu", e -> frame.dispose());
//
//        panel.add(viewInvoiceButton);
//        panel.add(payInvoiceButton);
//        panel.add(backButton);
//
//        frame.add(panel);
//        frame.setVisible(true);
//    }
//
//    // Helper method to create buttons to avoid repetitive code
//    private JButton createButton(String label, Runnable action) {
//        JButton button = new JButton(label);
//        button.addActionListener(e -> action.run());
//        return button;
//    }
//
//    private void viewInvoice(int initialPaidAmount, Treatment treatment) {
//        // Placeholder for actual invoice viewing logic
//        try {
//            Invoice invoice = getInvoice(initialPaidAmount, treatment);  // Retrieve the invoice (dummy method for now)
//            if (invoice == null) {
//                JOptionPane.showMessageDialog(frame, "No invoice available to view.");
//            } else {
//                // Display invoice details (simplified)
//                JOptionPane.showMessageDialog(frame, "Invoice ID: " + invoice.getInvoiceID() + "\nTotal: $" + invoice.getTotalAmount());
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(frame, "An error occurred while viewing the invoice.");
//        }
//    }
//
//    private void payInvoice(int initialPaidAmount, Treatment treatment) {
//        // Placeholder for actual invoice payment logic
//        try {
//            Invoice invoice = getInvoice(initialPaidAmount, treatment);  // Retrieve the invoice (dummy method for now)
//            if (invoice == null) {
//                JOptionPane.showMessageDialog(frame, "No invoice available to pay.");
//            } else {
//                // Simulate payment logic (can be expanded later)
//                boolean paymentSuccess = processPayment(invoice);
//                String message = paymentSuccess ? "Invoice paid successfully." : "Payment failed.";
//                JOptionPane.showMessageDialog(frame, message);
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(frame, "An error occurred while processing the payment.");
//        }
//    }
//
//    // Simulate retrieving an invoice - this would be replaced with actual logic
//    private Invoice getInvoice(int initialPaidAmount,Treatment treatment) {
//        // For now, returning a dummy invoice
//        return new Invoice(initialPaidAmount, treatment);
//    }
//
//    // Simulate payment processing - this would be replaced with actual payment logic
//    private boolean processPayment(Invoice invoice) {
//        // For now, assuming payment always succeeds
//        return true;
//    }
//}
