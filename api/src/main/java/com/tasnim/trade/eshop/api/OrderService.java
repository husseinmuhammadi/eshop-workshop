package com.tasnim.trade.eshop.api;

import com.tasnim.trade.eshop.dto.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService extends Service<Order> {
    Order save(Order order);

    List<Order> findAll();

    void delete(Long id);

    void delete(Order order);

    Optional<Order> findById(Long id);
}
