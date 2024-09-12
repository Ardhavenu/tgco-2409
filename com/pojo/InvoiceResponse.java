package com.pojo;

import java.util.List;

public class InvoiceResponse {
    private List<Invoice> invoices;

    // Constructor
    public InvoiceResponse() {}

    public InvoiceResponse(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    // Getters
    public List<Invoice> getInvoices() {
        return invoices;
    }

    // Setters
    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

}
