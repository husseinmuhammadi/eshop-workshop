package com.tasnim.trade.eshop.repository;

import com.tasnim.trade.eshop.to.TopProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopProductRepository extends JpaRepository<TopProduct,Long> {

    @Override
    List<TopProduct> findAll();


}
