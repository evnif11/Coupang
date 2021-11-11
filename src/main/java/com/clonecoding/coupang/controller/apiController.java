package com.clonecoding.coupang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class apiController {

    @GetMapping("/")
    public String hello(){
        return "hello world";
    }
}
