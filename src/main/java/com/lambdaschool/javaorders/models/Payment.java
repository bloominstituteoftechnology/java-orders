package com.lambdaschool.javaorders.models;

import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="payments")
public class Payment
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentid;

    private String type;

    // Connect to Join table for OrderPayments
    @ManyToMany(mappedBy = "payments")
    private Set<Order> orders = new HashSet<>();

    public Payment()
    {
    }

    public Payment(String type)
    {
        this.type = type;
    }

    public Payment(
        String type,
        Set<Order> orders)
    {
        this.type = type;
        this.orders = orders;
    }

    public Long getPaymentid()
    {
        return paymentid;
    }

    public void setPaymentid(Long paymentid)
    {
        this.paymentid = paymentid;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public Set<Order> getOrders()
    {
        return orders;
    }

    public void setOrders(Set<Order> orders)
    {
        this.orders = orders;
    }
}
