package com.tasnim.trade.eshop.to;

import sun.security.krb5.internal.LastReq;

import javax.persistence.*;
import java.util.Date;

@Entity
@SequenceGenerator(name = "SEQUENCE_GENERATOR", sequenceName = "TOP_PRODUCT_SEQ")
public class TopProduct extends EntityBase {
    @ManyToOne(fetch = FetchType.LAZY)
    Product product;

    @Column(name = "start_Date", nullable = false)
    Date startDate;

    @Column(name = "end_Date", nullable = false)
    Date endDate;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
