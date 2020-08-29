package com.tasnim.trade.eshop.dto;

public class Cart extends DtoBase {

    public Cart() {
    }

    public Cart(Long id) {
        super(id);
    }

    Product product;

    User user;

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
}
