package com.tasnim.trade.eshop.web.controller;

import com.tasnim.trade.eshop.api.CartService;
import com.tasnim.trade.eshop.api.Service;
import com.tasnim.trade.eshop.api.UserService;
import com.tasnim.trade.eshop.dto.Cart;
import com.tasnim.trade.eshop.dto.DtoBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/cart")
public class CartController extends ControllerBase<Cart> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

    @Autowired
    UserService userService;

    @Autowired
    CartService service;

    @PostMapping(value = "/add")
    public String add(Model model, @RequestParam("productId") Optional<Long> productId) {
        LOGGER.info("product id : {}", productId);
        return "redirect:/cart/all";
    }

    @PostMapping(value = "/save", params = "action=cancel")
    public String cancel(Cart cart, @RequestParam(value = "action") String action) {
        return "card/index";
    }

    @Override
    public Service getService() {
        return service;
    }

    @Override
    public String index() {
        return "cart/all";
    }

    @Override
    public String insert() {
        return "cart/insert";
    }

    @Override
    public String all() {
        return "cart/index";
    }

    @Override
    public String profile() {
        return "card/profile";
    }

    @Override
    public DtoBase getModel() {
        Cart cart = new Cart();
        cart.setUser(userService.findByUsername(getLoggedInUser()));
        return cart;
    }

    @Override
    public String getIndividualModel() {
        return "cart";
    }

    @Override
    public String getCollectionModel() {
        return "carts";
    }
}
