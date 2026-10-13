package com.zouhari.customerservice.controllers;


import com.zouhari.customerservice.entities.Customer;
import com.zouhari.customerservice.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ZOUHARI Dyae errahmane
 * @Pseudo dezy
 **/
@RestController
public class CustomerRestController {
    private CustomerService customerService;

    public  CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable("id") Long id) {
        return customerService.getCustomerById(id);
    }
    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }
}
