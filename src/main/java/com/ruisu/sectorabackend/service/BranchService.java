package com.ruisu.sectorabackend.service;

import com.ruisu.sectorabackend.entity.Branch;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface BranchService {
    List<Branch> findAllBranches();
    Branch saveBranch(Branch branch);
    Branch updateBranch(Long id, Branch branch);
    void deleteBranch(Long id);
    Optional<Branch> findBranchByName(String name);
}
