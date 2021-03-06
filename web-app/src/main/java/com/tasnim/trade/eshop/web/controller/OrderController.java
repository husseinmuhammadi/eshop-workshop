package com.tasnim.trade.eshop.web.controller;

import com.tasnim.trade.eshop.api.OrderService;
import com.tasnim.trade.eshop.api.Service;
import com.tasnim.trade.eshop.api.UserService;
import com.tasnim.trade.eshop.dto.DtoBase;
import com.tasnim.trade.eshop.dto.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/order")
@Controller
public class OrderController extends ControllerBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    OrderService service;

    @Autowired
    UserService userService;

    @Override
    public Service getService() {
        return service;
    }

    @Override
    public String index() {
        return "order/index";
    }

    @Override
    public String insert() {
        return "order/insert";
    }

    @Override
    public String all() {
        return null;
    }

    @Override
    public String profile() {
        return "order/profile";
    }

    @Override
    public DtoBase getModel() {
        Order order = new Order();
        order.setUser(userService.findByUsername(getLoggedInUser()));
        return order;
    }

    @Override
    public String getIndividualModel() {
        return "order";
    }

    @Override
    public String getCollectionModel() {
        return "orders";
    }
}
