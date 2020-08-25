package com.tasnim.trade.eshop.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    com.tasnim.trade.eshop.dto.Order fromOrder(com.tasnim.trade.eshop.to.Order order);

    @InheritInverseConfiguration
    com.tasnim.trade.eshop.to.Order toOrder(com.tasnim.trade.eshop.dto.Order order);
}
