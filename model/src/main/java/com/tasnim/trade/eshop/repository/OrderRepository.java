package com.tasnim.trade.eshop.repository;

import com.tasnim.trade.eshop.to.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
