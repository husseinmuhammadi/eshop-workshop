package com.tasnim.trade.eshop.web.controller;

import com.tasnim.trade.eshop.api.Service;
import com.tasnim.trade.eshop.api.OrderService;
import com.tasnim.trade.eshop.dto.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/order")
@Controller
public class OrderController extends ControllerBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    OrderService service;



    @GetMapping("/entry")
    public String entry(Model model) {
        model.addAttribute("order", new Order());
        return "order/insert";
    }

    @PostMapping("/save")
    public String save(Order order) {
        Order order1 = service.save(order);
        return "redirect:/order/list";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/order/list";
    }

    @Override
    public Service getService() {
        return service;
    }

    @Override
    public String index() {
        return "order/index";
    }
}