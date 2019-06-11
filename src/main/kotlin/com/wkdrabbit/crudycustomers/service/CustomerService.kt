package com.wkdrabbit.crudycustomers.service

import com.wkdrabbit.crudycustomers.model.Customers
import java.util.ArrayList


interface CustomerService {

    fun findAll(): ArrayList<Customers>

    fun findCustomersById(id: Long): Customers

    fun findCustomersByName(name: String): Customers

    fun delete(id: Long)

    fun save(restaurant: Customers): Customers

    fun update(restaurant: Customers, id: Long): Customers
}