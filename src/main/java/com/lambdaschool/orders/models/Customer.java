package com.lambdaschool.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "custcode", nullable = false)
  private Long id;

  @Column(name = "custname", nullable = false)
  private String name;

  @Column(name = "custcity")
  private String city;

  @Column(name = "workingarea")
  private String workingArea;

  @Column(name = "custcountry")
  private String country;

  @Column(name = "openingamt")
  private double openingAmount;

  @Column(name = "receiveamt")
  private double receiveAmount;

  @Column(name = "paymentamt")
  private double paymentAmount;

  @Column(name = "outstandingamt")
  private double outstandingAmount;

  private String grade;
  private String phone;

  @ManyToOne
  @JoinColumn(name = "agentcode", nullable = false)
  @JsonIgnore
  private Agent agent;
}
