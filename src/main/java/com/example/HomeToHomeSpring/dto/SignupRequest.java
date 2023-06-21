package com.example.HomeToHomeSpring.dto;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class SignupRequest {


    private String username;
    private String userfullname;
    private String email;
    private String password;

}

