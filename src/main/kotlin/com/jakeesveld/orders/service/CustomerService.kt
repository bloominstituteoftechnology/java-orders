package com.jakeesveld.orders.service

import com.jakeesveld.orders.Customer

interface CustomerService {
    fun delete(id: Long)
    fun create(customer: Customer): Customer
    fun update(customer: Customer, id: Long)
}