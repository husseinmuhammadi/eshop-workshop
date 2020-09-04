package com.tasnim.trade.eshop.api;

import com.tasnim.trade.eshop.dto.Cart;
import com.tasnim.trade.eshop.dto.Product;
import com.tasnim.trade.eshop.dto.User;

import java.util.List;

public interface CartService extends Service<Cart> {

    Cart findByUserAndProduct(User user, Product product);

    List<Cart> findCartsByUserAndProduct(User user, Product product);
}
