package com.lambdaschool.javaorders.javaorders.repos;

import com.lambdaschool.javaorders.javaorders.models.Agents;
import org.springframework.data.repository.CrudRepository;

public interface AgentsRepo extends CrudRepository<Agents, Long>
{
    Agents findByAgentsName(String name);
}
