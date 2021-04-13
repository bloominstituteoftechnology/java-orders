package com.lambdaschool.modelorders.repositories;

import com.lambdaschool.modelorders.models.Agent;
import org.springframework.data.repository.CrudRepository;

public interface AgentsRepository extends CrudRepository<Agent, Long> {
}
