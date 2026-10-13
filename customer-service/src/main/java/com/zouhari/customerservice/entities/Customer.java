package com.zouhari.customerservice.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

/**
 * @author ZOUHARI Dyae errahmane
 * @Pseudo dezy
 **/
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Customer {

    @Id @GeneratedValue
    private  long id;
    private String name;
    private String email;
}

