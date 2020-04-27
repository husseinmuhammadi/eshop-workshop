package com.tasnim.trade.eshop.web.service;

import com.tasnim.trade.eshop.api.ProductService;
import com.tasnim.trade.eshop.dto.Response;
import com.tasnim.trade.eshop.dto.SuccessfulResponse;
import com.tasnim.trade.eshop.to.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/api/v1/products")
@RestController
public class ProductRestfulService {

    private final ProductService service;

    public ProductRestfulService(ProductService service) {
        this.service = service;
    }

    @GetMapping("/top")
    public ResponseEntity<Response> getTopProducts() {
        List<Product> products = service.getTopProducts();
        return new ResponseEntity<>(new SuccessfulResponse<>(products), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> save(@RequestBody Product product) {
        Product product1 = service.save(product);
        return ResponseEntity.ok(new SuccessfulResponse<>(product1));
    }
}
