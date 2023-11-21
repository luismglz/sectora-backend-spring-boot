package com.ruisu.sectorabackend.repository;


import com.ruisu.sectorabackend.entity.Branch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
class BranchRepositoryTest {

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Branch branch =
                Branch.builder()
                        .name("DOMISE Shibuya dogenzaka-dori")
                        .address("2-25-12 Dogenzaka Shibuya-ku Tokyo, JAPAN, 150-0043")
                        .telephone("0570-000-578")
                        .build();

        testEntityManager.persist(branch);
    }

    @Test
    public void findBranchByNameIgnoreCaseFound(){
        Optional<Branch> branch = branchRepository.findByNameIgnoreCase("domise shibuya dogenzaka-dori");

        assertEquals(branch.get().getName(), "DOMISE Shibuya dogenzaka-dori");
        System.out.println("local.get() = "+branch.get());
    }


    @Test
    public void findBranchByNameIgnoreCaseNotFound(){
        Optional<Branch> branch = branchRepository.findByNameIgnoreCase("Donki");
        assertEquals(branch, Optional.empty());
    }
}