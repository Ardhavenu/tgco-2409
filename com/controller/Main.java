package com.controller;

public class Main {

    public static void main(String args[]){
        try{
            System.out.println("In Main method");
            ShoppingTotalController stc = new ShoppingTotalController();
            stc.findTopCustomer();

        } catch(Exception e){
            System.out.println("Issue found");
        }

    }
}
