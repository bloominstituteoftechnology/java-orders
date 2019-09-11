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
    private double outstandingAmt;
    private String phone;

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

    public Customers(String custName, String custCity, String workingArea, String custCountry, String grade, double openingAmt, double receiveAmt, double outstandingAmt, String phone, List<Agents> agents, List<Orders> orders)
    {
        this.custName = custName;
        this.custCity = custCity;
        this.workingArea = workingArea;
        this.custCountry = custCountry;
        this.grade = grade;
        this.openingAmt = openingAmt;
        this.receiveAmt = receiveAmt;
        this.outstandingAmt = outstandingAmt;
        this.phone = phone;
        this.agents = agents;
        this.orders = orders;
    }

    public long getCustCode()
    {
        return custCode;
    }

    public void setCustCode(long custCode)
    {
        this.custCode = custCode;
    }

    public String getCustName()
    {
        return custName;
    }

    public void setCustName(String custName)
    {
        this.custName = custName;
    }

    public String getCustCity()
    {
        return custCity;
    }

    public void setCustCity(String custCity)
    {
        this.custCity = custCity;
    }

    public String getWorkingArea()
    {
        return workingArea;
    }

    public void setWorkingArea(String workingArea)
    {
        this.workingArea = workingArea;
    }

    public String getCustCountry()
    {
        return custCountry;
    }

    public void setCustCountry(String custCountry)
    {
        this.custCountry = custCountry;
    }

    public String getGrade()
    {
        return grade;
    }

    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    public double getOpeningAmt()
    {
        return openingAmt;
    }

    public void setOpeningAmt(double openingAmt)
    {
        this.openingAmt = openingAmt;
    }

    public double getReceiveAmt()
    {
        return receiveAmt;
    }

    public void setReceiveAmt(double receiveAmt)
    {
        this.receiveAmt = receiveAmt;
    }

    public double getOutstandingAmt()
    {
        return outstandingAmt;
    }

    public void setOutstandingAmt(double outstandingAmt)
    {
        this.outstandingAmt = outstandingAmt;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public List<Agents> getAgents()
    {
        return agents;
    }

    public void setAgents(List<Agents> agents)
    {
        this.agents = agents;
    }

    public List<Orders> getOrders()
    {
        return orders;
    }

    public void setOrders(List<Orders> orders)
    {
        this.orders = orders;
    }
}
