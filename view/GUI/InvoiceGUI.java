package view.GUI;

import javax.swing.*;

import exception.InvalidTreatmentIDException;
import model.Invoice;
import model.Treatment;
import java.awt.event.ActionListener;
import java.awt.*;
import exception.InvalidTreatmentIDException;

public class InvoiceGUI {

    private JFrame frame;
    private JPanel panel;

    public void showInvoiceMenu() {
        frame = new JFrame("Invoice Management");
        panel = new JPanel(new GridLayout(4, 1));

        JButton payInvoiceButton = createButton("Pay Invoice", e -> {
            try {
                payInvoice(0, new Treatment(1));
            } catch (InvalidTreatmentIDException ex) {
                throw new RuntimeException(ex);
            }
        });

        JButton viewInvoiceButton = createButton("View Invoice", e -> viewInvoice());
        JButton backButton = createButton("Back to Main Menu", e -> frame.dispose());

        panel.add(payInvoiceButton);
        panel.add(viewInvoiceButton);
        panel.add(backButton);

        frame.add(panel);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    private JButton createButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        return button;
    }

    private void viewInvoice() {
        JOptionPane.showMessageDialog(frame, "View Invoice functionality is under development.");
    }

    private void payInvoice(int invoiceId, Treatment treatment) {
        Invoice invoice = new Invoice(invoiceId, treatment);
        JOptionPane.showMessageDialog(frame, "Invoice paid successfully: " + invoice);
    }
}