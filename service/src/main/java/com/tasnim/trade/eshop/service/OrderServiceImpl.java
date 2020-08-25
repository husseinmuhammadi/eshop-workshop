package com.tasnim.trade.eshop.service;

import com.tasnim.trade.eshop.api.OrderService;
import com.tasnim.trade.eshop.api.ProductService;
import com.tasnim.trade.eshop.dto.Order;
import com.tasnim.trade.eshop.dto.Product;
import com.tasnim.trade.eshop.dto.ProductCategory;
import com.tasnim.trade.eshop.mapper.CycleAvoidingMappingContext;
import com.tasnim.trade.eshop.mapper.OrderMapper;
import com.tasnim.trade.eshop.mapper.ProductCategoryMapper;
import com.tasnim.trade.eshop.mapper.ProductMapper;
import com.tasnim.trade.eshop.repository.OrderRepository;
import com.tasnim.trade.eshop.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderMapper mapper;

    @Autowired
    OrderRepository repository;

    @Override
    public Order save(Order order) {
        return mapper.fromOrder(repository.save(mapper.toOrder(order)));
    }

    @Override
    public List<Order> findAll() {
        return repository.findAll().stream().map(mapper::fromOrder).collect(Collectors.toList());
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        Converter<com.tasnim.trade.eshop.to.Order, com.tasnim.trade.eshop.dto.Order> converter = order -> mapper.fromOrder(order);
        return repository.findAll(pageable).map(converter::convert);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Order order) {
        repository.delete(mapper.toOrder(order));
    }

    @Override
    public Optional<Order> findById(Long id) {
        return repository.findById(id).map(mapper::fromOrder);
    }
}
