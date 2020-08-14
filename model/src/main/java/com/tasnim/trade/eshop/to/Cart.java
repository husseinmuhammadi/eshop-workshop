package com.tasnim.trade.eshop.to;

import javax.persistence.*;

@Entity
@Table(name = "cart")
@SequenceGenerator(name="SEQUENCE_GENERATOR", sequenceName = "cart_seq")
public class Cart extends EntityBase {

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
