package com.zouhari.ebankservice.feign;


import com.zouhari.ebankservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ZOUHARI Dyae errahmane
 * @Pseudo dezy
 **/

@FeignClient(name = "customer-service")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    Customer getCustomerById(@PathVariable Long id);
    default Customer getDefaultCustomer(Long id, Exception e) {
        return new Customer(id, "NotAvailable", "NotAvailable");

    }
}
