package com.lambdaschool.moduleproject.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long paymentId;

    @Column(nullable = false)
    private String type;

    @ManyToMany()
    @JoinTable(name = "orderpayments", joinColumns = @JoinColumn(name = "ordnum"), inverseJoinColumns = @JoinColumn(name = "paymentid"))
    Set<Payment> payments = new HashSet<> ();

    public Payment(){
    }

    public Payment (String type) {
        this.type = type;
    }

    public long getPaymentId () {
        return paymentId;
    }

    public void setPaymentId (long paymentId) {
        this.paymentId = paymentId;
    }

    public String getType () {
        return type;
    }

    public void setType (String type) {
        this.type = type;
    }

    public Set<Payment> getPayments () {
        return payments;
    }

    public void setPayments (Set<Payment> payments) {
        this.payments = payments;
    }
}
