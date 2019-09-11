package com.jakeesveld.orders

import javax.persistence.*

@Entity
data class Agent @JvmOverloads constructor(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val agentCode: Long? = null,
        @Column(nullable = false)
        var name: String? = null,
        var workingArea: String? = null,
        var commission: Double? = null,
        var phone: String? = null,
        var country: String? = null
)

@Entity
data class Customer @JvmOverloads constructor(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val custCode: Long? = null,
        @Column(nullable = false)
        var name: String? = null,
        var city: String? = null,
        var workingArea: String? = null,
        var country: String? = null,
        var grade: String? = null,
        var openingAmt: Double? = null,
        var receiveAmt: Double? = null,
        var paymentAmt: Double? = null,
        var outstandingAmt: Double? = null,
        var phone: String? = null,
        var ordersList: List<Order>? = null,
        @ManyToOne(cascade = [CascadeType.ALL])
        @JoinColumn(name = "agentCode")
        var agentCode: Agent
)

@Entity
data class Order @JvmOverloads constructor(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val orderNum: Long? = null,
        var orderAmt: Double? = null,
        var advanceAmt: Double? = null,
        @ManyToOne(cascade = [CascadeType.ALL])
        @JoinColumn(name = "custCode")
        val custCode: Customer,
        @ManyToOne(cascade = [CascadeType.ALL])
        @JoinColumn(name = "agentCode")
        val agentCode: Agent,
        var orderDesc: String? = null
)
