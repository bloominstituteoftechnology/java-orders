package com.thadocizn.orders.models;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ordNum;
    @Column
    private double ordAmount;
    @Column
    private double advanceAmount;
    @OneToMany
    @JoinColumn(name = "custCode")
    private long custCode;
    @OneToMany
    @JoinColumn(name = "agentCode")
    private long agentCode;
    @Column
    private String ordDescription;

}
