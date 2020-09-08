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
}
