package com.lambdaschool.javaorders.repositories;

import com.lambdaschool.javaorders.models.Agent;
import org.springframework.data.repository.CrudRepository;

public interface AgentRepository extends CrudRepository<Agent, Long>
{
}
