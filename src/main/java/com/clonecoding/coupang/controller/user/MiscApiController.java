package com.clonecoding.coupang.controller.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MiscApiController {
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
