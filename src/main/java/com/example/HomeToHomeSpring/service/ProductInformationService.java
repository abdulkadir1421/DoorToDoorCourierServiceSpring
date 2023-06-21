package com.example.HomeToHomeSpring.service;

import com.example.HomeToHomeSpring.dto.ReportDTO;
import com.example.HomeToHomeSpring.enums.CourierStatus;
import com.example.HomeToHomeSpring.model.ProductInformation;
import com.example.HomeToHomeSpring.repository.ProductInformationDaw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductInformationService {
    @Autowired
    private ProductInformationDaw productInformationDaw;



    public void saveProduct(ProductInformation products,  String username){


            if(products.getId()!=null){
                productInformationDaw.findById(products.getId()).map(old ->{

                    //    SenderVaiable
                    old.setP_senderName(products.getP_senderName());
                    old.setP_senderGender(products.getP_senderGender());
                    old.setP_senderPhone(products.getP_senderPhone());
                    old.setP_senderAddress(products.getP_senderAddress());

                    //    ReciverVariable
                    old.setP_ReceiverName(products.getP_ReceiverName());
                    old.setP_ReceiverGender(products.getP_ReceiverGender());
                    old.setP_ReceiverPhone(products.getP_ReceiverPhone());
                    old.setP_ReceiverAddress(products.getP_ReceiverAddress());

                    //    courier item variable
                    old.setProdcuttype(products.getProdcuttype());
                    old.setProductname(products.getProductname());
                    old.setProductwidth(products.getProductwidth());
                    old.setProductheight(products.getProductheight());
                    old.setProductweight(products.getProductweight());
                    old.setChargeAmount(products.getChargeAmount());
                    old.setPaymentMethod(products.getPaymentMethod());
                    old.setCourierStatus(products.getCourierStatus());
                    old.setUserName(username);


                    return productInformationDaw.save(old);
                });

            }else {
                products.setUserName(username);
                products.setCourierStatus(CourierStatus.Pending);
                productInformationDaw.save(products);
            }

    }

    public void saveProduct(ProductInformation products){
        if(products.getId()!=null){
            productInformationDaw.findById(products.getId()).map(old ->{
                //    SenderVaiable
//                old.setP_senderName(products.getP_senderName());
//                old.setP_senderGender(products.getP_senderGender());
//                old.setP_senderPhone(products.getP_senderPhone());
//                old.setP_senderAddress(products.getP_senderAddress());
//
//                //    ReciverVariable
//                old.setP_ReceiverName(products.getP_ReceiverName());
//                old.setP_ReceiverGender(products.getP_ReceiverGender());
//                old.setP_ReceiverPhone(products.getP_ReceiverPhone());
//                old.setP_ReceiverAddress(products.getP_ReceiverAddress());
//
//                //    courier item variable
//                old.setProdcuttype(products.getProdcuttype());
//                old.setProductname(products.getProductname());
//                old.setProductwidth(products.getProductwidth());
//                old.setProductheight(products.getProductheight());
//                old.setProductweight(products.getProductweight());
//                old.setChargeAmount(products.getChargeAmount());
//                old.setPaymentMethod(products.getPaymentMethod());
                old.setCourierStatus(products.getCourierStatus());
                return productInformationDaw.save(old);
            });

        }

    }




    public void deleteProduct(Long id){
        productInformationDaw.deleteById(id);
    }



    public List<ProductInformation>getAlls(String courierStatus, String username){
        if (username != null){
            return productInformationDaw.findAllByUserName(username);
        }
        if (courierStatus == null) {
            return productInformationDaw.findAll();
        } else {
            return productInformationDaw.findAllByCourierStatus(courierStatus);
        }
    }


    public List<ProductInformation>getAllss(){
        return productInformationDaw.findAll();
    }

    public List<ProductInformation> getById(Long id){
        return productInformationDaw.findAllByUserId(id);
    }



}
