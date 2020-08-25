package com.tasnim.trade.eshop.dto;

import java.util.Date;

public class Order extends DtoBase {
    private Date orderDate;

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
