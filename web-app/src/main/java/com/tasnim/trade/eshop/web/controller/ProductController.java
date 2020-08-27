package com.tasnim.trade.eshop.web.controller;

import com.tasnim.trade.eshop.api.ProductService;
import com.tasnim.trade.eshop.api.Service;
import com.tasnim.trade.eshop.dto.Product;
import com.tasnim.trade.eshop.dto.ProductCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/product")
@Controller
public class ProductController extends ControllerBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService service;

    @Override
    public Service getService() {
        return service;
    }

    @Override
    public String index() {
        return "product/index";
    }

    @GetMapping("/entry")
    public String entry(Model model) {
        model.addAttribute("product", new Product());
        return "product/insert";
    }

    @PostMapping("/save")
    public String save(Product product) {
        try {
            LOGGER.info("Saving product");
            Product product1 = service.save(product);
            LOGGER.info("Product {} saved successfully!", product1.getId());
            return "redirect:/product/list";
        } catch (Exception e) {
            LOGGER.error("Error during saving product", e);
            return null;
        }
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable Long id) {
        LOGGER.info("Remove entity id: {}", id);
        service.delete(id);
        return "redirect:/product/list";
    }

    @PostMapping("/remove")
    public String remove(@ModelAttribute(value = "selectedItem") Product product) {
        LOGGER.info("Remove entity entity-id: {}", product.getId());
        service.delete(product);
        return "redirect:/product/list";
    }

    @GetMapping("/fragment/list/category")
    public String findAllByCategory(Model model, @RequestParam("productCategoryId") Optional<Long> categoryId) {
        categoryId.ifPresent(id -> model.addAttribute("products", service.findAllByCategory(new ProductCategory(id))));
        return "fragments/product-list :: all";
    }

    @GetMapping("/fragment/list")
    public String all(Model model) {
        model.addAttribute("products", service.findAll());
        return "fragments/product-modal :: product-select";
    }

    @GetMapping("/profile/{id}")
    public String profile(Model model, @PathVariable Long id) {
        Optional<Product> optional = service.findById(id);
        optional.ifPresentOrElse(product -> model.addAttribute("product", product), new Runnable() {
            @Override
            public void run() {

            }
        });
        return "product/profile";
    }

    @PostMapping("/test")
    public String test(@RequestBody String product) {
        LOGGER.info("product : {}", product);
        return "index";
    }
}

