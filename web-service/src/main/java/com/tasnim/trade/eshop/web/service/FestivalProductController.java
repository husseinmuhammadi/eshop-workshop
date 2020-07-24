package com.tasnim.trade.eshop.web.service;

import com.tasnim.trade.eshop.api.FestivalProductService;
import com.tasnim.trade.eshop.api.TopProductService;
import com.tasnim.trade.eshop.dto.FestivalProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FestivalProductController {

    @Autowired
    FestivalProductService festivalProductService;

    @PostMapping("/api/v1/festival-products")
    public ResponseEntity<FestivalProduct> save(@RequestBody FestivalProduct festivalProduct) {
        return ResponseEntity.ok(festivalProductService.save(festivalProduct));
    }
}
