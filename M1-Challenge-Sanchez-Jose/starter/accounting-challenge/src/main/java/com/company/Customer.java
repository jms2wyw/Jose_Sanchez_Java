package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    public Customer(int id, String name){
        this.id = id;
        this.name = name;
        List<AccountRecord> charges = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        //update this
        int balance = 0;
        for (AccountRecord o : charges){
            balance += o.getCharge();
        }
        return balance;
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }

    @Override
    public String toString() {
        String asnwer = "ID: " + id + ", Name: " + name + ", Account Balance: " + getBalance();
        //update this
        return asnwer;
    }
}
