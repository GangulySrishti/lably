package com.xfactor.lably.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.xfactor.lably.entity.Lab;
import com.xfactor.lably.repository.LabRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/lab")
public class LabController {

    @Autowired
    LabRepository labrepo;

    @GetMapping("/getLabs")
    public List<Lab> getLabs() {
        List<Lab> persistedLabs = labrepo.findAll();
        return persistedLabs;
    }

    @PostMapping("/addLab")
    public Lab addLabs(@RequestBody Lab l) {
        Lab persistedLab = labrepo.save(l);
        return persistedLab;
    }

    @GetMapping("/getLabName")
    public Lab getLabName(@RequestParam String name){
       Lab l = labrepo.findByName(name);
       return l;
    }

    @GetMapping("/getLabAddressAndPincode")
    public List<Lab> getLabAddressAndPincode(@RequestParam String address, @RequestParam String pincode){
       List<Lab> l = labrepo.findByAddressAndPincode(address, pincode);
       return l;
    }

    @GetMapping("/getListbyPincode")
    public List<Lab> getListbyPincode(@RequestParam String pincode){
       List<Lab> l = labrepo.getListbyPincode(pincode);
       return l;
    }

    @GetMapping("/deleteLabbyId")
    public void deleteLabbyId(@RequestParam Long id){
        labrepo.deleteById(id);
    }

    @GetMapping("/deleteLabbyName")
    public void deleteLabbyName(@RequestParam String name){
        Lab l = labrepo.findByName(name);
        labrepo.delete(l);
    }
}