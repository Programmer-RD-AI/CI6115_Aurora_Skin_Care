package model;

public class Invoice {
    private double totalAmount; // Total amount for the treatment
    private double amountPaid; // Amount already paid
    private boolean isPaid; // Indicates if the invoice is fully paid
    private final Treatment treatment; // Treatment for which the invoice is issued
    private static int invoiceID;

    /**
     * Constructs an Invoice for a given treatment with the initial payment made.
     * @param initialPaidAmount The amount initially paid for the treatment
     * @param treatment The treatment for which the invoice is created
     */
    public Invoice(double initialPaidAmount, Treatment treatment) {
        if (initialPaidAmount < 0) {
            throw new IllegalArgumentException("Initial payment cannot be negative.");
        }

        this.treatment = treatment;
        this.totalAmount = treatment.getPrice();
        this.amountPaid = initialPaidAmount;

        // Adjust the remaining amount
        this.totalAmount -= initialPaidAmount;
        this.isPaid = this.totalAmount <= 0; // Mark as paid if no balance is left
        invoiceID++;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    /**
     * Makes a payment towards the outstanding invoice amount.
     * @param amount The amount to be paid
     */
    public void makePayment(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Payment amount must be positive.");
        }

        if (isPaid()) {
            throw new IllegalStateException("The invoice has already been paid in full.");
        }

        if (amount > totalAmount) {
            throw new IllegalArgumentException("Payment exceeds the outstanding balance.");
        }

        // Update the paid amount and reduce the balance
        this.amountPaid += amount;
        this.totalAmount -= amount;

        // Check if the invoice is fully paid
        if (this.totalAmount <= 0) {
            this.isPaid = true;
        }
    }

    /**
     * Returns whether the invoice has been paid in full.
     * @return true if the invoice is fully paid, false otherwise
     */
    public boolean isPaid() {
        return isPaid;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "totalAmount=" + totalAmount +
                ", amountPaid=" + amountPaid +
                ", isPaid=" + isPaid +
                ", treatment=" + treatment +
                '}';
    }

    public static int getInvoiceID() {
        return invoiceID;
    }
}
