package com.lambdaschool.modelorders.repositories;

import com.lambdaschool.modelorders.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomersRepository extends CrudRepository<Customer, Long> {

}
