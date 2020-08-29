package com.tasnim.trade.eshop.service;

import com.tasnim.trade.eshop.api.CartService;
import com.tasnim.trade.eshop.dto.Cart;
import com.tasnim.trade.eshop.mapper.CardMapper;
import com.tasnim.trade.eshop.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CardMapper mapper;

    @Autowired
    CartRepository repository;

    @Override
    public Page<Cart> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Cart save(Cart cart) {
        return mapper.fromCart(repository.save(mapper.toCart(cart)));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Cart> findById(Long id) {
        return repository.findById(id).map(mapper::fromCart);
    }

    @Override
    public List<Cart> findAll() {
        return repository.findAll().stream().map(mapper::fromCart).collect(Collectors.toList());
    }

    @Override
    public void remove(Cart cart) {
        repository.delete(mapper.toCart(cart));
    }
}
