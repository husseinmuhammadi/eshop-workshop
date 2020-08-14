package com.tasnim.trade.eshop.web.controller;

import com.tasnim.trade.eshop.dto.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {

    @GetMapping("/entry")
    public String entry(Model model) {
        model.addAttribute("card", new Cart());
        return "cart/insert";
    }

    @PostMapping("/save")
    public String add(Cart cart) {
        return "cart/insert";
    }
}
