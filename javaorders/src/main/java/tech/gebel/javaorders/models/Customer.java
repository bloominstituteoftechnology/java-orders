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

    @ManyToOne
    @JoinColumn(name = "agentcode",
            nullable = false)
    private Agent agent;


    private String grade, phone;

    public Customer() {
    }

    public Customer(String customerCity, String customerCountry, String customerName, double openingAmount, double outstandingAmount, double paymentAmount, double receiveAmount, String workingArea, Agent agent, String grade, String phone) {
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
}
