package com.tasnim.trade.eshop.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequestMapping("/api/v1/orders")
@RestController
public class OrderRestfulService {

    public static final Logger LOGGER = LoggerFactory.getLogger(OrderRestfulService.class);


}
