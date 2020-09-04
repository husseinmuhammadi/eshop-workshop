package com.tasnim.trade.eshop.to;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cart", uniqueConstraints = {
        @UniqueConstraint(name = "uq_cart_user_product", columnNames = {"username", "product_id"})
})
@SequenceGenerator(name = "SEQUENCE_GENERATOR", sequenceName = "cart_seq")
public class Cart extends EntityBase {

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "count")
    private Integer count;

    @Column(name = "register_date")
    private Date registerDate;

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
