package com.xfactor.lably.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.xfactor.lably.entity.Admin;
import com.xfactor.lably.repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    AdminRepository adminrepo;

    @GetMapping("/getAdmins")
    public List<Admin> getAdmins() {
        List<Admin> persistedAdmins = adminrepo.findAll();
        return persistedAdmins;
    }

    @PostMapping("/addAdmin")
    public Admin addAdmins(@RequestBody Admin t) {
        Admin persistedAdmin = adminrepo.save(t);
        return persistedAdmin;
    }

    @GetMapping("/getAdminUserName")
    public Admin getAdminName(@RequestParam String un){
        Admin admin = adminrepo.findByUsername(un);
        return admin;
    }

    @GetMapping("/getAdminUserNameAndPassword")
    public Admin getAdminName(@RequestParam String un, @RequestParam String pwd){
        Admin admin = adminrepo.findByUsernameAndPassword(un, pwd);
        return admin;
    }

    @GetMapping("/getAdminDeptList")
    public List<Admin> getAdminDeptList(@RequestParam String dept){
        List<Admin> admin = adminrepo.retrieveDept(dept);
        return admin;
    }

    @GetMapping("/deleteAdminbyId")
    public void deleteAdminbyId(@RequestParam Long id){
        adminrepo.deleteById(id);
    }

    @GetMapping("/deleteAdminbyUsername")
    public void deleteAdminbyUsername(@RequestParam String un){
        Admin ad = adminrepo.findByUsername(un);
        adminrepo.delete(ad);
    }
}