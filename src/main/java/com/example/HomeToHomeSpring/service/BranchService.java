package com.example.HomeToHomeSpring.service;

import com.example.HomeToHomeSpring.model.BranchModel;
import com.example.HomeToHomeSpring.repository.BranchDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {

    @Autowired
    BranchDao branchDao;

    public List<BranchModel> getAll(){
        return branchDao.findAll();
    }
    public void save(BranchModel branchModel){
        if(branchModel.getId()!=null){
            branchDao.findById(branchModel.getId()).map(old ->{
                old.setBranchName(branchModel.getBranchName());
                old.setDistrictName(branchModel.getDistrictName());
                old.setThanaName(branchModel.getThanaName());
                old.setAreaName(branchModel.getAreaName());
                old.setEmail(branchModel.getEmail());
                old.setPhoneNumber(branchModel.getPhoneNumber());
                return branchDao.save(old);

            });


        }else {
            branchDao.save(branchModel);
        }
    }
    public BranchModel getById(Long id){
        return branchDao.findById(id).orElse(new BranchModel());
    }

    public void del(Long id){
        branchDao.deleteById(id);
    }


}
