package com.lambdaschool.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
  @Id
  @GeneratedValue
  @Column(name = "ordnum", nullable = false)
  private Long id;

  @Column(name = "ordamount")
  private double amount;

  @Column(name = "advanceamount")
  private double advanceAmount;

  @ManyToOne
  @JoinColumn(name = "custcode", nullable = false)
  @JsonIgnore
  private Customer customer;

  @ManyToOne
  @JoinColumn(name = "agentcode", nullable = false)
  @JsonIgnore
  private Agent agent;

  @Column(name = "orddescription")
  private String description;
}
