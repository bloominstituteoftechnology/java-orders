package com.jakeesveld.orders

import javax.persistence.*

@Entity
data class Agent @JvmOverloads constructor(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val agentCode: Long,
        @Column(nullable = false)
        var name: String? = "",
        var workingArea: String? = "",
        var commission: Double? = 0.0,
        var phone: String? = "",
        var country: String? = ""
)

@Entity
data class Customer @JvmOverloads constructor(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val custCode: Long,
        @Column(nullable = false)
        var name: String? = "",
        var city: String? = "",
        var workingArea: String? = "",
        var country: String? = "",
        var grade: String? = "",
        var openingAmt: Double? = 0.0,
        var receiveAmt: Double? = 0.0,
        var paymentAmt: Double? = 0.0,
        var outstandingAmt: Double? = 0.0,
        var phone: String? = "",
        @ManyToOne(cascade = [CascadeType.ALL])
        @JoinColumn(name = "agentCode")
        var agentCode: Long
)

@Entity
data class Order @JvmOverloads constructor(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val orderNum: Long,
        var orderAmt: Double? = 0.0,
        var advanceAmt: Double? = 0.0,
        @ManyToOne(cascade = [CascadeType.ALL])
        @JoinColumn(name = "custCode")
        val custCode: Long,
        @ManyToOne(cascade = [CascadeType.ALL])
        @JoinColumn(name = "agentCode")
        val agentCode: Long,
        var orderDesc: String? = ""
)
