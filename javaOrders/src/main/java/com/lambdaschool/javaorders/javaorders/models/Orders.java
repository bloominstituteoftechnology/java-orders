package com.lambdaschool.javaorders.javaorders.models;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderNum;
    @Column(nullable = false)
    private double ordAmount;
    private double advanceAmount;
    private String ordDescription;
    private long custCode;
}
