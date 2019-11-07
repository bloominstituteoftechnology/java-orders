package com.stepasha.javaorders.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "orderspayments")
public class OrdersPayments {


private long ordnum;

    private long paymentid;


    public OrdersPayments() { }

    public OrdersPayments(long ordnum, long paymentid) {
        this.ordnum = ordnum;
        this.paymentid = paymentid;
    }

    public long getOrdernum() { return ordnum; }

    public void setOrdernum(long ordernum) { this.ordnum = ordernum; }

    public long getPaymentid() { return paymentid; }

    public void setPaymentid(long paymentid) { this.paymentid = paymentid; }


}
