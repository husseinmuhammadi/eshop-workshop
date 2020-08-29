package com.tasnim.trade.eshop.service.base;

import com.tasnim.trade.eshop.dto.DtoBase;
import com.tasnim.trade.eshop.to.EntityBase;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class GeneralServiceImpl<T extends EntityBase, R extends DtoBase> {

    public abstract JpaRepository<T, Long> getRepository();

    private final Mapper<T, R> mapper;

    public GeneralServiceImpl(Function<T, R> dtoConverter, Function<R, T> toConverter) {
        mapper = new Mapper<>() {
            @Override
            public R fromEntity(T entity) {
                return dtoConverter.apply(entity);
            }

            @Override
            public T toEntity(R dto) {
                return toConverter.apply(dto);
            }
        };
    }

    public R save(R dto) {
        return mapper.fromEntity(getRepository().save(mapper.toEntity(dto)));
    }

    public List<R> findAll() {
        return getRepository().findAll().stream().map(mapper::fromEntity).collect(Collectors.toList());
    }

    public Page<R> findAll(Pageable pageable) {
        Converter<T, R> converter = mapper::fromEntity;
        return getRepository().findAll(pageable).map(converter::convert);
    }

    public void delete(Long id) {
        getRepository().deleteById(id);
    }

    public void delete(R dto) {
        getRepository().delete(mapper.toEntity(dto));
    }

    public Optional<R> findById(Long id) {
        return getRepository().findById(id).map(mapper::fromEntity);
    }
}

