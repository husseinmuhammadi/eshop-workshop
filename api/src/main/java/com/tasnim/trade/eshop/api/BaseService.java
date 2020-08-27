package com.tasnim.trade.eshop.api;

import com.tasnim.trade.eshop.dto.DtoBase;
import com.tasnim.trade.eshop.dto.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseService<T extends DtoBase> {

    Page<T> findAll(Pageable pageable);

}
