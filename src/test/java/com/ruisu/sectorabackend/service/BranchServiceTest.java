package com.ruisu.sectorabackend.service;

import com.ruisu.sectorabackend.entity.Branch;
import com.ruisu.sectorabackend.repository.BranchRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BranchServiceTest {

    @Autowired
    private BranchService branchService;

    @MockBean
    private BranchRepository branchRepository;

    @BeforeEach
    void setUp() {
        Branch branch = Branch.builder()
                .id(2L)
                .name("PLATINUM Don Quijote Shirokanedai")
                .address("3-15-5 Shirokanedai Minato-Ku Tokyo, JAPAN, 108-0071")
                .telephone("0570-063-511")
                .build();

        Mockito
                .when(branchRepository.findByNameIgnoreCase("PLATINUM Don Quijote Shirokanedai"))
                .thenReturn(Optional.of(branch));
    }

    @Test
    @DisplayName("Test to obtain information from a branch by sending a valid name")
    public void findByNameIgnoreCaseShouldFound(){
        String branchName = "PLATINUM Don Quijote Shirokanedai";
        Branch branch = branchService.findByNameIgnoreCase(branchName).get();

        assertEquals(branchName, branch.getName());
        System.out.println("branch: "+branch);


    }
}