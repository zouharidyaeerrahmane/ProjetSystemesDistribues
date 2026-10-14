package com.zouhari.customerservice.service;


import com.zouhari.customerservice.entities.Customer;
import com.zouhari.customerservice.repository.CustomerRepository;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZOUHARI Dyae errahmane
 * @Pseudo dezy
 **/

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @McpTool(description = "Get All Customers")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @McpTool(description = "Find a Customer by id")
    public Customer getCustomerById(@McpToolParam(description = "The customer id") Long id) {
        return customerRepository.findById(id).orElseThrow(()-> new RuntimeException("Customer not found"));
    }

    @McpTool(description = "Save a new Customer")
    public Customer saveCustomer(@McpToolParam(description = "The customer to save (name, email)") Customer customer) {
        return customerRepository.save(customer);
    }
}