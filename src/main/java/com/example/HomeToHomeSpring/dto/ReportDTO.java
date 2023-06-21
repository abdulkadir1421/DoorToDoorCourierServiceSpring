package com.example.HomeToHomeSpring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDTO {


    private String p_sender_name;
    private String  p_sender_address;

    private String p_receiver_name;

    private String p_receiver_address;
}
