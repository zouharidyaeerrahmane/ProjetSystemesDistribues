package com.zouhari.customerservice.service;


import com.zouhari.customerservice.entities.Customer;
import com.zouhari.customerservice.repository.CustomerRepository;
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

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(()-> new RuntimeException("Customer not found"));
    }
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

}
