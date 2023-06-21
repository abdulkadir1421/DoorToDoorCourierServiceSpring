package com.example.HomeToHomeSpring.repository;

import com.example.HomeToHomeSpring.model.ProductInformation;
import com.example.HomeToHomeSpring.model.Role;
import com.example.HomeToHomeSpring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleDao extends JpaRepository<Role, String> {

//    @Query(value = "select * from user_role where role_id = :roleName ", nativeQuery = true)
//    List<Role> findbyRoleName(@Param("roleName") String roleName);


}
