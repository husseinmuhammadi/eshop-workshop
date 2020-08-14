package com.tasnim.trade.eshop.repository;

import com.tasnim.trade.eshop.to.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
