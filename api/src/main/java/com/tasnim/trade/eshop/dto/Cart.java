package com.tasnim.trade.eshop.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@JsonDeserialize(using = CartDeserializer.class)
public class Cart extends DtoBase {

    public Cart() {
    }

    public Cart(Long id) {
        super(id);
    }

    Product product;

    User user;

    Integer count;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date registerDate;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}
