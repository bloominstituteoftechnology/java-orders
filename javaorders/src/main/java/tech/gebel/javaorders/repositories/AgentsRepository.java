package tech.gebel.javaorders.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import tech.gebel.javaorders.models.Agent;

@Component
public interface AgentsRepository extends CrudRepository<Agent, Long> {}
