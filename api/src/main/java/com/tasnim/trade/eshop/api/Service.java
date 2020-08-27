package com.tasnim.trade.eshop.api;

import com.tasnim.trade.eshop.dto.DtoBase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Service<T extends DtoBase> {

    Page<T> findAll(Pageable pageable);

    T save(T dto);

    void delete(Long id);
}
