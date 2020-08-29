package com.tasnim.trade.eshop.api;

import com.tasnim.trade.eshop.dto.Cart;

import java.util.List;

public interface CartService extends Service<Cart> {


    void remove(Cart cart);

}
