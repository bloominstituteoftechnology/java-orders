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

    public long getCustCode() {
        return custCode;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustCity() {
        return custCity;
    }

    public void setCustCity(String custCity) {
        this.custCity = custCity;
    }

    public String getWorkingArea() {
        return workingArea;
    }

    public void setWorkingArea(String workingArea) {
        this.workingArea = workingArea;
    }

    public String getCustCountry() {
        return custCountry;
    }

    public void setCustCountry(String custCountry) {
        this.custCountry = custCountry;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getOpeningAmt() {
        return openingAmt;
    }

    public void setOpeningAmt(double openingAmt) {
        this.openingAmt = openingAmt;
    }

    public double getReceiveAmt() {
        return receiveAmt;
    }

    public void setReceiveAmt(double receiveAmt) {
        this.receiveAmt = receiveAmt;
    }

    public double getPaymentAmt() {
        return paymentAmt;
    }

    public void setPaymentAmt(double paymentAmt) {
        this.paymentAmt = paymentAmt;
    }

    public double getOutstandingAmt() {
        return outstandingAmt;
    }

    public void setOutstandingAmt(double outstandingAmt) {
        this.outstandingAmt = outstandingAmt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(long agentCode) {
        this.agentCode = agentCode;
    }
}
