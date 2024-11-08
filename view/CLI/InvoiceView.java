package view.CLI;

import model.Invoice;
import model.Treatment;

import java.util.Scanner;

public class InvoiceView {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Collects the initial paid amount and creates an Invoice object.
     * @param treatment The treatment associated with the invoice.
     * @return An Invoice object with the specified details.
     */
    public Invoice getInvoiceDetails(Treatment treatment) {
        double amount = getValidAmount();
        return new Invoice(amount, treatment);
    }

    /**
     * Displays a summary of the invoice, including treatment cost, amount paid, outstanding balance, and status.
     * @param invoice The invoice to display.
     */
    public void displayInvoiceSummary(Invoice invoice) {
        System.out.println("\n----- Invoice Summary -----");
        System.out.println("Treatment Cost: " + formatCurrency(invoice.getTreatment().getPrice()));
        System.out.println("Amount Paid: " + formatCurrency(invoice.getAmountPaid()));
        System.out.println("Outstanding Balance: " + formatCurrency(getOutstandingBalance(invoice)));
        System.out.println("Status: " + getInvoiceStatus(invoice));
        System.out.println("---------------------------\n");
    }

    // Helper method to get a valid paid amount from the user
    private double getValidAmount() {
        double amount = -1;
        while (amount < 0) {
            System.out.print("Initial Paid Amount: ");
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                if (amount < 0) {
                    System.out.println("Amount cannot be negative. Please enter a valid amount.");
                }
            } else {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.nextLine(); // Consume invalid input
            }
        }
        scanner.nextLine(); // Consume newline after valid input
        return amount;
    }

    // Helper method to format amounts as currency
    private String formatCurrency(double amount) {
        return String.format("$%.2f", amount);
    }

    // Helper method to calculate the outstanding balance
    private double getOutstandingBalance(Invoice invoice) {
        return invoice.getTotalAmount() - invoice.getAmountPaid();
    }

    // Helper method to return the status of the invoice
    private String getInvoiceStatus(Invoice invoice) {
        return invoice.isPaid() ? "Paid" : "Pending";
    }
}
