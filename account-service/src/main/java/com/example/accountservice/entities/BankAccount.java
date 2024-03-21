package com.example.accountservice.entities;

import com.example.accountservice.enums.AccountType;
import com.example.accountservice.model.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.*;

import java.time.LocalDate;
@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder @ToString
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createdAt;
    private String currency;
    private AccountType accountType;
    @Transient
    private Customer customer;
    private Long customerId;
}
