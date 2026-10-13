package com.zouhari.ebankservice.service;


import com.zouhari.ebankservice.entities.BankAccount;
import com.zouhari.ebankservice.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * @author ZOUHARI Dyae errahmane
 * @Pseudo dezy
 **/

@Service
public class EbankService {
    private BankAccountRepository accountRepository;

    public EbankService(BankAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    public List<BankAccount> getAllBankAccounts() {
        return accountRepository.findAll();
    }
    public BankAccount getBankAccountById(String id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));

    }
    public BankAccount save(BankAccount bankAccount) {
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());
            return accountRepository.save(bankAccount);



    }

}
