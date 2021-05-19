package com.xfactor.lably.repository;

import java.util.List;

import com.xfactor.lably.entity.Lab;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

public interface LabRepository extends JpaRepository<Lab, Long>{

    Lab findByName(String name);
    List<Lab> findByAddressAndPincode(String address, String pincode);
    
    @Query("SELECT lab FROM Lab lab WHERE lab.pincode = :pincode")
    List<Lab> getListbyPincode(String pincode);

}
