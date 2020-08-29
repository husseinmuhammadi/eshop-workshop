package com.tasnim.trade.eshop.api;

import com.tasnim.trade.eshop.dto.DtoBase;
import com.tasnim.trade.eshop.dto.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface Service<T extends DtoBase> {

    Page<T> findAll(Pageable pageable);

    List<T> findAll();

    T save(T dto);

    void delete(Long id);

    Optional<T> findById(Long id);
}
