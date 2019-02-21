package com.lambdaschool.orders.orders.models;

import javax.persistence.*;

@Entity
@Table(name = "orders")

public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (nullable = false)
    private long ORDNUM;

    private double ORDERAMOUNT;
    private double ADVANCEAMOUNT;

    @ManyToOne
    @JoinColumn(name = "CUSTCODE", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "AGENTCODE", nullable = false)
    private Agents agents;

    private String ORDDESCRIPTION;

    public Orders() {
    }

    public double getORDERAMOUNT() {
        return ORDERAMOUNT;
    }

    public void setORDERAMOUNT(double ORDERAMOUNT) {
        this.ORDERAMOUNT = ORDERAMOUNT;
    }

    public double getADVANCEAMOUNT() {
        return ADVANCEAMOUNT;
    }

    public void setADVANCEAMOUNT(double ADVANCEAMOUNT) {
        this.ADVANCEAMOUNT = ADVANCEAMOUNT;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Agents getAgents() {
        return agents;
    }

    public void setAgents(Agents agents) {
        this.agents = agents;
    }

    public String getORDDESCRIPTION() {
        return ORDDESCRIPTION;
    }

    public void setORDDESCRIPTION(String ORDDESCRIPTION) {
        this.ORDDESCRIPTION = ORDDESCRIPTION;
    }
}
