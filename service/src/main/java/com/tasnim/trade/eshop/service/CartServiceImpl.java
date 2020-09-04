package com.tasnim.trade.eshop.service;

import com.tasnim.trade.eshop.api.CartService;
import com.tasnim.trade.eshop.dto.Cart;
import com.tasnim.trade.eshop.dto.Product;
import com.tasnim.trade.eshop.dto.User;
import com.tasnim.trade.eshop.mapper.CartMapper;
import com.tasnim.trade.eshop.mapper.ProductMapper;
import com.tasnim.trade.eshop.mapper.UserMapper;
import com.tasnim.trade.eshop.repository.CartRepository;
import com.tasnim.trade.eshop.service.base.GeneralServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl
        extends GeneralServiceImpl<com.tasnim.trade.eshop.to.Cart, com.tasnim.trade.eshop.dto.Cart>
        implements CartService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    CartRepository repository;

    public CartServiceImpl(CartMapper mapper) {
        super(mapper::fromCart, mapper::toCart);
    }

    @Override
    public JpaRepository<com.tasnim.trade.eshop.to.Cart, Long> getRepository() {
        return repository;
    }

    @Override
    public Cart findByUserAndProduct(User user, Product product) {
        return getMapper().fromEntity(repository.findByUserAndProduct(userMapper.toUser(user), productMapper.toProduct(product)));
    }

    @Override
    public List<Cart> findCartsByUserAndProduct(User user, Product product) {
        return repository.findCartsByUserAndProduct(
                userMapper.toUser(user),
                productMapper.toProduct(product)
        ).stream().map(t -> getMapper().fromEntity(t)).collect(Collectors.toList());
    }
}
