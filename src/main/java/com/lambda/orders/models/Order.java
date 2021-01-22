package com.lambda.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
//    ORDNUM primary key, not null Long
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordnum;

//    ORDAMOUNT double
    private double ordamount;

//    ADVANCEAMOUNT double
    private double advanceamount;



//    ORDERDESCRIPTION String
    private String orderdescription;

    @ManyToMany
    @JoinTable(name = "orderspayments", joinColumns = @JoinColumn(name = "ordnum"), inverseJoinColumns = @JoinColumn(name = "paymentid"))

    @JsonIgnoreProperties("orders")
    Set<Payment> payments = new HashSet<>();

//    CUSTCODE Long foreign key (one customer to many orders) not null
    @ManyToOne
    @JoinColumn(name = "custcode", nullable = false)
    @JsonIgnoreProperties("orders")
    private Customer customer;

    public Order() {
    }

    public Order(double ordamount, double advanceamount, Customer customer, String orderdescription) {
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.customer = customer;
        this.orderdescription = orderdescription;
    }

    public long getOrdnum() {
        return ordnum;
    }

    public void setOrdnum(long ordnum) {
        this.ordnum = ordnum;
    }

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


    public String getOrderdescription() {
        return orderdescription;
    }

    public void setOrderdescription(String orderdescription) {
        this.orderdescription = orderdescription;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }
}
