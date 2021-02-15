package com.lambdaschool.moduleproject.repositories;

import com.lambdaschool.moduleproject.models.Agent;
import org.springframework.data.repository.CrudRepository;

public interface AgentRepository extends CrudRepository<Agent, Long> {
}
