package com.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Invoice {
    @JsonProperty("ID")
    private int ID;
    private int customerId;
    private Double amount;

    public Invoice() { }

    public Invoice(int ID,int customerId,Double amount) {
        this.ID = ID;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}
