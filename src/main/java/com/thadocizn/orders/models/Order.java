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

    public Order() {
    }

    public long getOrdNum() {
        return ordNum;
    }

    public double getOrdAmount() {
        return ordAmount;
    }

    public void setOrdAmount(double ordAmount) {
        this.ordAmount = ordAmount;
    }

    public double getAdvanceAmount() {
        return advanceAmount;
    }

    public void setAdvanceAmount(double advanceAmount) {
        this.advanceAmount = advanceAmount;
    }

    public long getCustCode() {
        return custCode;
    }

    public void setCustCode(long custCode) {
        this.custCode = custCode;
    }

    public long getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(long agentCode) {
        this.agentCode = agentCode;
    }

    public String getOrdDescription() {
        return ordDescription;
    }

    public void setOrdDescription(String ordDescription) {
        this.ordDescription = ordDescription;
    }
}
