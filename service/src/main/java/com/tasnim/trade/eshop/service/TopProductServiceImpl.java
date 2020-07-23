package com.tasnim.trade.eshop.service;

import com.tasnim.trade.eshop.api.TopProductService;
import com.tasnim.trade.eshop.dto.TopProduct;
import com.tasnim.trade.eshop.mapper.TopProductMapper;
import com.tasnim.trade.eshop.repository.TopProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopProductServiceImpl implements TopProductService {

    @Autowired
    private TopProductMapper mapper;

    @Autowired
    TopProductRepository topProductRepository;

//    public List<com.tasnim.trade.eshop.to.TopProduct> findAll() {
//        return topProductRepository.findAll();
//    }

    @Override
    public TopProduct save(TopProduct topProductDto) {
        com.tasnim.trade.eshop.to.TopProduct topProduct = mapper.toTopProduct(topProductDto);
        com.tasnim.trade.eshop.to.TopProduct topProduct1 = topProductRepository.save(topProduct);
        TopProduct topProductDto1 = mapper.fromTopProduct(topProduct1);
        return topProductDto1;
    }
}
