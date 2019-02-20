package com.thadocizn.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long custCode;
    @Column(nullable = false)
    private String custName;
    @Column
    private String custCity;
    @Column
    private String workingArea;
    @Column
    private String custCountry;
    @Column
    private String grade;
    @Column
    private double openingAmt;
    @Column
    private double receiveAmt;
    @Column
    private double paymentAmt;
    @Column
    private double outstandingAmt;
    @Column
    private String phone;
    @OneToMany
    @JoinColumn(name = "agentCode")
    @JsonIgnore
    private long agentCode;

    public Customer() {
    }
}
