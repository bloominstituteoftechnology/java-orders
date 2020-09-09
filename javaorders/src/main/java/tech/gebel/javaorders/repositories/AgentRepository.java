package tech.gebel.javaorders.repositories;

import org.springframework.data.repository.CrudRepository;
import tech.gebel.javaorders.models.Agent;

public interface AgentRepository extends CrudRepository<Agent, Long> {}
