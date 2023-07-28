package com.company.customerdataservice.controller;
import com.company.customerdataservice.repository.CustomerRepository;
import com.company.customerdataservice.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    CustomerRepository repo;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();


    @BeforeEach
    public void setUp() {
        // Standard set up method, for instantiating test objects
        // Don't have to do anything special for mockMvc since it's Autowired
    }

    @Test
    void ShouldAddCustomer() throws Exception{
        mockMvc.perform(post("/customers"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void updateCustomer() throws Exception{
        mockMvc.perform(put("/customers"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteCustomer() throws Exception{
        mockMvc.perform(delete("/customers/{id}"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getCustomerById() throws Exception{
        mockMvc.perform(get("/customers/{id}"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getCustomers() throws Exception{
        mockMvc.perform(get("/customers"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
