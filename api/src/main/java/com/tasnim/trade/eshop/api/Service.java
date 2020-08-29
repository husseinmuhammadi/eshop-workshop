package com.tasnim.trade.eshop.api;

import com.tasnim.trade.eshop.dto.DtoBase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface Service<T extends DtoBase> {

    Page<T> findAll(Pageable pageable);

    List<T> findAll();

    T save(T dto);

    void delete(Long id);
}
