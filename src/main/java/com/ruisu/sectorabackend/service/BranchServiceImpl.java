package com.ruisu.sectorabackend.service;


import com.ruisu.sectorabackend.entity.Branch;
import com.ruisu.sectorabackend.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    BranchRepository branchRepository;


    @Override
    public List<Branch> findAllBranches() {
        return branchRepository.findAll();
    }
}
