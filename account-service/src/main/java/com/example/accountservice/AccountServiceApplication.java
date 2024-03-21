package com.example.accountservice;

import com.example.accountservice.entities.BankAccount;
import com.example.accountservice.enums.AccountType;
import com.example.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository){
        return args -> {
            bankAccountRepository.save(BankAccount.builder().accountId(UUID.randomUUID().toString())
                    .currency("MAD")
                    .balance(Math.random()*10000)
                    .createdAt(LocalDate.now())
                    .accountType(AccountType.CURRENT_ACCOUNT)
                    .customerId(Long.valueOf(1))
                    .build());
            bankAccountRepository.save(BankAccount.builder().accountId(UUID.randomUUID().toString())
                    .currency("MAD")
                    .balance(Math.random()*10000)
                    .createdAt(LocalDate.now())
                    .accountType(AccountType.SAVING_ACCOUNT)
                    .customerId(Long.valueOf(2))
                    .build());
        };
    }
}
