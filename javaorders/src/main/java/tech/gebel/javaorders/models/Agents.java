package tech.gebel.javaorders.models;

import javax.persistence.*;

@Entity
@Table(name = "agents")
public class Agents {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "agentcode")
    private long agentCode;

    @Column(name = "agentname")
    private String agentName;

    private double commission;
    private String country;
    private String phone;

    @Column(name = "workingarea")
    private String workingArea;

    public Agents() {
    }

    public Agents(String agentName, double commission, String country, String phone, String workingArea) {
        this.agentName = agentName;
        this.commission = commission;
        this.country = country;
        this.phone = phone;
        this.workingArea = workingArea;
    }
}
