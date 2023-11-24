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


    @Test
    public void findAllCustomersFirstNameContaining(){
        List<Customer> customerList = customerRepository.findByFirstNameContaining("ai");
        System.out.println(customerList);
    }

    @Test
    public void findAllCustomersLastNameNotNull(){
        List<Customer> customerList = customerRepository.findByLastNameNotNull();
        System.out.println(customerList);
    }

    @Test
    public void findAllCustomersByAddressCity(){
        List<Customer> customerList = customerRepository.findByAddress_City("New York City");
        System.out.println(customerList);
    }

    @Test
    public void getCustomerByEmail(){
        Customer customer = customerRepository.getCustomerByEmail("cdubois@gmail.com");
        System.out.println(customer);
    }

    @Test
    public void getCustomerFirstNameByEmail(){
        String firstName = customerRepository.getCustomerFirstNameByEmail("cdubois@gmail.com");
        System.out.println(firstName);
    }

    @Test
    public void getCustomerByEmailNative(){
        Customer customer = customerRepository.getCustomerByEmailNative("cdubois@gmail.com");
        System.out.println(customer);
    }

    @Test
    public void  getCustomerByEmailNativeAndNamedParams(){
        Customer customer = customerRepository.getCustomerByEmailNativeAndNamedParams("cdubois@gmail.com");
        System.out.println(customer);
    }

    @Test
    public void updateCustomerFirstNameByEmail(){
        customerRepository.updateCustomerFirstNameByEmail("Claire", "cdubois@gmail.com");
    }
}