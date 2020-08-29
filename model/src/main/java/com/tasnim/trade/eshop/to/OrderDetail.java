package com.tasnim.trade.eshop.to;

import javax.persistence.*;
import java.util.Date;

import static com.tasnim.trade.eshop.to.EntityBase.SEQUENCE_GENERATOR;

@Entity
@Table(name = "order_detail")
@SequenceGenerator(name = SEQUENCE_GENERATOR, sequenceName = "ORDER_DETAIL_SEQ")
public class OrderDetail extends EntityBase {

    @ManyToOne
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "FK_PRODUCT_ORDER_DETAIL"))
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id", foreignKey = @ForeignKey(name = "FK_ORDER_ORDER_DETAIL"))
    private Order order;

    @Column(name = "count")
    private Integer count;

    private Long amount;

    @Column(name = "register_date")
    private Date registerDate;

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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}
