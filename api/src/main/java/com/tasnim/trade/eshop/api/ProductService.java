package com.tasnim.trade.eshop.api;

import com.tasnim.trade.eshop.dto.Product;
import com.tasnim.trade.eshop.dto.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService extends Service<Product> {

    Product save(Product product);

    List<Product> findAll();



    Page<Product> findAllByCategory(ProductCategory productCategory, Pageable pageable);

    List<Product> findAllByCategory(ProductCategory productCategory);

    void delete(Long id);

    void delete(Product product);

    List<Product> getTopProducts();

}
