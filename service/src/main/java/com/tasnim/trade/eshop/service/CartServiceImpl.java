package com.tasnim.trade.eshop.service;

import com.tasnim.trade.eshop.api.CartService;
import com.tasnim.trade.eshop.dto.Cart;
import com.tasnim.trade.eshop.mapper.CardMapper;
import com.tasnim.trade.eshop.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CartServiceImpl implements CartService {

    @Autowired
    CardMapper mapper;

    @Autowired
    CartRepository repository;

    @Override
    public Cart save(Cart cart) {
        return mapper.fromCart(repository.save(mapper.toCart(cart)));
    }
}
