package com.lamdaschool.orders.repositories;

import com.lamdaschool.orders.models.Agent;
import org.springframework.data.repository.CrudRepository;

public interface AgentsRepository
    extends CrudRepository<Agent, Long>
{
}
