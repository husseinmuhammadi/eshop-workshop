package com.tasnim.trade.eshop.to;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user_order")
@SequenceGenerator(name = "SEQUENCE_GENERATOR", sequenceName = "user_order_seq")
public class Order extends EntityBase {

    private Date orderDate;

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
}
