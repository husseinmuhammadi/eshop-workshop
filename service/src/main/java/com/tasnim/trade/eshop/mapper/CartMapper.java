package com.tasnim.trade.eshop.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface CartMapper {

    com.tasnim.trade.eshop.dto.Cart fromCart(com.tasnim.trade.eshop.to.Cart cart);

    @InheritInverseConfiguration
    com.tasnim.trade.eshop.to.Cart toCart(com.tasnim.trade.eshop.dto.Cart cart);
}
