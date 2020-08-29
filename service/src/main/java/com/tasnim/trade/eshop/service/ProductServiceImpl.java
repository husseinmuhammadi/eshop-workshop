package com.tasnim.trade.eshop.service;

import com.tasnim.trade.eshop.api.ProductService;
import com.tasnim.trade.eshop.dto.Product;
import com.tasnim.trade.eshop.dto.ProductCategory;
import com.tasnim.trade.eshop.mapper.CycleAvoidingMappingContext;
import com.tasnim.trade.eshop.mapper.ProductCategoryMapper;
import com.tasnim.trade.eshop.mapper.ProductMapper;
import com.tasnim.trade.eshop.repository.ProductRepository;
import com.tasnim.trade.eshop.service.base.GeneralServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl
        extends GeneralServiceImpl<com.tasnim.trade.eshop.to.Product, com.tasnim.trade.eshop.dto.Product>
        implements ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Autowired
    ProductRepository repository;

    @Override
    public JpaRepository<com.tasnim.trade.eshop.to.Product, Long> getRepository() {
        return repository;
    }

    public ProductServiceImpl(ProductMapper mapper) {
        super(mapper::fromProduct, mapper::toProduct);
    }

    @Override
    public Page<Product> findAllByCategory(ProductCategory productCategory, Pageable pageable) {
        Converter<com.tasnim.trade.eshop.to.Product, com.tasnim.trade.eshop.dto.Product> converter = product -> getMapper().fromEntity(product);
        return repository.findAllByCategory(productCategoryMapper.toProductCategory(productCategory, new CycleAvoidingMappingContext()), pageable).map(converter::convert);
    }

    @Override
    public List<Product> findAllByCategory(ProductCategory productCategory) {
        Converter<com.tasnim.trade.eshop.to.Product, com.tasnim.trade.eshop.dto.Product> converter = product -> getMapper().fromEntity(product);
        return repository.findAllByCategory(productCategoryMapper.toProductCategory(productCategory, new CycleAvoidingMappingContext()))
                .stream().map(converter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getTopProducts() {
        List<com.tasnim.trade.eshop.to.Product> products = repository.findAll();
        LOGGER.info("Number of products: {}", products.size());
        return products.stream().map(getMapper()::fromEntity).collect(Collectors.toList());
    }
}
