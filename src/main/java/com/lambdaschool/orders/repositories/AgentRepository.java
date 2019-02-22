package com.lambdaschool.orders.repositories;

import com.lambdaschool.orders.models.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AgentRepository extends JpaRepository<Agent, Long> {
  @Query(
    value = "SELECT ordnum, orddescription" +
      " FROM agents a, orders o" +
      " WHERE a.agentcode = :agentcode" +
      " AND a.agentcode = o.agentcode",
    nativeQuery = true
  )
  List<Object[]> agentOrders(@Param("agentcode") Long id);
}
