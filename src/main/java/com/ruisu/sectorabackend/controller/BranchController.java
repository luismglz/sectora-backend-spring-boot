package com.ruisu.sectorabackend.controller;

import com.ruisu.sectorabackend.entity.Branch;
import com.ruisu.sectorabackend.service.BranchService;
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

    @GetMapping(params = "name",path = "/{name}")
    public Optional<Branch> findBranchByName(@PathVariable Optional<String> name){
        return branchService.findBranchByName(name.get());
    }

    @PostMapping()
    public Branch saveBranch(@RequestBody Branch branch){
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
