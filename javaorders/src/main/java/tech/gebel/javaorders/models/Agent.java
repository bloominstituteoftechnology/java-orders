package tech.gebel.javaorders.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agents")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "agentcode")
    private long agentCode;

    @Column(name = "agentname",
            nullable = false)
    private String agentName;

    @Column(name = "workingarea")
    private String workingArea;

    @OneToMany(mappedBy = "agents",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    private List<Customer> customers = new ArrayList<>();

    private double commission;
    private String country, phone;

    public Agent() {
    }

    public Agent(String agentName, double commission, String country, String phone, String workingArea) {
        this.agentName = agentName;
        this.commission = commission;
        this.country = country;
        this.phone = phone;
        this.workingArea = workingArea;
    }

    public void setAgentCode(long agentCode) {
        this.agentCode = agentCode;
    }

    public long getAgentCode() {
        return agentCode;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWorkingArea() {
        return workingArea;
    }

    public void setWorkingArea(String workingArea) {
        this.workingArea = workingArea;
    }
}
