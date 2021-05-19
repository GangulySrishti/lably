package com.xfactor.lably.controllers;

import java.util.List;

import com.xfactor.lably.entity.Admin;
import com.xfactor.lably.entity.Tests;
import com.xfactor.lably.repository.AdminRepository;
import com.xfactor.lably.repository.TestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tests")
public class TestsController {

    @Autowired
    TestRepository testrepo;

    @GetMapping("/getTests")
    public List<Tests> getTests(){
        List<Tests> persistedTests = testrepo.findAll();
        return persistedTests;
    }

    @PostMapping("/addTests")
    public Tests addTests(@RequestBody Tests t){
        Tests persistedTest = testrepo.save(t);
        return persistedTest;
    }

    @GetMapping("/getTestsName")
    public Tests getTestsName(@RequestParam String name){
        Tests test = testrepo.findByName(name);
        return test;
    }

    @GetMapping("/getListbyPrice")
    public List<Tests> findByPrice(@RequestParam String price){
        List<Tests> test = testrepo.findByPrice(price);
        return test;
    }

    @GetMapping("/deleteTestbyId")
    public void deleteTestbyId(@RequestParam Long id){
        testrepo.deleteById(id);
    }

    @GetMapping("/deleteTestbyName")
    public void deleteTestbyName(@RequestParam String name){
        Tests t = testrepo.findByName(name);
        testrepo.delete(t);
    }
}