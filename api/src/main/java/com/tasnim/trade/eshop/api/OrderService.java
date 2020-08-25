package com.tasnim.trade.eshop.api;

import com.tasnim.trade.eshop.dto.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order save(Order order);

    List<Order> findAll();

    Page<Order> findAll(Pageable pageable);

    void delete(Long id);

    void delete(Order product);

    Optional<Order> findById(Long id);
}
