package com.tasnim.trade.eshop.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderDetailMapper {

    com.tasnim.trade.eshop.dto.OrderDetail fromOrderDetail(com.tasnim.trade.eshop.to.OrderDetail orderDetail);

    @InheritInverseConfiguration
    com.tasnim.trade.eshop.to.OrderDetail toOrderDetail(com.tasnim.trade.eshop.dto.OrderDetail orderDetail);
}
