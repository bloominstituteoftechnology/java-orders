package com.lambdaschool.javaorders.models;

import javax.persistence.*;

@Entity
@Table(name="agents")
public class Agent
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long agentcode;

    @Column(nullable = false)
    private String agentname;

    @Column(nullable = false)
    private String workingarea;

    private double commission;

    private String phone;

    private String country;

    //contructors

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

    public long getAgentcode()
    {
        return agentcode;
    }

    public void setAgentcode(long agentcode)
    {
        this.agentcode = agentcode;
    }

    public String getName()
    {
        return agentname;
    }

    public void setName(String agentname)
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
}
