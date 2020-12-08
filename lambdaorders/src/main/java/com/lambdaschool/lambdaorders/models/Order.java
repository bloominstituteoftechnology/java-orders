package com.lambdaschool.lambdaorders.models;

import javax.persistence.*;
import java.util.HashSet;

@Entity
@Table(name = "orders")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long orderid;
    private double orderamount;
    private String orderdescription;

    @ManyToMany()
    @JoinTable(name = "orderpayments", joinColumns = @JoinColumn(name="orderid"), inverseJoinColumns = @JoinColumn(name= "paymentid"))
    Set<Payment> payments = new HashSet<>();
}

