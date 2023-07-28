package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepo;

    @BeforeEach
    public void setUp() throws Exception{
        customerRepo.deleteAll();
    }

    @Test
    public void shouldAddCustomer(){

        Customer customer = new Customer();
        customer.setFirstName("Jose");
        customer.setLastName("Sanchez");
        customer.setId(0);
        customer.setCompany("Netflix");
        customer.setPhone("123-456-7890");
        customer.setAddress1("200 Park Av");
        customer.setAddress2("Cookers 435 St");
        customer.setCity("Bronx");
        customer.setState("NY");
        customer.setPostalCode("10000");
        customer.setCountry("USA");

        customer = customerRepo.save(customer);


        Optional<Customer> customer1 = customerRepo.findById(customer.getId());
        assertEquals(customer1.get(),customer);
    }
    @Test
    public void shouldUpdateCustomer(){

        Customer customer = new Customer();
        customer.setFirstName("Jose");
        customer.setLastName("Sanchez");
        customer.setId(0);
        customer.setCompany("Netflix");
        customer.setPhone("123-456-7890");
        customer.setAddress1("200 Park Av");
        customer.setAddress2("Cookers 435 St");
        customer.setCity("Bronx");
        customer.setState("NY");
        customer.setPostalCode("10000");
        customer.setCountry("USA");

        customer = customerRepo.save(customer);

        customer.setFirstName("New Name");
        customer.setLastName("New Last");
        customer.setCompany("Google");

        customerRepo.save(customer);


        Optional<Customer> customer1 = customerRepo.findById(customer.getId());
        assertEquals(customer1.get(),customer);
    }

    @Test
    public void shouldDeleteCustomer(){

        Customer customer = new Customer();
        customer.setFirstName("Jose");
        customer.setLastName("Sanchez");
        customer.setId(0);
        customer.setCompany("Netflix");
        customer.setPhone("123-456-7890");
        customer.setAddress1("200 Park Av");
        customer.setAddress2("Cookers 435 St");
        customer.setCity("Bronx");
        customer.setState("NY");
        customer.setPostalCode("10000");
        customer.setCountry("USA");

        customer = customerRepo.save(customer);


        Optional<Customer> customer1 = customerRepo.findById(customer.getId());
        assertEquals(customer1.get(),customer);
        customerRepo.deleteById(customer.getId());
        customer1 = customerRepo.findById(customer.getId());
        assertFalse(customer1.isPresent());
    }

    @Test
    public void shouldFindCustomerById(){

        Customer customer = new Customer();
        customer.setFirstName("Jose");
        customer.setLastName("Sanchez");
        customer.setId(0);
        customer.setCompany("Netflix");
        customer.setPhone("123-456-7890");
        customer.setAddress1("200 Park Av");
        customer.setAddress2("Cookers 435 St");
        customer.setCity("Bronx");
        customer.setState("NY");
        customer.setPostalCode("10000");
        customer.setCountry("USA");

        customer = customerRepo.save(customer);

        Customer customer1 = new Customer();
        customer1.setFirstName("Jose000");
        customer1.setLastName("Sanchez000");
        customer1.setId(1);
        customer1.setCompany("Netflix");
        customer1.setPhone("123-456-7890");
        customer1.setAddress1("200 Park Av");
        customer1.setAddress2("Cookers 435 St");
        customer1.setCity("Bronx");
        customer1.setState("NY");
        customer1.setPostalCode("10000");
        customer1.setCountry("USA");

        customer1 = customerRepo.save(customer1);

        Optional<Customer> foundCustomer = customerRepo.findById(customer.getId());
        assertEquals(foundCustomer.get(), customer);
    }

    @Test
    public void shouldFindCustomerByState(){

        Customer customer = new Customer();
        customer.setFirstName("Jose");
        customer.setLastName("Sanchez");
        customer.setId(0);
        customer.setCompany("Netflix");
        customer.setPhone("123-456-7890");
        customer.setAddress1("200 Park Av");
        customer.setAddress2("Cookers 435 St");
        customer.setCity("Bronx");
        customer.setState("NY");
        customer.setPostalCode("10000");
        customer.setCountry("USA");

        customer = customerRepo.save(customer);

        customer = new Customer();
        customer.setFirstName("Jose000");
        customer.setLastName("Sanchez000");
        customer.setId(1);
        customer.setCompany("Netflix");
        customer.setPhone("123-456-7890");
        customer.setAddress1("200 Park Av");
        customer.setAddress2("Cookers 435 St");
        customer.setCity("Bronx");
        customer.setState("FL");
        customer.setPostalCode("10000");
        customer.setCountry("USA");

        customer = customerRepo.save(customer);

        List<Customer> aList = customerRepo.findByState("NY");
        assertEquals(aList.size(), 1);
    }
}