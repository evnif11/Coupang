package com.clonecoding.coupang.controller;

import com.clonecoding.coupang.dto.UserCreateDto;
import com.clonecoding.coupang.dto.UserDto;
import com.clonecoding.coupang.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
public class UserApiController {
    private final UserService userService;

    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("userCreateDto", new UserCreateDto());
        return "register";
    }

    @PostMapping("/register")
    public String register(UserCreateDto userCreate){
        userService.create(userCreate);
        return "home";
    }
}
