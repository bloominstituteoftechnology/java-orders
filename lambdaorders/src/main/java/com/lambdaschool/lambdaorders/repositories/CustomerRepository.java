package com.lambdaschool.lambdaorders.repositories;

import com.lambdaschool.lambdaorders.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long>
{
    Customer findByCustcode(long custcode);

    List<Customer> findByCustnameContainingIgnoringCase(String name);
}
