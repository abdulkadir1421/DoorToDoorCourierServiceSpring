package com.example.HomeToHomeSpring.repository;

import com.example.HomeToHomeSpring.model.ProductInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductInformationDaw extends JpaRepository<ProductInformation,Long> {



    @Query(value = "select * from product_information where courier_status = :courierStatus ", nativeQuery = true)
    List<ProductInformation> findAllByCourierStatus(@Param("courierStatus") String courierStatus);


    @Query(value = "select * from product_information where user_name = :userName ", nativeQuery = true)
    List<ProductInformation> findAllByUserName(@Param("userName") String userName);


    @Query(value = "select * from product_information where id = :id ", nativeQuery = true)
    List<ProductInformation> findAllByUserId(@Param("id") Long id);


}
