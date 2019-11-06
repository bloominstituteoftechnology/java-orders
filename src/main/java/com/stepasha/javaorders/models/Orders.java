package com.stepasha.javaorders.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordnum;

    @Column(unique = true,
            nullable = false)
    private double ordamount;

    private double advanceamount;
    private String city;
    private String orderdescription;

    public Orders(double ordamount, double advanceamount, String city, String orderdescription) {
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.city = city;
        this.orderdescription = orderdescription;
    }
    public Orders(){}

    public double getOrdamount() {
        return ordamount;
    }

    public void setOrdamount(double ordamount) {
        this.ordamount = ordamount;
    }

    public double getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount) {
        this.advanceamount = advanceamount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOrderdescription() {
        return orderdescription;
    }

    public void setOrderdescription(String orderdescription) {
        this.orderdescription = orderdescription;
    }
}
