package com.example.HomeToHomeSpring.controller;

import com.example.HomeToHomeSpring.model.BranchModel;
import com.example.HomeToHomeSpring.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class BranchController {



    @Autowired
    BranchService branchService;
    @GetMapping("/getBranch")
    public List<BranchModel> getAll(){
        return branchService.getAll();
    }

    @PostMapping("/postBranch")
    public void newPost(@RequestBody BranchModel branchModel) {
        branchService.save(branchModel);
    }


    @PutMapping("/updateBranch")
    public void update(@RequestBody BranchModel branchModel){
        branchService.save(branchModel);
    }

    @DeleteMapping("/deleteBranch/{id}")
    public void deletes(@PathVariable("id") Long id){
        branchService.del(id);
    }



    @GetMapping("/getBranch/{id}")
    public BranchModel getById(@PathVariable("id") Long id){
        return branchService.getById(id);
    }

}
