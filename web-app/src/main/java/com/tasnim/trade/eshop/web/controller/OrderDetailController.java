package com.tasnim.trade.eshop.web.controller;

import com.tasnim.trade.eshop.api.Service;
import com.tasnim.trade.eshop.dto.DtoBase;
import com.tasnim.trade.eshop.dto.OrderDetail;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/orderDetail")
@Controller
public class OrderDetailController extends ControllerBase<OrderDetail>{



    @Override
    public Service<OrderDetail> getService() {
        return null;
    }

    @Override
    public DtoBase getModel() {
        return null;
    }

    @Override
    public String getIndividualModel() {
        return null;
    }

    @Override
    public String getCollectionModel() {
        return null;
    }

    @Override
    public String index() {
        return null;
    }

    @Override
    public String insert() {
        return null;
    }

    @Override
    public String all() {
        return null;
    }

    @Override
    public String profile() {
        return null;
    }
}
