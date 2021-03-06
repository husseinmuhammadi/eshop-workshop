package com.tasnim.trade.eshop.web.controller;

import com.tasnim.trade.eshop.api.ProductService;
import com.tasnim.trade.eshop.api.Service;
import com.tasnim.trade.eshop.dto.DtoBase;
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

    @Override
    public String insert() {
        return "product/insert";
    }

    @Override
    public String all() {
        return null;
    }

    @Override
    public String profile() {
        return "product/profile";
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
    public String modal(Model model) {
        model.addAttribute("products", service.findAll());
        return "fragments/product-modal :: product-select";
    }

    @Override
    public DtoBase getModel() {
        return new Product();
    }

    @Override
    public String getIndividualModel() {
        return "product";
    }

    @Override
    public String getCollectionModel() {
        return "products";
    }
}

