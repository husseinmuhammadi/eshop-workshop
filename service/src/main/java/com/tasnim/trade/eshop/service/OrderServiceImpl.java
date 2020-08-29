package com.tasnim.trade.eshop.service;

import com.tasnim.trade.eshop.api.OrderService;
import com.tasnim.trade.eshop.mapper.OrderMapper;
import com.tasnim.trade.eshop.repository.OrderRepository;
import com.tasnim.trade.eshop.service.base.GeneralServiceImpl;
import com.tasnim.trade.eshop.to.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl
        extends GeneralServiceImpl<com.tasnim.trade.eshop.to.Order, com.tasnim.trade.eshop.dto.Order>
        implements OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    OrderRepository repository;

    public OrderServiceImpl(OrderMapper mapper) {
        super(mapper::fromOrder, mapper::toOrder);
    }

    @Override
    public JpaRepository<Order, Long> getRepository() {
        return repository;
    }
}
