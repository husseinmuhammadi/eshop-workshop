package com.tasnim.trade.eshop.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {AuditMapper.class})
public interface TopProductMapper {

    TopProductMapper MAPPER = Mappers.getMapper(TopProductMapper.class);

    com.tasnim.trade.eshop.dto.TopProduct fromTopProduct(com.tasnim.trade.eshop.to.TopProduct topProduct);

    @InheritInverseConfiguration
    com.tasnim.trade.eshop.to.TopProduct toTopProduct(com.tasnim.trade.eshop.dto.TopProduct topProduct);
}
