package com.lambdaschool.javaorders.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // allowing interaction with agents table
@Table(name = "agents")
public class Agent
{
    @Id // primary key number (long) of agents table
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long agentcode; // primary key

    private String agentname;
    private String workingarea;
    private double commission;
    private String phone;
    private String country;

    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Customer> customers = new ArrayList<>();


    // Constructors
    public Agent()
    {
    }

    public Agent(
        String agentname,
        String workingarea,
        double commission,
        String phone,
        String country)
    {
        this.agentname = agentname;
        this.workingarea = workingarea;
        this.commission = commission;
        this.phone = phone;
        this.country = country;
    }


    // Setters and Getters
    public long getAgentcode()
    {
        return agentcode;
    }

    public void setAgentcode(long agentcode)
    {
        this.agentcode = agentcode;
    }

    public String getAgentname()
    {
        return agentname;
    }

    public void setAgentname(String agentname)
    {
        this.agentname = agentname;
    }

    public String getWorkingarea()
    {
        return workingarea;
    }

    public void setWorkingarea(String workingarea)
    {
        this.workingarea = workingarea;
    }

    public double getCommission()
    {
        return commission;
    }

    public void setCommission(double commission)
    {
        this.commission = commission;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    // Getters and Setters from customer
    public List<Customer> getCustomers()
    {
        return customers;
    }

    public void setCustomers(List<Customer> customers)
    {
        this.customers = customers;
    }
}
