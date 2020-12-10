package com.rheact.orders.repositories;

import com.rheact.orders.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomersRepository extends CrudRepository<Customer, Long>  {

}
