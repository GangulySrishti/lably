package com.xfactor.lably.repository;

import com.xfactor.lably.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
    
    Customer findByName(String name);
    Customer findByAgeAndGender(String age, String gender);
    
    @Query("SELECT customer FROM Customer customer WHERE customer.age = :age")
    List<Customer> getListbyAge(String age);
}
