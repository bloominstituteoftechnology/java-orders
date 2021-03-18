package com.lambdaschool.javaorders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

public class Agents {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long agentcode;

    @Column(unique = true,
            nullable = false)
    private String agentname;

    private double commision;

    private String country;

    private String phone;

    private String workingarea;

    @ManyToMany()
    @JoinTable(name = "restaurantpayments",
            joinColumns = @JoinColumn(name = "restaurantid"),
            inverseJoinColumns = @JoinColumn(name = "paymentid"))
    @JsonIgnoreProperties(value = "restaurants",
            allowSetters = true)
    Set<Payment> payments = new HashSet<>();

    public Agents()
    {
    }



    public Agent(
           String agentname,
           double commision,
           String country,
           String phone,
           String workingarea)
   {
       this.agentname = agentname;
       this.commision = commision;
       this.country = country;
       this.phone = phone;
       this.workingarea = workingarea;
   }

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname;
    }

    public double getCommision() {
        return commision;
    }

    public void setCommision(double commision) {
        this.commision = commision;
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







}











