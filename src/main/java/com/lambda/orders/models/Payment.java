package com.lambda.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "payments")
public class Payment {
//    PAYMENTID primary key, not null long
    @Id // automatically sets @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long paymentid;


//    TYPE String not null
    @Column(nullable = false, unique = true)
    private String type;

    @ManyToMany(mappedBy = "payments")
    @JsonIgnoreProperties("payments")
    private Set<Order> orders = new HashSet<>();

    //default constructor
    public Payment() {
    }

    //constructor with type
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


}
