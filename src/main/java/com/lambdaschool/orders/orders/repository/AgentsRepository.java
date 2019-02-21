package com.lambdaschool.orders.orders.repository;

import com.lambdaschool.orders.orders.models.Agents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentsRepository extends JpaRepository<Agents, Long> {

}
