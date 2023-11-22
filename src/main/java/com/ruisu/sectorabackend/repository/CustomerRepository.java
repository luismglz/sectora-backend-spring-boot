package com.ruisu.sectorabackend.repository;

import com.ruisu.sectorabackend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByFirstName(String firstName);
    List<Customer> findByFirstNameContaining(String firstName);
    List<Customer> findByLastNameNotNull();
    List<Customer> findByAddress_City(String city);
}
