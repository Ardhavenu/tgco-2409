package com.controller;

import com.pojo.Invoice;
import com.pojo.InvoiceResponse;

import java.util.HashMap;
import java.util.Map;

public class CustomerMapController {

    public static Map<Integer, Double> topCustomerSpending(InvoiceResponse invoiceResponse) {
        Map<Integer, Double> customerSpending = new HashMap<>();

        for (Invoice invoice : invoiceResponse.getInvoices()) {
            customerSpending.put(invoice.getCustomerId(),
                    customerSpending.getOrDefault(invoice.getCustomerId(), 0.0) + invoice.getAmount());
        }

        // Find the customer ID with the highest spending
        int maxSpendingCustomerId = -1;
        double maxSpending = 0.0;

        for (Map.Entry<Integer, Double> entry : customerSpending.entrySet()) {
            if (entry.getValue() > maxSpending) {
                maxSpending = entry.getValue();
                maxSpendingCustomerId = entry.getKey();
            }
        }

        Map<Integer, Double> highestShoppingTotal = new HashMap<>();
        highestShoppingTotal.put(maxSpendingCustomerId,maxSpending);
        return highestShoppingTotal;
    }
}