package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    Customer customer;
    @BeforeEach
    public void setUp(){
        customer = new Customer(1, "Customer One");
        AccountRecord a = new AccountRecord();
        a.setCharge(25);
        customer.getCharges().add(a);
        AccountRecord b = new AccountRecord();
        b.setCharge(-20);
        customer.getCharges().add(b);
    }
    @Test
    void getBalance() {
        assertEquals(5, customer.getBalance());
    }

    @Test
    void testToString() {
        assertEquals("ID: 1, Name: Customer One, Account Balance: 5", customer.toString());
    }
}