package com.lambdaschool.orders.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "agents")
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private long agentcode;

    @Column(unique = true, nullable = false)
    private String agentname;

    private double commission;
    private String country;
    private String phone;
    private String workingArea;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Customer> customer = new ArrayList<>();

    public void setCustomer(Collection<Customer> customer) {
        this.customer = (List<Customer>) customer;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public Agent() {}

    public Agent(String agentname, double commission, String country, String phone, String workingArea) {
        this.agentname = agentname;
        this.commission = commission;
        this.country = country;
        this.phone = phone;
        this.workingArea = workingArea;
    }

    public long getAgentCode() {
        return agentcode;
    }

    public void setAgentCode(long agentCode) {
        this.agentcode = agentCode;
    }

    public String getAgentName() {
        return agentname;
    }

    public void setAgentName(String agentName) {
        this.agentname = agentName;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWorkingArea() {
        return workingArea;
    }

    public void setWorkingArea(String workingArea) {
        this.workingArea = workingArea;
    }
}
