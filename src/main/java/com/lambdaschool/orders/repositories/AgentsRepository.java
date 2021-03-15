package com.lambdaschool.orders.repositories;

import com.lambdaschool.orders.models.Agents;
import org.springframework.data.repository.CrudRepository;

public interface AgentsRepository extends CrudRepository<Agents, Long> {
}
