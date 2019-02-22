package com.lambdaschool.orders.repositories;

import com.lambdaschool.orders.models.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Long> {}
