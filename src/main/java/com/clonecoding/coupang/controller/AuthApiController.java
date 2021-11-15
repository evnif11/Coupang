package com.clonecoding.coupang.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AuthApiController {
    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }
}
