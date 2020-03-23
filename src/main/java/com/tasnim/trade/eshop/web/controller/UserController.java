package com.tasnim.trade.eshop.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserController {
    @GetMapping("/registration")
    public String registration() {
        return "user/registration";
    }
}
