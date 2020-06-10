package com.lambda.javaorders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lambda.javaorders.models.Customers;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agents")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long agentcode;

    private String agentname;
    private double commission;
    private String country;
    private String phone;
    private String workingarea;

    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "agent")
    private List<Customers> customers = new ArrayList<>();

    public Agent() {
    }

    public Agent(String agentname, double commission, String country, String phone, String workingarea) {
        this.agentname = agentname;
        this.commission = commission;
        this.country = country;
        this.phone = phone;
        this.workingarea = workingarea;
    }

    public long getAgentcode() {
        return agentcode;
    }

    public void setAgentcode(long agentcode) {
        this.agentcode = agentcode;
    }

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname;
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

    public void setWorkingarea(String workingarea) {
        this.workingarea = workingarea;
    }

    public List<Customers> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customers> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "agentcode=" + agentcode +
                ", agentname='" + agentname + '\'' +
                ", commission=" + commission +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                ", workingarea='" + workingarea + '\'' +
                ", customers='" + customers + '\'' +
                '}';
    }
}