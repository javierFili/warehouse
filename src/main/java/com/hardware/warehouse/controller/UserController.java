package com.hardware.warehouse.controller;


import com.hardware.warehouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String listOfAllUsers(Model model) {
        model.addAttribute("users",userService.findAllUsers());
        return "/user/index";
    }
}
