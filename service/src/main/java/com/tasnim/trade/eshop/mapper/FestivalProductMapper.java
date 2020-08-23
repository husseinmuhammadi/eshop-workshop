package com.tasnim.trade.eshop.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {AuditMapper.class})
public interface FestivalProductMapper {

    FestivalProductMapper MAPPER = Mappers.getMapper(FestivalProductMapper.class);

    com.tasnim.trade.eshop.dto.FestivalProduct fromFestivalProduct(com.tasnim.trade.eshop.to.FestivalProduct festivalProduct);

    @InheritInverseConfiguration
    com.tasnim.trade.eshop.to.FestivalProduct toFestivalProduct(com.tasnim.trade.eshop.dto.FestivalProduct festivalProduct);
}
