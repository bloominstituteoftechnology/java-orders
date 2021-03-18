package com.lambdaschool.javaorders.repositories;

import com.lambdaschool.javaorders.models.Agents;
import org.springframework.data.repository.CrudRepository;

public interface AgentsRepository extends CrudRepository<Agents, Long>
{
}
