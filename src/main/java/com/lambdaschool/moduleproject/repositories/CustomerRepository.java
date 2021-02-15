package com.lambdaschool.moduleproject.repositories;

import com.lambdaschool.moduleproject.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
}
