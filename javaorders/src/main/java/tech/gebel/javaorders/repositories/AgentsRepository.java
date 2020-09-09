package tech.gebel.javaorders.repositories;

import org.springframework.data.repository.CrudRepository;
import tech.gebel.javaorders.models.Agent;

public interface AgentsRepository extends CrudRepository<Agent, Long> {}
