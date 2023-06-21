package com.example.HomeToHomeSpring.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@ToString
@RequiredArgsConstructor
public class BranchModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String branchName;
    private String districtName;
    private String thanaName;
    private String areaName;
    private String email;
    private String phoneNumber;


}
