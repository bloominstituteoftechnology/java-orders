package com.lambdaschool.lambdaorders.repositories;

import com.lambdaschool.lambdaorders.models.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long>
{
    List<Customer> findByCustomerNameContainingIgnoringCase(String name);
}
