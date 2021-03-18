package com.lambdaschool.javaorders.models;

import javax.persistence.*;

@Entity
@Table(name = "OrdersPayments")
public class OrdersPayments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long agentcode;

    private String agentname;
    private double commission;
    private String country;
    private int phone;
    private String workingarea;



}
