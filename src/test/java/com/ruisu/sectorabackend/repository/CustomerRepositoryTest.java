package com.ruisu.sectorabackend.repository;

import com.ruisu.sectorabackend.entity.Address;
import com.ruisu.sectorabackend.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @Test
    public void saveCustomerWithEmbeddedAddress(){

        Address address = Address.builder()
                .addressLine("241A Madison St, Brooklyn")
                .postalCode("11216")
                .city("New York City")
                .state("New York")
                .country("United States")
                .build();

        Customer customer = Customer.builder()
                .firstName("Claire")
                .lastName("Dubois")
                .email("cdubois@gmail.com")
                .address(address)
                .build();

        customerRepository.save(customer);
    }

    @Test
    public void findCustomerByFirstName(){
        Customer customer = customerRepository.findByFirstName("Claire").get();
        System.out.println("customer = "+customer);
    }


    @Test
    public void findAllCustomers(){
        List<Customer> customerList = customerRepository.findAll();
        System.out.println("customerList = "+customerList);
    }

}