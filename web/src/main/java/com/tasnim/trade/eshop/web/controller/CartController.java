package com.tasnim.trade.eshop.web.controller;

import com.tasnim.trade.eshop.api.UserService;
import com.tasnim.trade.eshop.dto.Cart;
import com.tasnim.trade.eshop.type.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    UserService service;

    @GetMapping("/entry")
    public String entry(Model model) {
        Cart cart = new Cart();
        cart.setUser(service.findByUsername(getLoggedInUser()));
        model.addAttribute("cart", cart);
        return "cart/insert";
    }

//    @PostMapping(value = "/save", params = "action=save")
    @PostMapping(value = "/save")
    public String add(Cart cart, @RequestParam(value="action") String action) {

        return "card/index";
    }

    @PostMapping(value = "/save", params = "action=cancel")
    public String cancel(Cart cart) {

        return "card/index";
    }

    private String getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() != null) {
            if (authentication.getPrincipal() instanceof Principal) {
                Principal principal = (Principal) authentication.getPrincipal();
                return principal.getUsername();
            }
        }
        return null;
    }
}
