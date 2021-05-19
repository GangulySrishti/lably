package com.xfactor.lably.controllers;

import java.util.List;

import com.xfactor.lably.entity.Customer;
import com.xfactor.lably.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/getCustomers")
    public List<Customer> getCustomers(){
        List<Customer> persistedCustomers = customerRepository.findAll();
        return persistedCustomers;
    }

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer c){
        Customer persistedCustomer = customerRepository.save(c);
        return persistedCustomer;
    }

    @GetMapping("/getCustomerName")
    public Customer getCustomerName(@RequestParam String name){
        Customer c = customerRepository.findByName(name);
        return c;
    }

    @GetMapping("/getCustomerAgeAndGender")
    public Customer getCustomerAgeAndGender(@RequestParam String age, @RequestParam String gender){
       Customer c = customerRepository.findByAgeAndGender(age, gender);
       return c;
    }

    @GetMapping("/getListbyAge")
    public List<Customer> getListbyPincode(@RequestParam String age){
       List<Customer> c = customerRepository.getListbyAge(age);
       return c;
    }

    @GetMapping("/deleteCustomerbyId")
    public deleteCustomerbyId(@RequestParam Long id){
        customerRepository.deleteById(id);
    }

    @GetMapping("/deleteCustomerbyName")
    public void deleteCustomerbyName(@RequestParam String name){
        Customer l = customerRepository.findByName(name);
        customerRepository.delete(name);
    }
}
