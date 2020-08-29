package com.tasnim.trade.eshop.api;

import com.tasnim.trade.eshop.dto.Product;
import com.tasnim.trade.eshop.dto.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService extends Service<Product> {
    Page<Product> findAllByCategory(ProductCategory productCategory, Pageable pageable);

    List<Product> findAllByCategory(ProductCategory productCategory);

    List<Product> getTopProducts();
}
