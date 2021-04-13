package com.lambdaschool.javaorders.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    private long ordernum;

    private double orderamt;
    private double advanceamt;
    private String orderdescription;
    @ManyToMany()
    @JoinTable(name = "orderpayments",
            joinColumns = @JoinColumn(name="ordernum"),
            inverseJoinColumns = @JoinColumn(name = "paymentid"))
    private Set<Payment> payments = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "custcode ", nullable = false)
    private Customer customer;


    public Order() {
    }

    public Order(double orderamt, double advanceamt, String orderdescription, Customer customer) {
        this.orderamt = orderamt;
        this.advanceamt = advanceamt;
        this.orderdescription = orderdescription;
        this.customer = customer;
    }

    public double getOrderamt() {
        return orderamt;
    }

    public void setOrderamt(double orderamt) {
        this.orderamt = orderamt;
    }

    public double getAdvanceamt() {
        return advanceamt;
    }

    public void setAdvanceamt(double advanceamt) {
        this.advanceamt = advanceamt;
    }

    public String getOrderdescription() {
        return orderdescription;
    }

    public void setOrderdescription(String orderdescription) {
        this.orderdescription = orderdescription;
    }

    public long getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(long ordernum) {
        this.ordernum = ordernum;
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
