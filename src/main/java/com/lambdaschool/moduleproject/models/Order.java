package com.lambdaschool.moduleproject.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordnum;

    @Column
    private double advanceAmount;

    private double ordAmount;

    private String orderDescription;

    @ManyToOne
    @JoinColumn(name="custCode", nullable = false)
    private Customer customer;

    @ManyToMany(mappedBy = "orders")
    private Set<Payment> payments = new HashSet<> ();
    public Order(){
    }

    public Order (double advanceAmount, double ordAmount, String orderDescription, Customer customer) {
        this.advanceAmount = advanceAmount;
        this.ordAmount = ordAmount;
        this.orderDescription = orderDescription;
        this.customer = customer;
    }

    public long getOrdnum () {
        return ordnum;
    }

    public void setOrdnum (long ordnum) {
        this.ordnum = ordnum;
    }

    public double getAdvanceAmount () {
        return advanceAmount;
    }

    public void setAdvanceAmount (double advanceAmount) {
        this.advanceAmount = advanceAmount;
    }

    public double getOrdAmount () {
        return ordAmount;
    }

    public void setOrdAmount (double ordAmount) {
        this.ordAmount = ordAmount;
    }

    public String getOrderDescription () {
        return orderDescription;
    }

    public void setOrderDescription (String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public Customer getCustomer () {
        return customer;
    }

    public void setCustomer (Customer customer) {
        this.customer = customer;
    }
}
