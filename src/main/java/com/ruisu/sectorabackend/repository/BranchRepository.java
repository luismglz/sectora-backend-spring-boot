package com.ruisu.sectorabackend.repository;

import com.ruisu.sectorabackend.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BranchRepository extends JpaRepository<Branch, Long> {


    //JPQL (Java Persistance Query Language) is used to make the query
    @Query("SELECT b FROM Branch b WHERE b.name = :name")
    Optional<Branch> findBranchByNameWithJPQL(String name);

    //Inversion of Control (IoC)
    Optional<Branch> findByName(String name);

    Optional<Branch> findByNameIgnoreCase(String name);


}
