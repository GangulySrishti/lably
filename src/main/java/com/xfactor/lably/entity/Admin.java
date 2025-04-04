package com.xfactor.lably.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_admin")
public class Admin {

    @Id
    @GeneratedValue
    private Long Id;
    private String name;
    private String username;
    private String password;
    private String dept;
    public String getName() {
        return name;
    }
    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        this.Id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }
    public String getDept() {
        return dept;
    }
}
