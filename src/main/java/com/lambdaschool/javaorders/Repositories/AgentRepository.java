package com.lambdaschool.javaorders.respositories;

import com.lambdaschool.javaorders.model.Agent;
import org.springframework.data.repository.CrudRepository;

public interface AgentRepository extends CrudRepository<Agent, Long> {
}