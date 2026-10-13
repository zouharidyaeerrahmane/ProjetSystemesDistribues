package com.zouhari.ebankservice;

import com.zouhari.ebankservice.entities.BankAccount;
import com.zouhari.ebankservice.service.EbankService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EbankServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(EbankService ebankService) {
        return args -> {
            for (int i = 1; i <= 3; i++) {
                for (int j = 1; j <= 5; j++) {
                    ebankService.save(BankAccount.builder()
                            .type(Math.random()>0.5? "Current Account":"Saving Account")
                            .balance(1000+Math.random()*60000)
                            .customerId((long) i)
                            .build());
                }

            }
        };
    }
}
