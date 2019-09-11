package com.jakeesveld.orders

import org.springframework.data.repository.CrudRepository

interface OrdersRepository: CrudRepository<Order, Long>

interface CustomersRepository: CrudRepository<Customer, Long>

interface  AgentsRepository: CrudRepository<Agent, Long>