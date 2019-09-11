package com.lambdaschool.javaorders.javaorders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderNum;
//    @Column(nullable = false)
    private double ordAmount;
    private double advanceAmount;
    private String ordDescription;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "custCode")
    @JsonIgnoreProperties("orders")
    private List<Customers> customers = new ArrayList<>();


    public Orders()
    {
    }

    public Orders(double ordAmount, double advanceAmount, String ordDescription, List<Customers> customers)
    {
        this.ordAmount = ordAmount;
        this.advanceAmount = advanceAmount;
        this.ordDescription = ordDescription;
        this.customers = customers;
    }

    public long getOrderNum()
    {
        return orderNum;
    }

    public void setOrderNum(long orderNum)
    {
        this.orderNum = orderNum;
    }

    public double getOrdAmount()
    {
        return ordAmount;
    }

    public void setOrdAmount(double ordAmount)
    {
        this.ordAmount = ordAmount;
    }

    public double getAdvanceAmount()
    {
        return advanceAmount;
    }

    public void setAdvanceAmount(double advanceAmount)
    {
        this.advanceAmount = advanceAmount;
    }

    public String getOrdDescription()
    {
        return ordDescription;
    }

    public void setOrdDescription(String ordDescription)
    {
        this.ordDescription = ordDescription;
    }

    public List<Customers> getCustomers()
    {
        return customers;
    }

    public void setCustomers(List<Customers> customers)
    {
        this.customers = customers;
    }
}
