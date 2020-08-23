package com.tasnim.trade.eshop.api;

import com.tasnim.trade.eshop.dto.Cart;

import java.util.List;

public interface CartService {
    Cart save(Cart cart);

    List<Cart> findAll();

    void remove(Cart cart);

    void remove(Long id);
}
