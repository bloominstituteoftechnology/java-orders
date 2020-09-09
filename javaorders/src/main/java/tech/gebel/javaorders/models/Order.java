package tech.gebel.javaorders.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ordnum", nullable = false)
  private long orderNumber;

  @Column(name = "advanceamount")
  private double advanceAmount;

  @Column(name = "ordamount")
  private double orderAmount;

  @Column(name = "orderdescription", nullable = false)
  private String orderDescription;

  @ManyToOne
  @JoinColumn(name = "custcode", nullable = false)
  private Customer customer;

  @ManyToMany
  @JoinTable(
    name = "orderspayments",
    joinColumns = @JoinColumn(name = "ordnum"),
    inverseJoinColumns = @JoinColumn(name = "paymentid")
  )
  Set<Payment> payments = new HashSet<>();

  public Order() {}

  public Order(
    double orderAmount,
    double advanceAmount,
    Customer customer,
    String orderDescription
  ) {
    this.advanceAmount = advanceAmount;
    this.orderAmount = orderAmount;
    this.orderDescription = orderDescription;
    this.customer = customer;
  }

  public long getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(long orderNumber) {
    this.orderNumber = orderNumber;
  }

  public double getAdvanceAmount() {
    return advanceAmount;
  }

  public void setAdvanceAmount(double advanceAmount) {
    this.advanceAmount = advanceAmount;
  }

  public double getOrderAmount() {
    return orderAmount;
  }

  public void setOrderAmount(double orderAmount) {
    this.orderAmount = orderAmount;
  }

  public String getOrderDescription() {
    return orderDescription;
  }

  public void setOrderDescription(String orderDescription) {
    this.orderDescription = orderDescription;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Set<Payment> getPayments() {
    return payments;
  }

  public void setPayments(Set<Payment> payments) {
    this.payments = payments;
  }
}
