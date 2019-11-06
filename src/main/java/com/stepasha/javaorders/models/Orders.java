package com.stepasha.javaorders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordnum;

    @Column(unique = true,
            nullable = false)
    private double ordamount;

    private double advanceamount;
    private String city;
    private String orderdescription;

    @OneToMany(mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("orders")
    private List<Customers> menus = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "payments",
            joinColumns = @JoinColumn(name = "ordnum"),
            inverseJoinColumns = @JoinColumn(name = "paymentid")
    )
    @JsonIgnoreProperties("restaurants")
    List<Payments> payments = new ArrayList<>();

    public Orders(double ordamount, double advanceamount, String city, String orderdescription) {
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.city = city;
        this.orderdescription = orderdescription;
    }
    public Orders(){}

    public double getOrdamount() {
        return ordamount;
    }

    public void setOrdamount(double ordamount) {
        this.ordamount = ordamount;
    }

    public double getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount) {
        this.advanceamount = advanceamount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOrderdescription() {
        return orderdescription;
    }

    public void setOrderdescription(String orderdescription) {
        this.orderdescription = orderdescription;
    }
}
