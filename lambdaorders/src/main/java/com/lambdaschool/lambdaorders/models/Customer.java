package com.lambdaschool.lambdaorders.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customercode;
    private String customercity;
    private String workingarea;
    private String customercountry;
    private String grade;
    private double openingamount;
    private double recieveamount;
    private double outstandingamount;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "agentcode", nullable = false)
    private Agent agent;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    public Customer()
    {

    }

    public Customer(String customercity, String workingarea, String customercountry, String grade, double openingamount, double recieveamount, double outstandingamount, String phone, Agent agent) {
        this.customercity = customercity;
        this.workingarea = workingarea;
        this.customercountry = customercountry;
        this.grade = grade;
        this.openingamount = openingamount;
        this.recieveamount = recieveamount;
        this.outstandingamount = outstandingamount;
        this.phone = phone;
        this.agent = agent;
    }

    public long getCustomercode()
    {
        return customercode;
    }

    public void setCustomercode(long customercode)
    {
        this.customercode = customercode;
    }

    public String getCustomercity()
    {
        return customercity;
    }

    public void setCustomercity(String customercity)
    {
        this.customercity = customercity;
    }

    public String getWorkingarea()
    {
        return workingarea;
    }

    public void setWorkingarea(String workingarea)
    {
        this.workingarea = workingarea;
    }

    public String getCustomercountry()
    {
        return customercountry;
    }

    public void setCustomercountry(String customercountry)
    {
        this.customercountry = customercountry;
    }

    public String getGrade()
    {
        return grade;
    }

    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    public double getOpeningamount()
    {
        return openingamount;
    }

    public void setOpeningamount(double openingamount)
    {
        this.openingamount = openingamount;
    }

    public double getRecieveamount()
    {
        return recieveamount;
    }

    public void setRecieveamount(double recieveamount)
    {
        this.recieveamount = recieveamount;
    }

    public double getOutstandingamount()
    {
        return outstandingamount;
    }

    public void setOutstandingamount(double outstandingamount)
    {
        this.outstandingamount = outstandingamount;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public Agent getAgent()
    {
        return agent;
    }

    public void setAgent(Agent agent)
    {
        this.agent = agent;
    }

    public List<Order> getOrders()
    {
        return orders;
    }

    public void setOrders(List<Order> orders)
    {
        this.orders = orders;
    }
}
