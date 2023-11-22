package com.ruisu.sectorabackend.repository;

import com.ruisu.sectorabackend.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void saveCustomer(){
        Customer customer = Customer.builder()
                .firstName("Claire")
                .lastName("Dubois")
                .email("cdubois@gmail.com")
                .build();

        customerRepository.save(customer);
    }

}