
package com.test;

import com.controller.CustomerMapController;
import com.pojo.Invoice;
import com.pojo.InvoiceResponse;
import org.junit.gen5.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.gen5.api.Assertions.assertEquals;

public class CustomerMapControllerTest {
    CustomerMapController customerMapController = new CustomerMapController();

    @Test
    public void testTopCustomerSpending() {
        List<Invoice> invoices = Arrays.asList(
                new Invoice(0, 0, 12.00),
                new Invoice(1, 1, 15.00),
                new Invoice(2, 0, 8.00)
        );

        InvoiceResponse invoiceResponse = new InvoiceResponse(invoices);
        int topCustomerId = customerMapController.topCustomerSpending(invoiceResponse);

        assertEquals(1, topCustomerId, "The customer ID with the highest spending should be 1");
    }
}
