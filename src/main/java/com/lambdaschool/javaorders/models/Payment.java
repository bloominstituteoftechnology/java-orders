package com.lambdaschool.javaorders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "payments")
public class Payment {
//    PAYMENTID primary key, not null long
//    TYPE String not null

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long paymentid;

    @Column(nullable = false, unique = true)
    private String type;

    @ManyToMany(mappedBy = "payments")
    @JsonIgnoreProperties(value = "payments", allowSetters = true)
    private Set<Order> orders = new HashSet<>();

    public Payment() {
    }

    public Payment(String type) {
        this.type = type;
    }

    public long getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(long paymentid) {
        this.paymentid = paymentid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }


}
