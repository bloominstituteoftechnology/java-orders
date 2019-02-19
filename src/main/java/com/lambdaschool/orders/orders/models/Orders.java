package com.lambdaschool.orders.orders.models;

import javax.persistence.*;

@Entity
@Table(name = "orders")

public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ORDERNUM;

    @Column (nullable = false)
    private double ORDAMOUNT;
    private double ADVANCEAMOUNT;
    private long CUSTCOE;
    private long AGENTCODE;
    private String ORDDESCRIPTION;
}
