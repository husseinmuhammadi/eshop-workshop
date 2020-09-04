package com.tasnim.trade.eshop.web.service;

import com.tasnim.trade.eshop.api.ProductCategoryService;
import com.tasnim.trade.eshop.api.ProductService;
import com.tasnim.trade.eshop.dto.Product;
import com.tasnim.trade.eshop.dto.ProductCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequestMapping("/api")
@RestController
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    private final ProductService service;

    @Autowired
    private ProductCategoryService productCategoryService;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/v1/products")
    public ResponseEntity<List<Product>> index(@RequestParam("productCategoryName") Optional<String> productCategoryName) {
        List<Product> products = Collections.emptyList();
        if (productCategoryName.isPresent()) {
            Optional<ProductCategory> productCategory = productCategoryService.findByName(productCategoryName.get());
            if (productCategory.isPresent()) {
                products = service.findAllByCategory(productCategory.get());
            }
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping("/v1/products/top")
    public ResponseEntity<List<Product>> top() {
        return ResponseEntity.ok(service.getTopProducts());
    }

    @GetMapping("/v1/products/festival")
    public ResponseEntity<List<Product>> festival() {
        return ResponseEntity.ok(service.getTopProducts());
    }

    @PostMapping("/v1/products")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return ResponseEntity.ok(service.save(product));
    }

    @GetMapping("/v1/products/{id}")
    public ResponseEntity<Optional<Product>> find(@PathVariable() Long id, @RequestParam("detail") Optional<Boolean> detail) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/v1/products/{id}/related")
    public ResponseEntity<List<Product>> related(@PathVariable() Long id) {
        return ResponseEntity.ok(service.findAll());
    }
}
