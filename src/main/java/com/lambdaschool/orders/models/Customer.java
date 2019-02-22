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

  public Customer() {}

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getWorkingArea() {
    return workingArea;
  }

  public void setWorkingArea(String workingArea) {
    this.workingArea = workingArea;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public double getOpeningAmount() {
    return openingAmount;
  }

  public void setOpeningAmount(double openingAmount) {
    this.openingAmount = openingAmount;
  }

  public double getReceiveAmount() {
    return receiveAmount;
  }

  public void setReceiveAmount(double receiveAmount) {
    this.receiveAmount = receiveAmount;
  }

  public double getPaymentAmount() {
    return paymentAmount;
  }

  public void setPaymentAmount(double paymentAmount) {
    this.paymentAmount = paymentAmount;
  }

  public double getOutstandingAmount() {
    return outstandingAmount;
  }

  public void setOutstandingAmount(double outstandingAmount) {
    this.outstandingAmount = outstandingAmount;
  }

  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Agent getAgent() {
    return agent;
  }

  public void setAgent(Agent agent) {
    this.agent = agent;
  }
}
