package com.wkdrabbit.crudycustomers.repos

import com.wkdrabbit.crudycustomers.model.Orders
import org.springframework.data.repository.CrudRepository

interface OrdersRepository : CrudRepository<Orders, Long>{
    //TODO: implement FindByName
}