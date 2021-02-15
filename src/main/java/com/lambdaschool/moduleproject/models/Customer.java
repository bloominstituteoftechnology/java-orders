package com.lambdaschool.moduleproject.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerCode;

    @Column(unique = true, nullable = false)
    private String custName;

    private String custCity;

    private String custCountry;

    private String grade;

    private double openingAmt;

    private double outstandingAmt;

    private double paymentAmt;

    private String phone;

    private double receiveAmt;

    private String workingArea;

    @ManyToOne()
    @JoinColumn(name="agentCode", nullable = false)
    private Agent agent;


    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<> ();

    public Customer(){
    }

    public Customer (String custName, String custCity, String custCountry, String grade, double openingAmt, double outstandingAmt, double paymentAmt, String phone, double receiveAmt, String workingArea, Agent agent) {
        this.custName = custName;
        this.custCity = custCity;
        this.custCountry = custCountry;
        this.grade = grade;
        this.openingAmt = openingAmt;
        this.outstandingAmt = outstandingAmt;
        this.paymentAmt = paymentAmt;
        this.phone = phone;
        this.receiveAmt = receiveAmt;
        this.workingArea = workingArea;
        this.agent = agent;
    }

    public long getCustomerCode () {
        return customerCode;
    }

    public void setCustomerCode (long customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustName () {
        return custName;
    }

    public void setCustName (String custName) {
        this.custName = custName;
    }

    public String getCustCity () {
        return custCity;
    }

    public void setCustCity (String custCity) {
        this.custCity = custCity;
    }

    public String getCustCountry () {
        return custCountry;
    }

    public void setCustCountry (String custCountry) {
        this.custCountry = custCountry;
    }

    public String getGrade () {
        return grade;
    }

    public void setGrade (String grade) {
        this.grade = grade;
    }

    public double getOpeningAmt () {
        return openingAmt;
    }

    public void setOpeningAmt (double openingAmt) {
        this.openingAmt = openingAmt;
    }

    public double getOutstandingAmt () {
        return outstandingAmt;
    }

    public void setOutstandingAmt (double outstandingAmt) {
        this.outstandingAmt = outstandingAmt;
    }

    public double getPaymentAmt () {
        return paymentAmt;
    }

    public void setPaymentAmt (double paymentAmt) {
        this.paymentAmt = paymentAmt;
    }

    public String getPhone () {
        return phone;
    }

    public void setPhone (String phone) {
        this.phone = phone;
    }

    public double getReceiveAmt () {
        return receiveAmt;
    }

    public void setReceiveAmt (double receiveAmt) {
        this.receiveAmt = receiveAmt;
    }

    public String getWorkingArea () {
        return workingArea;
    }

    public void setWorkingArea (String workingArea) {
        this.workingArea = workingArea;
    }

    public Agent getAgent () {
        return agent;
    }

    public void setAgent (Agent agent) {
        this.agent = agent;
    }
}
