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
    public void makePayment(double paymentAmount) {
        if (paymentAmount <= 0) {
            throw new IllegalArgumentException("Payment amount must be positive.");
        }

        if (isPaid()) {
            throw new IllegalStateException("The invoice has already been paid in full.");
        }

        // Calculate the outstanding balance
        double outstandingBalance = this.totalAmount - this.amountPaid;

        // Ensure the payment does not exceed the outstanding balance
        if (paymentAmount > outstandingBalance) {
            throw new IllegalArgumentException("Payment exceeds the outstanding balance.");
        }

        // Update the amount paid
        this.amountPaid += paymentAmount;

        // Check if the invoice is fully paid
        if (this.amountPaid >= this.totalAmount) {
            this.isPaid = true;
            this.amountPaid = this.totalAmount;  // Ensure that amountPaid equals totalAmount when fully paid
        }

        // If it's not fully paid, the remaining balance is calculated.
        // This happens automatically due to the way the class works, no need for further action.
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
