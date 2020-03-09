package com.tasnim.trade.eshop.service;

import com.tasnim.trade.eshop.repository.ProductRepository;
import com.tasnim.trade.eshop.to.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    ProductRepository repository;

    @Override
    public Product save(Product product) {
        LOGGER.info("Saving product");
        return repository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("Deleting product {}", id);
        repository.deleteById(id);
    }

    @Override
    public void delete(Product product) {
        repository.delete(product);
    }
}