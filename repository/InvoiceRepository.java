package repository;

import model.Invoice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InvoiceRepository {
    private List<Invoice> invoiceList;

    // Constructor to initialize with an existing list
    public InvoiceRepository(List<Invoice> invoiceList) {
        this.invoiceList = new ArrayList<>(invoiceList);  // Create a new ArrayList to avoid external modifications
    }

    // Default constructor initializes an empty list
    public InvoiceRepository() {
        this.invoiceList = new ArrayList<>();
    }

    // Add an invoice to the list
    public void addInvoice(Invoice invoice) {
        if (invoice != null) {
            invoiceList.add(invoice);
        }
    }

    // Delete an invoice by object reference
    public void deleteInvoice(Invoice invoice) {
        invoiceList.remove(invoice);
    }

    // Delete an invoice by index
    public void deleteInvoiceByIndex(int idx) {
        if (idx >= 0 && idx < invoiceList.size()) {
            invoiceList.remove(idx);
        }
    }

    // Get an unmodifiable list of invoices to prevent external modification
    public List<Invoice> getInvoiceList() {
        return Collections.unmodifiableList(invoiceList);  // Make list unmodifiable
    }

    // Optionally, if invoice retrieval by index is necessary
    public Invoice getInvoiceByIndex(int idx) {
        if (idx >= 0 && idx < invoiceList.size()) {
            return invoiceList.get(idx);
        }
        return null;  // Return null if index is invalid
    }

    // Optionally, method to get the number of invoices
    public int getInvoiceCount() {
        return invoiceList.size();
    }
}
