package com.lambdaschool.modelorders.models;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name ="customers")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long custcode;

  @Column(nullable = false)
  private String custname;
  private String custcity;
  private String workingarea;
  private String custcountry;
  private String grade;
  private double openingamt;
  private double receiveamt;
  private double paymentamt;
  private double outstandingamt;
  private String phone;

  @ManyToOne
  @JoinColumn(name="agentcode",
  nullable = false)
  private Agent agentcode;

  @OneToMany(mappedBy = "customer",
      cascade = CascadeType.ALL,
      orphanRemoval = true)
  List<Order> orders = new ArrayList<>();

  public Customer() {
  }

  public Customer(
      String custname,
      String custcity,
      String workingarea,
      String custcountry,
      String grade,
      double openingamt,
      double receiveamt,
      double paymentamt,
      double outstandingamt,
      String phone,
      Agent agentcode) {
    this.custname = custname;
    this.custcity = custcity;
    this.workingarea = workingarea;
    this.custcountry = custcountry;
    this.grade = grade;
    this.openingamt = openingamt;
    this.receiveamt = receiveamt;
    this.paymentamt = paymentamt;
    this.outstandingamt = outstandingamt;
    this.phone = phone;
    this.agentcode = agentcode;
  }

  public long getCustcode() {
    return custcode;
  }

  public void setCustcode(long custcode) {
    this.custcode = custcode;
  }

  public String getCustname() {
    return custname;
  }

  public void setCustname(String custname) {
    this.custname = custname;
  }

  public String getCustcity() {
    return custcity;
  }

  public void setCustcity(String custcity) {
    this.custcity = custcity;
  }

  public String getWorkingarea() {
    return workingarea;
  }

  public void setWorkingarea(String workingarea) {
    this.workingarea = workingarea;
  }

  public String getCustcountry() {
    return custcountry;
  }

  public void setCustcountry(String custcountry) {
    this.custcountry = custcountry;
  }

  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  public double getOpeningamt() {
    return openingamt;
  }

  public void setOpeningamt(double openingamt) {
    this.openingamt = openingamt;
  }

  public double getReceiveamt() {
    return receiveamt;
  }

  public void setReceiveamt(double receiveamt) {
    this.receiveamt = receiveamt;
  }

  public double getPaymentamt() {
    return paymentamt;
  }

  public void setPaymentamt(double paymentamt) {
    this.paymentamt = paymentamt;
  }

  public double getOutstandingamt() {
    return outstandingamt;
  }

  public void setOutstandingamt(double outstandingamt) {
    this.outstandingamt = outstandingamt;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Agent getAgentcode() {
    return agentcode;
  }

  public void setAgentcode(Agent agentcode) {
    this.agentcode = agentcode;
  }

  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }
}
