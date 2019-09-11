package com.lambdaschool.javaorders.javaorders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "customers")
public class Customers
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long custCode;
    @Column(nullable = false)
    private String custName;
    private String custCity;
    private String workingArea;
    private String custCountry;
    private String grade;
    private double openingAmt;
    private double receiveAmt;
    private double payment;
    private double outstandingAmt;
    private String phone;
    private long agentCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agentCode")
    @JsonIgnoreProperties("customers")
    private List<Agents> agents = new ArrayList<>();

    @OneToMany(mappedBy = "customers",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("customers")
    private List<Orders> orders = new ArrayList<>();

    public Customers()
    {
    }

    public Customers(String custName, String custCity, String workingArea, String custCountry, String grade,
                     double openingAmt, double receiveAmt, double payment, double outstandingAmt, String phone,  List<Agents> agents)
    {
        this.custName = custName;
        this.custCity = custCity;
        this.workingArea = workingArea;
        this.custCountry = custCountry;
        this.grade = grade;
        this.openingAmt = openingAmt;
        this.receiveAmt = receiveAmt;
        this.payment = payment;
        this.outstandingAmt = outstandingAmt;
        this.phone = phone;
        this.agents = agents;
    }
}
