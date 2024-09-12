package com.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
    @JsonProperty("ID")
    private int ID;
    private String name;
    private String surname;

    public Customer() {}
    public Customer(int ID, String name,String surname) {
        this.ID = ID;
        this.name = name;
        this.surname = name;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
