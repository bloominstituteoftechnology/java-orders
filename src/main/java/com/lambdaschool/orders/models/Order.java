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

  public Order() {}

  public Long getId() {
    return id;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public double getAdvanceAmount() {
    return advanceAmount;
  }

  public void setAdvanceAmount(double advanceAmount) {
    this.advanceAmount = advanceAmount;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Agent getAgent() {
    return agent;
  }

  public void setAgent(Agent agent) {
    this.agent = agent;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
