package com.tasnim.trade.eshop.web.controller;

import com.tasnim.trade.eshop.api.OrderService;
import com.tasnim.trade.eshop.api.ProductService;
import com.tasnim.trade.eshop.dto.Order;
import com.tasnim.trade.eshop.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequestMapping("/order")
@Controller
public class OrderController {

    @Autowired
    OrderService service;

    @GetMapping("/list")
    public String index(Model model,
                        @RequestParam("page") Optional<Integer> page,
                        @RequestParam("size") Optional<Integer> size) {

        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        Page<Order> orderPage = service.findAll(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("orderPage", orderPage);
        int totalPages = orderPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream
                    .rangeClosed(1, totalPages)
                    .boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "order/index";
    }
}
