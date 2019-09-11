package com.lambdaschool.orders.orders.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(nullable = false)
    private long ORDNUM;

    private double ORDAMOUNT;
    private double ADVANCEAMOUNT;

    @ManyToOne
    @JoinColumn(name = "CUSTCODE", nullable = false)
    @JsonIgnore
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "AGENTCODE", nullable = false)
    private Agents AGENTCODE;

    private String ORDDESCRIPTION;


    public Orders() {
    }

    public long getORDERNUM() {
        return ORDNUM;
    }

    public double getORDAMOUNT() {
        return ORDAMOUNT;
    }

    public void setORDAMOUNT(double ORDAMOUNT) {
        this.ORDAMOUNT = ORDAMOUNT;
    }

    public double getADVANCEAMOUNT() {
        return ADVANCEAMOUNT;
    }

    public void setADVANCEAMOUNT(double ADVANCEAMOUNT) {
        this.ADVANCEAMOUNT = ADVANCEAMOUNT;
    }

    public Customer getCUSTCODE() {
        return customer;
    }

    public void setCUSTCODE(Customer CUSTCODE) {
        this.customer = CUSTCODE;
    }

    public Agents getAGENTCODE() {
        return AGENTCODE;
    }

    public void setAGENTCODE(Agents AGENTCODE) {
        this.AGENTCODE = AGENTCODE;
    }

    public String getORDDESCRIPTION() {
        return ORDDESCRIPTION;
    }

    public void setORDDESCRIPTION(String ORDDESCRIPTION) {
        this.ORDDESCRIPTION = ORDDESCRIPTION;
    }
}
