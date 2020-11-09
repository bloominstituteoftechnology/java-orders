package com.aldair.orders.repositories;

import com.aldair.orders.models.Agent;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Agent, Long> {

}
