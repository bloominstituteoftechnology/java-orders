package com.lambdaschool.javaorders.models;

import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;

@Entity
@Table(name="payments")
public class Payment
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentid;

    private String type;
}
