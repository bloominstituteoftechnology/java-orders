package com.lambdaschool.javaorders.javaorders.repos;

import com.lambdaschool.javaorders.javaorders.models.Customers;
import org.springframework.data.repository.CrudRepository;

public interface CustomersRepo extends CrudRepository<Customers, Long>
{
    Customers findByCustName(String name);
}
