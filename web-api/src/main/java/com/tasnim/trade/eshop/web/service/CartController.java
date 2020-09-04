package com.tasnim.trade.eshop.web.service;

import com.tasnim.trade.eshop.api.CartService;
import com.tasnim.trade.eshop.dto.Cart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/api")
@RestController
public class CartController extends ControllerBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

    @Autowired
    CartService service;

    @PostMapping("/v1/carts")
    public ResponseEntity<Cart> save(@RequestBody Cart cart) {
        List<Cart> list = service.findCartsByUserAndProduct(cart.getUser(), cart.getProduct());
        if (!list.isEmpty())
            cart.setId(list.get(0).getId());
        printJson(cart);
        return ResponseEntity.ok(service.save(cart));
    }
}
