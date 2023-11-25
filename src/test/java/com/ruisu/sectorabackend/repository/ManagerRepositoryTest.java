package com.ruisu.sectorabackend.repository;

import com.ruisu.sectorabackend.entity.Manager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ManagerRepositoryTest {

    @Autowired
    private ManagerRepository managerRepository;

    @Test
    public void findAllManagers(){
        List<Manager> managerList = managerRepository.findAll();
        System.out.println(managerList);
    }

}