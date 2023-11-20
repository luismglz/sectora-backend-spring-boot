package com.ruisu.sectorabackend.controller;

import com.ruisu.sectorabackend.entity.Branch;
import com.ruisu.sectorabackend.error.BranchNotFoundException;
import com.ruisu.sectorabackend.service.BranchService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/branches")
public class BranchController {

    @Autowired
    BranchService branchService;

    @GetMapping()
    public List<Branch> findAllBranches(){
        return branchService.findAllBranches();
    }

    @GetMapping(path = "/jpql/{name}")
    public Optional<Branch> findBranchByNameWithJPQL(@PathVariable String name){
        return branchService.findBranchByNameWithJPQL(name);
    }

    @GetMapping(path = "/{name}", params = "name")
    public Optional<Branch> findByName(@PathVariable String name){
        return branchService.findByName(name);
    }

    @GetMapping(path = "/ignoreCase/{name}")
    public Optional<Branch> findByNameIgnoreCase(@PathVariable String name){
        return branchService.findByNameIgnoreCase(name);
    }

    @GetMapping(path = "/{id}")
    public Branch findBranchById(@PathVariable Long id) throws BranchNotFoundException {
        return branchService.findById(id);
    }

    @PostMapping()
    public Branch saveBranch(@Valid @RequestBody Branch branch){
        return branchService.saveBranch(branch);
    }

    @PutMapping("/{id}")
    public Branch updateBranch(@PathVariable Long id, @RequestBody Branch branch){
        return branchService.updateBranch(id, branch);
    }

    @DeleteMapping("/{id}")
    public String deleteBranch(@PathVariable Long id){
        branchService.deleteBranch(id);
        return "Branch has been deleted successfully";
    }

}
