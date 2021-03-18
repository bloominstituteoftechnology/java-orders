package com.lambdaschool.javaorders.repositories;

import com.lambdaschool.javaorders.models.Customers;
import org.springframework.data.repository.CrudRepository;

public interface CustomersRepository extends CrudRepository<Customers, Long>
{
}
