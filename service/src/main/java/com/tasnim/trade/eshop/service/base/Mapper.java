package com.tasnim.trade.eshop.service.base;

import com.tasnim.trade.eshop.dto.DtoBase;
import com.tasnim.trade.eshop.to.EntityBase;

interface Mapper<T extends EntityBase, R extends DtoBase> {

    R fromEntity(T entity);

    T toEntity(R dto);
}
