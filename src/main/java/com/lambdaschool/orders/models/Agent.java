package com.lambdaschool.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    private String workingarea;

    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "agent", allowSetters = true)
    private List<Customer> customer = new ArrayList<>();

    public Agent() {}

    public Agent(Long agentcode, String agentname, String workingarea, double commission, String phone, String country ) {
        this.agentcode = agentcode;
        this.agentname = agentname;
        this.commission = commission;
        this.country = country;
        this.phone = phone;
        this.workingarea = workingarea;
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

    public String getWorkingarea() {
        return workingarea;
    }

    public void setWorkingarea(String workingArea) {
        this.workingarea = workingArea;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }

    public List<Customer> getCustomer() {
        return customer;
    }
}
