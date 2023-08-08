package com.company.customerdataservice.controller;
import com.company.customerdataservice.repository.CustomerRepository;
import com.company.customerdataservice.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    CustomerRepository repo;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);


    @BeforeEach
    public void setUp() {
        // Standard set up method, for instantiating test objects
        // Don't have to do anything special for mockMvc since it's Autowired
        Customer customerTest = new Customer();
        customerTest.setFirstName("crazed");
        customerTest.setLastName("blink");
        customerTest.setId(1);
        customerTest.setCompany("Netflix");
        customerTest.setPhone("123-456-7890");
        customerTest.setAddress1("200 Park Av");
        customerTest.setAddress2("Cookers 435 St");
        customerTest.setCity("Bronx");
        customerTest.setState("NY");
        customerTest.setPostalCode("10000");
        customerTest.setCountry("USA");
    }

    @Test
    public void ShouldAddCustomer() throws Exception{
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
        String inputJson = mapper.writeValueAsString(customer);
        mockMvc.perform(post("/customer")
                        .content(inputJson)

                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void updateCustomer() throws Exception{
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
        String inputJson = mapper.writeValueAsString(customer);
        mockMvc.perform(put("/customer")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))

                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void deleteCustomer() throws Exception{
        mockMvc.perform(delete("/customer/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void getCustomerById() throws Exception{
        /*Customer customer = new Customer();
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


        Customer customer1 = new Customer();
        customer1.setFirstName("Connor");
        customer1.setLastName("Sanchez");
        customer1.setId(59);
        customer1.setCompany("Google");
        customer1.setPhone("123-456-7890");
        customer1.setAddress1("200 Park Av");
        customer1.setAddress2("Cookers 435 St");
        customer1.setCity("Bronx");
        customer1.setState("NY");
        customer1.setPostalCode("10000");
        customer1.setCountry("USA");
        String inputJson = mapper.writeValueAsString(customer1);*/

        mockMvc.perform(get("/customer/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void getCustomersByState() throws Exception{
        Customer customer1 = new Customer();
        customer1.setFirstName("Connor");
        customer1.setLastName("Sanchez");
        customer1.setId(59);
        customer1.setCompany("Google");
        customer1.setPhone("123-456-7890");
        customer1.setAddress1("200 Park Av");
        customer1.setAddress2("Cookers 435 St");
        customer1.setCity("Bronx");
        customer1.setState("NY");
        customer1.setPostalCode("10000");
        customer1.setCountry("USA");
        String inputJson = mapper.writeValueAsString(customer1);
        mockMvc.perform(get("/customers/NY"))
                .andDo(print())
                .andExpect(status().isOk());

    }
}
