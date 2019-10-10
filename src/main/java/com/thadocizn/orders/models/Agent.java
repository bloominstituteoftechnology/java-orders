package com.thadocizn.orders.models;

import javax.persistence.*;

@Entity
@Table(name = "agent")
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long agentCode;
    @Column
    private String agentName;
    @Column
    private String workingArea;
    @Column
    private double commission;
    @Column
    private String phone;
    @Column
    private String country;

    public Agent() {

    }

    public long getAgentCode() {
        return agentCode;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getWorkingArea() {
        return workingArea;
    }

    public void setWorkinArea(String workinArea) {
        this.workingArea = workinArea;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
