package com.example.HomeToHomeSpring.controller;

import com.example.HomeToHomeSpring.dto.ReportDTO;
import com.example.HomeToHomeSpring.model.BranchModel;
import com.example.HomeToHomeSpring.model.ProductInformation;
import com.example.HomeToHomeSpring.service.ProductInformationService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/courier")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class ProductInformationController {
 @Autowired
 ProductInformationService p_service;

    @PostMapping("/Postcourier")
    public void newPost(@RequestBody ProductInformation product, @RequestParam(value = "userName") String username) {
        p_service.saveProduct(product, username);
    }

    @GetMapping("/getCourierList")
    public List<ProductInformation> getAll(@RequestParam(value = "courierStatus", required = false) String courierStatus,@RequestParam(value = "userName", required = false) String username ){
        return p_service.getAlls(courierStatus,username);
    }



    @PutMapping("/Update")
    public void update(@RequestBody ProductInformation product, @RequestParam(value = "userName") String username){
        p_service.saveProduct(product, username);
    }


    @PutMapping("/Updates")
    public void updates(@RequestBody ProductInformation product){
        p_service.saveProduct(product);
    }


    @DeleteMapping("/{id}")
    public void deletedProduct(@PathVariable("id") Long id){
        p_service.deleteProduct(id);

    }




    @GetMapping(value = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> downloadInvoice(@RequestParam (value = "id") Long id) throws JRException, IOException {

    List<ProductInformation> productInformations =new ArrayList<>();

        System.out.println(id);
        productInformations= p_service.getById(id);
     List<ReportDTO> reportDTOS  = new ArrayList<>();
        productInformations.forEach(productInformation -> {
            ReportDTO reportDTO = new ReportDTO();
            reportDTO.setP_receiver_name(productInformation.getP_ReceiverName());
            reportDTO.setP_sender_address(productInformation.getP_senderAddress());
            reportDTO.setP_receiver_address(productInformation.getP_ReceiverAddress());
            reportDTO.setP_sender_name(productInformation.getP_senderName());
            reportDTOS.add(reportDTO);

        });


        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(

//                Arrays.asList(
//                new ReportDTO( "Keyboard","sdsdf","dsfdsfds","dfdfd"),
//                new ReportDTO( "Keyboard","sdsdf","dsfdsfds","dfdfd"),
//                new ReportDTO( "Keyboard","sdsdf","dsfdsfds","dfdfd"),
//                new ReportDTO( "Keyboard","sdsdf","dsfdsfds","dfdfd")
//        )

                reportDTOS
                , false);

        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("total", "7000");

        JasperReport compileReport = JasperCompileManager
                .compileReport(new FileInputStream("src/main/resources/CourierReports.jrxml"));

        JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, parameters, beanCollectionDataSource);

        // JasperExportManager.exportReportToPdfFile(jasperPrint,
        // System.currentTimeMillis() + ".pdf");

        byte data[] = JasperExportManager.exportReportToPdf(jasperPrint);

        System.err.println(data);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
    }








}
