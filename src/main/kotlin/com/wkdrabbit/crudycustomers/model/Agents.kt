package com.wkdrabbit.crudycustomers.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.graalvm.compiler.core.common.type.ArithmeticOpTable
import sun.util.resources.Bundles
import javax.persistence.*

@Entity
@Table(name = "agent")
class Agents{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var agentId : Long = 0

    @Column(unique = true, nullable = false)
    var name : String = ""


    var agentName = ""
    var workingArea = ""
    var commission = 0.0
    var phone = ""
    var country = ""

    @OneToMany(mappedBy = "agent",
            cascade = [CascadeType.ALL],
            orphanRemoval = true)
    @JsonIgnoreProperties("agent")
    val customers = mutableListOf<Customers>()


    @OneToMany(mappedBy = "agent",
            cascade = [CascadeType.ALL],
            orphanRemoval = true)
    @JsonIgnoreProperties("agent")
    val orders = arrayListOf<Orders>()


    constructor(agentName: String, workingArea: String, commission: Double, phone: String, country: String) {
        this.agentName = agentName
        this.workingArea = workingArea
        this.commission = commission
        this.phone = phone
        this.country = country
    }

    constructor()


}