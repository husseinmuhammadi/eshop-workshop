package com.tasnim.trade.eshop.web.controller;

import com.tasnim.trade.eshop.api.CartService;
import com.tasnim.trade.eshop.api.UserService;
import com.tasnim.trade.eshop.dto.Cart;
import com.tasnim.trade.eshop.type.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cart")
public class CartController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

    @Autowired
    UserService userService;

    @Autowired
    CartService service;

    @GetMapping("/entry")
    public String entry(Model model) {
        Cart cart = new Cart();
        cart.setUser(userService.findByUsername(getLoggedInUser()));
        model.addAttribute("cart", cart);
        return "cart/insert";
    }

    @PostMapping(value = "/save")
    public String add(Cart cart, Model model) {
        service.save(cart);

        List<Cart> carts = service.findAll();
        model.addAttribute("carts", carts);
        return "redirect:/cart/all";
    }

    @PostMapping(value = "/add")
    public String add(Model model, @RequestParam("productId") Optional<Long> productId) {
        LOGGER.info("product id : {}", productId);
        return "redirect:/cart/all";
    }

    @PostMapping(value = "/save", params = "action=cancel")
    public String cancel(Cart cart, @RequestParam(value = "action") String action) {

        return "card/index";
    }

    @GetMapping("/all")
    public String all(Model model) {
        List<Cart> carts = service.findAll();
        model.addAttribute("carts", carts);
        return "cart/index";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable Long id) {
        LOGGER.info("Remove entity id: {}", id);
        service.remove(id);
        return "redirect:/cart/all";
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
