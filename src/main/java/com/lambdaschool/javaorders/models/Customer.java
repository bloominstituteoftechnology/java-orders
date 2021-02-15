package com.lambdaschool.javaorders.models;

import javax.persistence.*;

@Entity
@Table(name="customers")
public class Customer
{
    @Id
    @GeneratedValue
    private long custcode;

    @Column(nullable = false)
    private String custname;

    private String workingarea;

    private String custcountry;

    private String grade;

    private double openingamt;

    private double receiveamt;

    private double outstandingamt;

    private String phone;

    @Column(nullable = false)
    private Long agentcode;

    public Customer()
    {
    }

    public Customer(
        String custname,
        String workingarea,
        String custcountry,
        String grade,
        double openingamt,
        double receiveamt,
        double outstandingamt,
        String phone,
        Long agentcode)
    {
        this.custname = custname;
        this.workingarea = workingarea;
        this.custcountry = custcountry;
        this.grade = grade;
        this.openingamt = openingamt;
        this.receiveamt = receiveamt;
        this.outstandingamt = outstandingamt;
        this.phone = phone;
        this.agentcode = agentcode;
    }

    public long getCustcode()
    {
        return custcode;
    }

    public void setCustcode(long custcode)
    {
        this.custcode = custcode;
    }

    public String getCustname()
    {
        return custname;
    }

    public void setCustname(String custname)
    {
        this.custname = custname;
    }

    public String getWorkingarea()
    {
        return workingarea;
    }

    public void setWorkingarea(String workingarea)
    {
        this.workingarea = workingarea;
    }

    public String getCustcountry()
    {
        return custcountry;
    }

    public void setCustcountry(String custcountry)
    {
        this.custcountry = custcountry;
    }

    public String getGrade()
    {
        return grade;
    }

    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    public double getOpeningamt()
    {
        return openingamt;
    }

    public void setOpeningamt(double openingamt)
    {
        this.openingamt = openingamt;
    }

    public double getReceiveamt()
    {
        return receiveamt;
    }

    public void setReceiveamt(double receiveamt)
    {
        this.receiveamt = receiveamt;
    }

    public double getOutstandingamt()
    {
        return outstandingamt;
    }

    public void setOutstandingamt(double outstandingamt)
    {
        this.outstandingamt = outstandingamt;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public Long getAgentcode()
    {
        return agentcode;
    }

    public void setAgentcode(Long agentcode)
    {
        this.agentcode = agentcode;
    }
}
