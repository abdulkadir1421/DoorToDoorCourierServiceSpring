package com.example.HomeToHomeSpring.model;

import com.example.HomeToHomeSpring.enums.CourierStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductInformation extends BaseModel{


//    SenderVaiable
    private String p_senderName;
    private String p_senderGender;
    private String  p_senderPhone;
    private String  p_senderAddress;

//    ReciverVariable
    private String p_ReceiverName;
    private String p_ReceiverGender;
    private String  p_ReceiverPhone;
    private String p_ReceiverAddress;

//    courier item variable
    private String prodcuttype;
    private String productname;
    private Long productwidth;
    private Long productheight;
    private Long productweight;
    private Long chargeAmount;
    private String paymentMethod;
    private String userName;

//    @Column(updatable = false)
//    @CreationTimestamp
//    private LocalDateTime possibleDeliveredTime= getCreatedBy().plusDays(1)


    @Enumerated(EnumType.STRING)
    private CourierStatus courierStatus;


}
