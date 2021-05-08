package com.xfactor.lably.controllers;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Controller")
public class Controllerexamples {
    
    @GetMapping("/example")
    public String example(){
        return "This is just an example of get mapping controller.";
    }

    @GetMapping("/hashmap example")
    public HashMap<String, String> example1(@RequestParam String name, @RequestParam String city){
        HashMap<String,String> h = new HashMap<>();
        h.put("name", name);
        h.put("city", city);
        return h;
    }
}
