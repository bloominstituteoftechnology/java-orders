package com.lambdaschool.javaorders.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
    private long ordernum;

    private double orderamt;
    private double advanceamt;
    private String orderdescription;


    public Order() {
    }

    public Order(double orderamt, double advanceamt, String orderdescription) {
        this.orderamt = orderamt;
        this.advanceamt = advanceamt;
        this.orderdescription = orderdescription;
    }
    
}
