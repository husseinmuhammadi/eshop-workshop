package com.tasnim.trade.eshop.mapper;

import com.tasnim.trade.eshop.to.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface CardMapper {

    com.tasnim.trade.eshop.dto.Cart fromCart(com.tasnim.trade.eshop.to.Cart cart);

    @InheritInverseConfiguration
    com.tasnim.trade.eshop.to.Cart toCart(com.tasnim.trade.eshop.dto.Cart cart);
}
