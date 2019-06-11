package com.wkdrabbit.crudycustomers.repos

import com.wkdrabbit.crudycustomers.model.Customers
import org.springframework.data.repository.CrudRepository

interface CustomersRepository : CrudRepository<Customers, Long>{
    //TODO: implement FindByName
}