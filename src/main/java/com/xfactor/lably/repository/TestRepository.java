package com.xfactor.lably.repository;

import java.util.List;

import com.xfactor.lably.entity.Tests;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Tests, Long>{
    
    Test findByName(String name);
    List<Tests> findByPrice(String price);
    
}
