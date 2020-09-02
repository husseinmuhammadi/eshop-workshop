package com.tasnim.trade.eshop.web.service;

import com.tasnim.trade.eshop.api.ProductService;
import com.tasnim.trade.eshop.dto.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/api")
@RestController
public class OrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    ProductService productService;

    @GetMapping("/v1/orders")
    public ResponseEntity<List<Product>> getUserOrders(@RequestParam("userId") String userId) {
        LOGGER.info("Getting orders for user {}", userId);
        // Get user from security context
        List<Product> products = productService.findAll();
        return ResponseEntity.ok(products);
    }
}