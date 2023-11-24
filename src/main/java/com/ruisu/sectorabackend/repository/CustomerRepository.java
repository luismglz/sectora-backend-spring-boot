package com.ruisu.sectorabackend.repository;

import com.ruisu.sectorabackend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByFirstName(String firstName);
    List<Customer> findByFirstNameContaining(String firstName);
    List<Customer> findByLastNameNotNull();
    List<Customer> findByAddress_City(String city);

    @Query("SELECT c FROM Customer c WHERE c.email = ?1")
    Customer getCustomerByEmail(String email);

    @Query("SELECT c.firstName FROM Customer c WHERE c.email = ?1")
    String getCustomerFirstNameByEmail(String email);

    //Use SQL not JPQL
    @Query(
            value = "SELECT * FROM customer WHERE email = ?1",
            nativeQuery = true
    )
    Customer getCustomerByEmailNative(String email);

    //Use SQL and named params
    @Query(
            value = "SELECT * FROM customer WHERE email = :email",
            nativeQuery = true
    )
    Customer getCustomerByEmailNativeAndNamedParams(String email);

    @Transactional
    @Modifying
    @Query(
            value = "UPDATE customer SET first_name = ?1 WHERE email = ?2",
            nativeQuery = true
    )
    void updateCustomerFirstNameByEmail(String firstName, String email);
}
