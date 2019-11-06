package com.stepasha.javaorders.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long paymentid;

    @Column(unique = true,
            nullable = false)
    private String type;

    public Payments(String type) {
        this.type = type;
    }
    public  Payments(){}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
