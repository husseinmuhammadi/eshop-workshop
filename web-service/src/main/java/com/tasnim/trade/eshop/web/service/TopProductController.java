package com.tasnim.trade.eshop.web.service;

import com.tasnim.trade.eshop.api.TopProductService;
import com.tasnim.trade.eshop.dto.TopProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopProductController {

    @Autowired
    TopProductService topProductService;

    @PostMapping("/api/v1/admin/top-products")
    public ResponseEntity<TopProduct> save(@RequestBody TopProduct topProduct) {
        return ResponseEntity.ok(topProductService.save(topProduct));
    }
}
