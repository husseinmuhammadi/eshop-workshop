package com.tasnim.trade.eshop.service;

import com.tasnim.trade.eshop.api.FestivalProductService;
import com.tasnim.trade.eshop.dto.FestivalProduct;
import com.tasnim.trade.eshop.dto.TopProduct;
import com.tasnim.trade.eshop.mapper.FestivalProductMapper;
import com.tasnim.trade.eshop.repository.FestivalProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FestivalProductServiceImpl implements FestivalProductService {

    @Autowired
    private FestivalProductMapper mapper;

    @Autowired
    FestivalProductRepository festivalProductRepository;



    @Override
    public FestivalProduct save(FestivalProduct festivalProductDto) {
        com.tasnim.trade.eshop.to.FestivalProduct festivalProduct = mapper.toFestivalProduct(festivalProductDto);
        com.tasnim.trade.eshop.to.FestivalProduct festivalProduct1 = festivalProductRepository.save(festivalProduct);
        FestivalProduct festivalProductDto1 = mapper.fromFestivalProduct(festivalProduct1);
        return festivalProductDto1;
    }
}
