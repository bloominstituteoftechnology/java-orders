package tech.gebel.javaorders.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "custcode", nullable = false)
  private long customerCode;

  @Column(name = "custcity")
  private String customerCity;

  @Column(name = "custcountry")
  private String customerCountry;

  @Column(name = "custname", nullable = false)
  private String customerName;

  @Column(name = "openingamt")
  private double openingAmount;

  @Column(name = "outstandingamt")
  private double outstandingAmount;

  @Column(name = "paymentamt")
  private double paymentAmount;

  @Column(name = "receiveamt")
  private double receiveAmount;

  @Column(name = "workingarea")
  private String workingArea;

  @ManyToOne
  @JoinColumn(name = "agentcode", nullable = false)
  private Agent agent;

  @OneToMany(
    mappedBy = "customer",
    cascade = CascadeType.ALL,
    orphanRemoval = true
  )
  private List<Order> orders = new ArrayList<>();

  private String grade, phone;

  public Customer() {}

  public Customer(
    String customerCity,
    String customerCountry,
    String customerName,
    double openingAmount,
    double outstandingAmount,
    double paymentAmount,
    double receiveAmount,
    String workingArea,
    Agent agent,
    String grade,
    String phone
  ) {
    this.customerCity = customerCity;
    this.customerCountry = customerCountry;
    this.customerName = customerName;
    this.openingAmount = openingAmount;
    this.outstandingAmount = outstandingAmount;
    this.paymentAmount = paymentAmount;
    this.receiveAmount = receiveAmount;
    this.workingArea = workingArea;
    this.agent = agent;
    this.grade = grade;
    this.phone = phone;
  }

  public long getCustomerCode() {
    return customerCode;
  }

  public void setCustomerCode(long customerCode) {
    this.customerCode = customerCode;
  }

  public String getCustomerCity() {
    return customerCity;
  }

  public void setCustomerCity(String customerCity) {
    this.customerCity = customerCity;
  }

  public String getCustomerCountry() {
    return customerCountry;
  }

  public void setCustomerCountry(String customerCountry) {
    this.customerCountry = customerCountry;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public double getOpeningAmount() {
    return openingAmount;
  }

  public void setOpeningAmount(double openingAmount) {
    this.openingAmount = openingAmount;
  }

  public double getOutstandingAmount() {
    return outstandingAmount;
  }

  public void setOutstandingAmount(double outstandingAmount) {
    this.outstandingAmount = outstandingAmount;
  }

  public double getPaymentAmount() {
    return paymentAmount;
  }

  public void setPaymentAmount(double paymentAmount) {
    this.paymentAmount = paymentAmount;
  }

  public double getReceiveAmount() {
    return receiveAmount;
  }

  public void setReceiveAmount(double receiveAmount) {
    this.receiveAmount = receiveAmount;
  }

  public String getWorkingArea() {
    return workingArea;
  }

  public void setWorkingArea(String workingArea) {
    this.workingArea = workingArea;
  }

  public Agent getAgent() {
    return agent;
  }

  public void setAgent(Agent agent) {
    this.agent = agent;
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
}
