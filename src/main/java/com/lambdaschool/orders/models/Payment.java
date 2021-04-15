package com.lambdaschool.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private long paymentid;

    private String type;

    @ManyToMany(mappedBy = "payments")
    @JsonIgnoreProperties(value = "payment", allowSetters = true)
    private Set<Order> orders = new HashSet<>();

    public Payment() {
    }

    public Payment(long paymentid, String type) {
        this.paymentid = paymentid;
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
}
