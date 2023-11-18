package com.ruisu.sectorabackend.service;

import com.ruisu.sectorabackend.entity.Branch;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BranchService {
    List<Branch> findAllBranches();
    Branch saveBranch(Branch branch);
    Branch updateBranch(Long id, Branch branch);
    void deleteBranch(Long id);
}
