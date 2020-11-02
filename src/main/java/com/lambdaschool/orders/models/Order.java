package com.lambdaschool.orders.models;

import javax.persistence.*;


@Entity
@Table(name = "orders")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderid;

    @Column(nullable = false)
    private Long ordnum;

    private double ordamount;

    private double advanceamount;

    @ManyToOne
    @JoinColumn(name = "customerid", nullable = false)
    Customer customer;
    private Long custcode;

    private String orderdescription;

    public Order()
    {
    }

    public Order(
        Long ordnum,
        Double ordamount,
        Double advanceamount,
        Long custcode,
        String orderdescription
    {
        this.ordnum = ordnum;
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.custcode = custcode;
        this.orderdescription = orderdescription;
    }

    public long getOrderid()
    {
        return orderid;
    }

    public void setOrderid(long orderid)
    {
        this.orderid = orderid;
    }

    public Long getOrdnum()
    {
        return ordnum;
    }

    public void setOrdnum(Long ordnum)
    {
        this.ordnum = ordnum;
    }

    public Double getOrdamount()
    {
        return ordamount;
    }

    public void setOrdamount(Double ordamount)
    {
        this.ordamount = ordamount;
    }

    public Double getAdvanceamount()
    {
        return advanceamount;
    }

    public void setAdvanceamount(Double advanceamount)
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
