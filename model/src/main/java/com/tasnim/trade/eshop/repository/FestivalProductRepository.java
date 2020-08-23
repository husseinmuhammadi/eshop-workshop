package com.tasnim.trade.eshop.repository;

import com.tasnim.trade.eshop.to.FestivalProduct;
import com.tasnim.trade.eshop.to.TopProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FestivalProductRepository extends JpaRepository<FestivalProduct,Long> {

    @Override
    List<FestivalProduct> findAll();
}
