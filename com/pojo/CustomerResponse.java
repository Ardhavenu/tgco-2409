package com.pojo;

import java.util.List;

public class CustomerResponse {
    private List<Customer> customers;

    // Constructor
    public CustomerResponse() {}

    public CustomerResponse(List<Customer> customers) {
        this.customers = customers;
    }

    // Getters
    public List<Customer> getCustomers() {
        return customers;
    }

    // Setters
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

}
