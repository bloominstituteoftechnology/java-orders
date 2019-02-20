package com.thadocizn.orders.repositories;

import com.thadocizn.orders.models.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Long> {
}
