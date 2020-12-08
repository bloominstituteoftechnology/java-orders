package com.lambdaschool.lambdaorders.repositories;

import com.lambdaschool.lambdaorders.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long>
{

}
