package com.tasnim.trade.eshop.to;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user_order")
@SequenceGenerator(name = "SEQUENCE_GENERATOR", sequenceName = "user_order_seq")
public class Order extends EntityBase {

    @Column(name = "order_date")
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username", foreignKey = @ForeignKey(name = "FK_ORDER_USER"))
    private User user;

    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetails;

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
