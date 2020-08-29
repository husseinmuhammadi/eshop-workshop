package com.tasnim.trade.eshop.service;

import com.tasnim.trade.eshop.api.OrderDetailService;
import com.tasnim.trade.eshop.mapper.OrderDetailMapper;
import com.tasnim.trade.eshop.repository.OrderDetailRepository;
import com.tasnim.trade.eshop.service.base.GeneralServiceImpl;
import com.tasnim.trade.eshop.to.OrderDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl
        extends GeneralServiceImpl<com.tasnim.trade.eshop.to.OrderDetail, com.tasnim.trade.eshop.dto.OrderDetail>
        implements OrderDetailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderDetailServiceImpl.class);

    @Autowired
    OrderDetailRepository repository;

    public OrderDetailServiceImpl(OrderDetailMapper mapper) {
        super(mapper::fromOrderDetail, mapper::toOrderDetail);
    }

    @Override
    public JpaRepository<OrderDetail, Long> getRepository() {
        return repository;
    }
}
