package com.lambdaschool.javaorders.repositories;

import com.lambdaschool.javaorders.model.Agent;
import org.springframework.data.repository.CrudRepository;

public interface AgentRepository extends CrudRepository<Agent, Long> {
}