package com.lambdaschool.javaorders.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="orders")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordnum;

    private double ordamount;

    private double advanceamount;

    @Column(nullable = false)
    private Long custcode;

    private String orderdescription;

    // Create Join Table for OrdersPayments
    @ManyToMany()
    @JoinTable(name="orderspayments",
        joinColumns = @JoinColumn(name="ordnum"),
        inverseJoinColumns = @JoinColumn(name ="paymentid"))
    private Set<Payment> payments = new HashSet<>();

    public Order()
    {
    }

    public Order(
        double ordamount,
        double advanceamount,
        Long custcode,
        String orderdescription)
    {
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.custcode = custcode;
        this.orderdescription = orderdescription;
    }

    public long getOrdnum()
    {
        return ordnum;
    }

    public void setOrdnum(long ordnum)
    {
        this.ordnum = ordnum;
    }

    public double getOrdamount()
    {
        return ordamount;
    }

    public void setOrdamount(double ordamount)
    {
        this.ordamount = ordamount;
    }

    public double getAdvanceamount()
    {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount)
    {
        this.advanceamount = advanceamount;
    }

    public Long getCustcode()
    {
        return custcode;
    }

    public void setCustcode(Long custcode)
    {
        this.custcode = custcode;
    }

    public String getOrderdescription()
    {
        return orderdescription;
    }

    public void setOrderdescription(String orderdescription)
    {
        this.orderdescription = orderdescription;
    }
}
