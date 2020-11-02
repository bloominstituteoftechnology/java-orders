package com.lambdaschool.orders.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Orders
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderid;

    @Column(unique = true,
        nullable = false)
    private Long ordnum;

    private Double ordamount;

    private Double advanceamount;

    @Column(unique = true,
        nullable = false)
    private Long custcode;

    private String orderdescription;

    @OneToMany(mappedBy = "order",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    List<Customer> customers = new ArrayList<>();

    @ManyToMany()
    @JoinTable(name = "orderspayments",
        joinColumns = @JoinColumn(name = "orderid"),
        inverseJoinColumns = @JoinColumn(name = "paymentid"))
    Set<Payment> payments = new HashSet<>();

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

    public List<Customer> getCustomers() {
            return customers;
    }

    public void setCustomers(List<Customer> customers) {
            this.customers = customers;
    }

    public Set<Payment> getPayments()
    {
        return payments;
    }

    public void setPayments(Set<Payment> payments)
    {
        this.payments = payments;
    }
}
