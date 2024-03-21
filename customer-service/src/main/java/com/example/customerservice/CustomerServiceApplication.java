package com.example.customerservice;

import com.example.customerservice.entities.Customer;
import com.example.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(Customer.builder().firstName("Idriss").lastName("do").email("dou@gmail.com").build());
            customerRepository.save(Customer.builder().firstName("Hamza").lastName("ja").email("hamza@gmail.com").build());
            customerRepository.save(Customer.builder().firstName("Reda").lastName("dsq").email("reda@gmail.com").build());
        };
    }
}
