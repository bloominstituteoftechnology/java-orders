package com.wkdrabbit.crudycustomers.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

class Customers{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val customerId : Long = 0

    @Column(unique = true, nullable = false)
    val name : String = ""


    //TODO: Fix this to match data
    var customerName = ""
    var customerCity = ""
    var workingArea = ""
    var customerCountry = ""
    var grade = ""
    var openingAmount = 0.0
    var receiveAmount = 0.0
    var paymentAmount = 0.0
    var outstandingAmount = 0.0
    var phone = ""

    @ManyToOne
    @JoinColumn(name = "agentId", nullable = false)
    var agent : Agents = Agents()


    @OneToMany(mappedBy = "agent",
            cascade = [CascadeType.ALL],
            orphanRemoval = true)
    @JsonIgnoreProperties("customer")
    val orders = mutableListOf<Orders>()

    constructor(customerName: String, customerCity: String, workingArea: String, customerCountry: String, grade: String, openingAmount: Double, receiveAmount: Double, paymentAmount : Double, outstandingAmount: Double, phone: String, agent: Agents) {
        this.customerName = customerName
        this.customerCity = customerCity
        this.workingArea = workingArea
        this.customerCountry = customerCountry
        this.grade = grade
        this.openingAmount = openingAmount
        this.receiveAmount = receiveAmount
        this.paymentAmount = paymentAmount
        this.outstandingAmount = outstandingAmount
        this.phone = phone
        this.agent = agent
    }

    constructor()


}