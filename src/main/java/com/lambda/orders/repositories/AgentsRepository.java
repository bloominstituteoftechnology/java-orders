package com.lambda.orders.repositories;

import com.lambda.orders.models.Agent;
import org.springframework.data.repository.CrudRepository;

public interface AgentsRepository extends CrudRepository<Agent, Long> {
}
