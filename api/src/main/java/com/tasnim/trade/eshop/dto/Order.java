package com.tasnim.trade.eshop.dto;

import java.util.Date;

public class Order extends DtoBase {
    private Date orderDate;
    private User user;

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
