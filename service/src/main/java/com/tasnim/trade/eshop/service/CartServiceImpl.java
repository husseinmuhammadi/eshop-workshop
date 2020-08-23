package com.tasnim.trade.eshop.service;

import com.tasnim.trade.eshop.api.CartService;
import com.tasnim.trade.eshop.dto.Cart;
import com.tasnim.trade.eshop.mapper.CardMapper;
import com.tasnim.trade.eshop.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CardMapper mapper;

    @Autowired
    CartRepository repository;

    @Override
    public Cart save(Cart cart) {
        return mapper.fromCart(repository.save(mapper.toCart(cart)));
    }

    @Override
    public List<Cart> findAll() {
        return repository.findAll().stream().map(mapper::fromCart).collect(Collectors.toList());
    }

    @Override
    public void remove(Cart cart){
        repository.delete(mapper.toCart(cart));
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
