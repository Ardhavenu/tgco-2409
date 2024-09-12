package com.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pojo.Customer;
import com.pojo.CustomerResponse;
import com.pojo.InvoiceResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class ShoppingTotalController {
    static CustomerMapController customerService = new CustomerMapController();

    public void findTopCustomer() {

        // Define the URL for the GET request
        String urlInvoices = "http://localhost:9092";
        String urlCustomers = "http://localhost:9090";

        try {
            String invoicesJson = getJson(urlInvoices);
            InvoiceResponse invoiceList = parseInvoices(invoicesJson);

            if (invoiceList == null) {
                System.out.println("No Invoices found");
            }

            String customersJson = getJson(urlCustomers);
            CustomerResponse customerList = parseCustomers(customersJson);

            if (customerList == null || isNullOrEmpty(customerList.getCustomers())) {
                System.out.println("No Customers found");
            }

            Map<Integer,Double> highestShoppingTotal = customerService.topCustomerSpending(invoiceList);

            int topCustomerId = 0;
            for (Integer key : highestShoppingTotal.keySet()) {
                topCustomerId = key;
            }
            getTopCustomer(topCustomerId, customerList,highestShoppingTotal.get(topCustomerId));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getJson(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> responseInvoices;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()  // Specify GET method
                    .build();

            // Send the request and get the response (synchronously)
            responseInvoices = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return responseInvoices.body();
    }

    private static InvoiceResponse parseInvoices(String invoicesJson) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InvoiceResponse invoiceResponse = objectMapper.readValue(invoicesJson, InvoiceResponse.class);
            return invoiceResponse;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static CustomerResponse parseCustomers(String invoicesJson) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(invoicesJson, CustomerResponse.class);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void getTopCustomer(int topCustomerId, CustomerResponse customerResponse , Double topShoppingamount) throws JsonProcessingException {

        for(Customer customer:customerResponse.getCustomers()){
            if(topCustomerId==customer.getID()){
                System.out.println("Customer with highest shopping amount is "+customer.getName()+" "+customer.getSurname()+" with an shopping amount of "+topShoppingamount);
            }
        }
    }

    private static <T> boolean isNullOrEmpty(List<T> list) {
        return list == null || list.isEmpty();
    }
}
