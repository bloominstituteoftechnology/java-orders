package com.lambdaschool.orders.repositories;

import com.lambdaschool.orders.models.Customers;
import org.springframework.data.repository.CrudRepository;

public interface CustomersRepository extends CrudRepository<Customers, Long> {
}
