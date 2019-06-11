package com.jakeesveld.orders.service

import com.jakeesveld.orders.Order
import com.jakeesveld.orders.OrdersRepository
import org.springframework.beans.factory.annotation.Autowired

class OrderServiceImpl: OrderService {

    @Autowired
    var repo: OrdersRepository? = null

    override fun findAll(): List<Order> {
        val orderList = mutableListOf<Order>()
        repo!!.findAll().iterator().forEachRemaining { order: Order? -> order?.let { orderList.add(it) } }
        return orderList
    }

    override fun findByCustomer(id: Long): List<Order> {
        val orderList = mutableListOf<Order>()
        repo!!.findAll().iterator().forEachRemaining{order: Order? -> order?.let { orderList.add(it) }}
        return orderList.filter { order -> order.custCode.custCode == id }
    }
}