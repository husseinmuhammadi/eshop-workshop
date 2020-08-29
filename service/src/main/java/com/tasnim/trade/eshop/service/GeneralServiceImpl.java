package com.tasnim.trade.eshop.service;

import com.tasnim.trade.eshop.dto.DtoBase;
import com.tasnim.trade.eshop.to.EntityBase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.function.Function;

public abstract class GeneralServiceImpl<T extends EntityBase, D extends DtoBase> {

    abstract JpaRepository<T, Long> getRepository();

    /**
     * Convert from DTO to TO
     */
    final Function<T, D> dtoConverter;
    final Function<D, T> toConverter;

    public GeneralServiceImpl(Function<T, D> dtoConverter, Function<D, T> toConverter) {
        this.dtoConverter = dtoConverter;
        this.toConverter = toConverter;
    }

    public D save(D entity) {
        return dtoConverter.apply(getRepository().save(toConverter.apply(entity)));
    }

}
