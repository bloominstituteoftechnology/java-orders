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
}
