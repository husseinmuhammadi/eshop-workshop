package com.tasnim.trade.eshop.to;

import javax.persistence.*;
import java.util.Date;

@Entity(name="FESTIVAL_PRODUCT")
@SequenceGenerator(name = "SEQUENCE_GENERATOR",sequenceName = "FESTIVAL_PRODUCT_SEQ")
public class FestivalProduct  extends EntityBase{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", foreignKey = @ForeignKey(name = "FK_PRODUCT_FESTIVAL_PRODUCT"))
    Product product;

    @Column(name = "START_DATE", nullable = false)
    Date startDate;

    @Column(name = "END_DATE", nullable = false)
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
