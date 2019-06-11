package com.jakeesveld.orders.service

import com.jakeesveld.orders.Order

interface OrderService {
    fun findAll(): List<Order>
    fun findByCustomer(id: Long): List<Order>

}