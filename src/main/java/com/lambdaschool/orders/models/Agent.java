package com.lambdaschool.orders.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "agents")
public class Agent
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long agentid;

    @Column(unique = true,
        nullable = false)
    private Long agentcode;

    private String agentname;

    private String workingarea;

    private double commission;

    private String phone;

    private String country;
}

@OneToMany(mappedBy = "agent",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
List<Customer> customers = new ArrayList<>();

public Agent()
{
}

public Agent(
    Long agentcode,
    String agentname,
    String workingarea,
    double commission,
    String phone,
    String country)
{
    this.agentcode = agentcode;
    this.agentname = agentname;
    this.workingarea = workingarea;
    this.commission = commission;
    this.phone = phone;
    this.country = country;
}
    public long getAgentid()
    {
        return agentid;
    }

    public void setAgentid(long agentid)
    {
        this.agentid = agentid;
    }

    public Long getAgentcode()
    {
        return agentcode;
    }

    public void setAgentcode(Long agentcode)
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

    public List<Customer> getCustomers()
    {
        return customers;
    }

    public void setCustomers(List<Customer> customers)
    {
        this.customers = customers;
    }
}
