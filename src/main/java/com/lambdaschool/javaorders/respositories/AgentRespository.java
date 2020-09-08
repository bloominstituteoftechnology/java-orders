package com.lambdaschool.javaorders.respositories;

import com.lambdaschool.javaorders.models.Agent;
import org.springframework.data.repository.CrudRepository;

public interface AgentRespository extends CrudRepository<Agent, Long> {
}
