package tech.gebel.javaorders.models;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ordnum")
    private long orderNumber;

    @Column(name = "advanceamount")
    private double advanceAmount;

    @Column(name = "ordamount")
    private double orderAmount;

    @Column(name = "orderdescription")
    private String orderDescription;

    @ManyToOne
    @JoinColumn(name = "custcode",
            nullable = false)
    private Customer customer;

    public Order() {
    }

    public Order(double advanceAmount, double orderAmount, String orderDescription) {
        this.advanceAmount = advanceAmount;
        this.orderAmount = orderAmount;
        this.orderDescription = orderDescription;
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
}
