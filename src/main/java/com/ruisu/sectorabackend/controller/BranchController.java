package com.ruisu.sectorabackend.controller;

import com.ruisu.sectorabackend.entity.Branch;
import com.ruisu.sectorabackend.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/")
public class BranchController {

    @Autowired
    BranchService branchService;

    @GetMapping("/branches")
    public List<Branch> findAllBranches(){
        return branchService.findAllBranches();
    }
}
