package com.tasnim.trade.eshop.repository;

import com.tasnim.trade.eshop.to.Cart;
import com.tasnim.trade.eshop.to.Product;
import com.tasnim.trade.eshop.to.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUserAndProduct(User user, Product product);

    List<Cart> findCartsByUserAndProduct(User user, Product product);
}
