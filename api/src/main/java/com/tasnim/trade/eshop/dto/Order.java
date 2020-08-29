package com.tasnim.trade.eshop.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Order extends DtoBase {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
