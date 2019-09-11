package com.lambdaschool.javaorders.javaorders.models;

import javax.persistence.*;

@Entity
@Table(name= "customers")
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long custCode;
    @Column(nullable = false)
    private String custName;
    private String custCity;
    private String workingArea;
    private String cutCountry;
    private String grade;
    private double openingAmt;
    private double receiveAmt;
    private double outstandingAmt;
    private String phone;

    public Customer()
    {
    }


}
