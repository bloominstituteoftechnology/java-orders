package com.lambda.orders.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ordnum;
    private double ordamount;

    private double advanceamount;

    @ManyToMany
    @JoinTable(name = "orderspayments",
        joinColumns = @JoinColumn(name = "ordnum"),
        inverseJoinColumns = @JoinColumn(name = "paymentid"))
    private Set<Payment> payments = new HashSet<>();

    private long custcode;

    private String orderdescription;

    public Order()
    {
    }
    public Order(double ordamount, double advanceamount, long custcode, String orderdescription)
    {
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.custcode = custcode;
        this.orderdescription = orderdescription;
    }

    public int getOrdnum()
    {
        return ordnum;
    }

    public void setOrdnum(int ordnum)
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

    public long getCustcode()
    {
        return custcode;
    }

    public void setCustcode(long custcode)
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

    public void addPayment(Payment payment) {
        payments.add(payment);
    }
}
