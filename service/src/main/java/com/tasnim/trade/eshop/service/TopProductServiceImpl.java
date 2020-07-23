package com.tasnim.trade.eshop.service;

import com.tasnim.trade.eshop.repository.TopProductRepository;
import com.tasnim.trade.eshop.to.TopProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopProductServiceImpl  {

    @Autowired
    TopProductRepository topProductRepository;


    public TopProduct save(TopProduct topProduct)
    {

       return topProductRepository.save(topProduct) ;
    }

    public List<TopProduct> findAll()
    {
        return topProductRepository.findAll();
    }
}
