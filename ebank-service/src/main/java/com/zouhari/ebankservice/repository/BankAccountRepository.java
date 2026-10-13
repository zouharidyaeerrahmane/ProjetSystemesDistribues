package com.zouhari.ebankservice.repository;


import com.zouhari.ebankservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ZOUHARI Dyae errahmane
 * @Pseudo dezy
 **/
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
    List<BankAccount> findByCustomerId(Long id);
}
