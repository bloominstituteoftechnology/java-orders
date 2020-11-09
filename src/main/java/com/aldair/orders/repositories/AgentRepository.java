package com.aldair.orders.repositories;

import com.aldair.orders.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface AgentRepository extends CrudRepository<Customer, Long> {

}
