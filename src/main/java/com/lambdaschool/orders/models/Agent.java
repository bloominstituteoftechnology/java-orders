package com.lambdaschool.orders.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "agents")
public class Agent {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "agentcode", nullable = false)
  private Long id;

  @Column(name = "agentname")
  private String name;

  @Column(name = "workingarea")
  private String workingArea;

  private double commission;
  private String phone;
  private String country;

  @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "agent")
  private Set<Customer> customers;

  @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "agent")
  private Set<Order> orders;

  public Agent() {}

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getWorkingArea() {
    return workingArea;
  }

  public void setWorkingArea(String workingArea) {
    this.workingArea = workingArea;
  }

  public double getCommission() {
    return commission;
  }

  public void setCommission(double commission) {
    this.commission = commission;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Set<Customer> getCustomers() {
    return customers;
  }

  public void setCustomers(Set<Customer> customers) {
    this.customers = customers;
  }

  public Set<Order> getOrders() {
    return orders;
  }

  public void setOrders(Set<Order> orders) {
    this.orders = orders;
  }
}
