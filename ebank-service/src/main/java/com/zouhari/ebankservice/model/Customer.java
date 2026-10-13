package com.zouhari.ebankservice.model;


import lombok.*;

/**
 * @author ZOUHARI Dyae errahmane
 * @Pseudo dezy
 **/

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Customer {
    private Long id;
    private String name;
    private String email;
}
