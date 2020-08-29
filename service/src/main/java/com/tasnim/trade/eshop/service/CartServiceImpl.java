package com.tasnim.trade.eshop.service;

import com.tasnim.trade.eshop.api.CartService;
import com.tasnim.trade.eshop.mapper.CartMapper;
import com.tasnim.trade.eshop.repository.CartRepository;
import com.tasnim.trade.eshop.service.base.GeneralServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl
        extends GeneralServiceImpl<com.tasnim.trade.eshop.to.Cart, com.tasnim.trade.eshop.dto.Cart>
        implements CartService {

    @Autowired
    CartRepository repository;

    public CartServiceImpl(CartMapper mapper) {
        super(mapper::fromCart, mapper::toCart);
    }

    @Override
    public JpaRepository<com.tasnim.trade.eshop.to.Cart, Long> getRepository() {
        return repository;
    }
}
