package com.example.HomeToHomeSpring.repository;

import com.example.HomeToHomeSpring.model.BranchModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchDao extends JpaRepository<BranchModel,Long> {

}
