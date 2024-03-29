package com.ruisu.sectorabackend.repository;


import com.ruisu.sectorabackend.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


//@DataJpaTest
@SpringBootTest
class BranchRepositoryTest {

    @Autowired
    private BranchRepository branchRepository;

    /*@Autowired
    private TestEntityManager testEntityManager;*/

   /* @BeforeEach
    void setUp() {
        Branch branch =
                Branch.builder()
                        .name("DOMISE Shibuya dogenzaka-dori")
                        .address("2-25-12 Dogenzaka Shibuya-ku Tokyo, JAPAN, 150-0043")
                        .telephone("0570-000-578")
                        .build();

        testEntityManager.persist(branch);
    }*/

    @Test
    public void saveBranch(){

        Manager manager = Manager.builder()
                .firstName("Haruka")
                .lastName("Sato")
                .build();

        Branch branch = Branch.builder()
                .name("DOMISE Shibuya dogenzaka-dori")
                .address("2-25-12 Dogenzaka Shibuya-ku Tokyo, JAPAN, 150-0043")
                .telephone("0570-000-578")
                .manager(manager)
                .build();

        branchRepository.save(branch);
    }

    @Test
    public void findAllBranches(){
        List<Branch> branchList = branchRepository.findAll();
        System.out.println(branchList);
    }

    @Test
    public void saveBranchWithOrders(){
       Order order1 = Order.builder()
                        .description("Matcha Green Tea Set")
                        .price(4500)
                        .build();

        Order order2 = Order.builder()
                .description("Onsen Bath Salts Assortment")
                .price(2200)
                .build();

        Manager manager = Manager.builder()
                .firstName("Kenji")
                .lastName("Takahashi")
                .build();

        Branch branch = Branch.builder()
                .name("Teikyu Kamata")
                .address("Wing Kitchen Keikyu Kamata, 4-50-11 Kamata Ota-ku Tokyo, JAPAN, 150-0043")
                .telephone("0570-085-735")
                .manager(manager)
                //.orders(List.of(order1,order2))
                .build();

        branchRepository.save(branch);
    }

    @Test
    public void findAllBranchesWithOrders(){

        List<Branch> branchList = branchRepository.findAll();
        System.out.println(branchList);
    }

    @Test
    public void saveBranchWithCustomer(){
        Manager manager = Manager.builder()
                .firstName("Haruka")
                .lastName("Sato")
                .build();

        Customer customer = Customer.builder()
                .firstName("Haruka")
                .lastName("Ishikawa")
                .email("hish_1010@gmail.com")
                .address(Address.builder()
                        .country("JAPAN")
                        .city("Tokyo")
                        .addressLine("2 Chome-2-13 Yoyogi")
                        .state("Tokyo")
                        .postalCode("151-0053")
                        .build())
                .build();

        Branch branch = Branch.builder()
                .name("DOMISE Shibuya dogenzaka-dori")
                .address("2-25-12 Dogenzaka Shibuya-ku Tokyo, JAPAN, 150-0043")
                .telephone("0570-000-578")
                .manager(manager)
                .customers(List.of(customer))
                .build();

        branchRepository.save(branch);
    }

    @Test
    public void findAllBranchesWithCustomers(){
        List<Branch> branches = branchRepository.findAll();
        System.out.println(branches);

    }

    @Test
    public void findCustomersByBranch(){
        Branch branch = branchRepository.findById(1L).get();
        List<Customer> customers = branch.getCustomers();
        System.out.println(customers);

    }

   /* @Test
    public void findBranchByNameIgnoreCaseFound(){
        Optional<Branch> branch = branchRepository.findByNameIgnoreCase("domise shibuya dogenzaka-dori");

        assertEquals(branch.get().getName(), "DOMISE Shibuya dogenzaka-dori");
        System.out.println("local.get() = "+branch.get());
    }


    @Test
    public void findBranchByNameIgnoreCaseNotFound(){
        Optional<Branch> branch = branchRepository.findByNameIgnoreCase("Donki");
        assertEquals(branch, Optional.empty());
    }*/
}