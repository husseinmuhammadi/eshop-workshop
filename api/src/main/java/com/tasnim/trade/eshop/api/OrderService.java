package com.tasnim.trade.eshop.api;

import com.tasnim.trade.eshop.dto.Order;

public interface OrderService extends Service<Order> {
    void delete(Order order);
}
