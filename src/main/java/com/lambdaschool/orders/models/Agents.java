package com.lambdaschool.orders.models;

import javax.persistence.*;

@Entity
@Table(name="agents")
public class Agents {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long agentcode;
    private String agentname;
    private double commision;
    private String country;
    private String phone;
    private String workingarea;

    public Agents() {
    }

    public Agents(String agentname, double commision, String country, String phone, String workingarea) {
        this.agentname = agentname;
        this.commision = commision;
        this.country = country;
        this.phone = phone;
        this.workingarea = workingarea;
    }

    public long getAgentid() {
        return agentcode;
    }

    public void setAgentid(long agentid) {
        this.agentcode = agentid;
    }

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname;
    }

    public double getCommision() {
        return commision;
    }

    public void setCommision(double commision) {
        this.commision = commision;
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

    public String getWorkingarea() {
        return workingarea;
    }

    public void setWorkingarea(String workingarea) {
        this.workingarea = workingarea;
    }
}
