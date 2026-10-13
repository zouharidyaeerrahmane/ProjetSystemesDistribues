package com.zouhari.customerservice.repository;


import com.zouhari.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ZOUHARI Dyae errahmane
 * @Pseudo dezy
 **/
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
