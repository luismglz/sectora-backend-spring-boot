package com.ruisu.sectorabackend.service;


import com.ruisu.sectorabackend.entity.Branch;
import com.ruisu.sectorabackend.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    BranchRepository branchRepository;


    @Override
    public List<Branch> findAllBranches() {
        return branchRepository.findAll();
    }

    @Override
    public Branch saveBranch(Branch branch) {
        return branchRepository.save(branch);
    }

    @Override
    public Branch updateBranch(Long id, Branch updatedBranch) {
        Branch branchToUpdate = branchRepository.findById(id).get();

        if(Objects.nonNull(updatedBranch.getName()) && !"".equalsIgnoreCase(updatedBranch.getName())){
            branchToUpdate.setName(updatedBranch.getName());
        }

        if(Objects.nonNull(updatedBranch.getAddress()) && !"".equalsIgnoreCase(updatedBranch.getAddress())){
            branchToUpdate.setAddress(updatedBranch.getAddress());
        }

        if(Objects.nonNull(updatedBranch.getTelephone()) && !"".equalsIgnoreCase(updatedBranch.getTelephone())){
            branchToUpdate.setTelephone(updatedBranch.getTelephone());
        }

        return branchRepository.save(branchToUpdate);
    }

    @Override
    public void deleteBranch(Long id) {
        branchRepository.deleteById(id);
    }

    @Override
    public Optional<Branch> findBranchByName(String name) {
        return branchRepository.findBranchByName(name);
    }
}
