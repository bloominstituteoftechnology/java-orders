package tech.gebel.javaorders.models;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "custcode")
    private long customerCode;

    @Column(name = "custcity")
    private String customerCity;

    @Column(name = "custcountry")
    private String customerCountry;

    @Column(name = "custname",
            nullable = false)
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

    private String grade, phone;
}
