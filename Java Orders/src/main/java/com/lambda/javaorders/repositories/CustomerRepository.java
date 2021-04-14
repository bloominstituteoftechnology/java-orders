package com.lambda.javaorders.repositories;

import com.lambda.javaorders.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository <Customer, Long > {
}
