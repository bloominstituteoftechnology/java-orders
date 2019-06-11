package com.wkdrabbit.crudycustomers.model

import javax.persistence.*


@Entity
@Table(name =  "orders")
class Orders{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var menuId : Long = 0

    @Column(nullable = false)
    val name : String = ""


    var orderAmount = 0.0
    var advanceAmount = 0.0
    var customerCode : Long = 0
    var agentCode : Long = 0
    var orderDescription = ""

    @ManyToOne
    @JoinColumn(name = "agentId", nullable = false)
    var agent : Agents = Agents()


    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    var customer : Customers = Customers()

    constructor(orderAmount: Double, advanceAmount: Double, customer: Customers,agent: Agents, orderDescription: String) {
        this.orderAmount = orderAmount
        this.advanceAmount = advanceAmount
        this.orderDescription = orderDescription
        this.agent = agent
        this.customer = customer
    }
}