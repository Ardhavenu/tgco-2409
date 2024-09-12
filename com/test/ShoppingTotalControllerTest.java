/*package com.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.Invoice;
import com.pojo.InvoiceResponse;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingTotalControllerTest {

    private MockWebServer mockWebServer;
    private ShoppingTotalController shoppingTotalController;

    @BeforeEach
    public void setUp() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
        shoppingTotalController = new ShoppingTotalController();
    }

    @AfterEach
    public void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    public void testFindTopCustomer() throws IOException {
        List<Invoice> invoices = Arrays.asList(
                new Invoice(0, 0, 12),
                new Invoice(1, 1, 15),
                new Invoice(2, 0, 8)
        );

        InvoiceResponse invoiceResponse = new InvoiceResponse(invoices);
        ObjectMapper objectMapper = new ObjectMapper();
        String invoicesJson = objectMapper.writeValueAsString(invoiceResponse);

        mockWebServer.enqueue(new MockResponse()
                .setBody(invoicesJson)
                .addHeader("Content-Type", "application/json"));

        mockWebServer.enqueue(new MockResponse()
                .setBody("[]")
                .addHeader("Content-Type", "application/json"));

        String baseUrl = mockWebServer.url("/").toString();
        shoppingTotalController.setUrls(baseUrl, baseUrl);

        int topCustomerId = shoppingTotalController.findTopCustomer();

        assertEquals(1, topCustomerId, "The customer ID with the highest spending should be 1");
    }
}
*/