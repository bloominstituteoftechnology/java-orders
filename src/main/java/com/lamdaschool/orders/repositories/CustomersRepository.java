package com.lamdaschool.orders.repositories;

import com.lamdaschool.orders.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomersRepository
    extends CrudRepository<Customer, Long>
{
}
