package com.example.accountservice.web;

import com.example.accountservice.client.CustomerRestClient;
import com.example.accountservice.entities.BankAccount;
import com.example.accountservice.model.Customer;
import com.example.accountservice.repository.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@AllArgsConstructor
public class BankAccountRestController {
    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;

    @GetMapping
    public List<BankAccount> bankAccounts(){
        List<BankAccount> bankAccounts = bankAccountRepository.findAll();
        bankAccounts = bankAccounts.stream().peek(bankAccount -> {
            Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
            bankAccount.setCustomer(customer);
        }).toList();
        return bankAccounts;
    }
    @GetMapping("/{id}")
    public BankAccount bankAccountById(@PathVariable String id){
        BankAccount bankAccount = bankAccountRepository.findById(id).orElseThrow();
        Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}
