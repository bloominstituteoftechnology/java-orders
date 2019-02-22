package com.lambdaschool.orders;

import com.lambdaschool.orders.models.Agent;
import com.lambdaschool.orders.repositories.AgentRepository;
import com.lambdaschool.orders.repositories.CustomerRepository;
import com.lambdaschool.orders.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class OrdersController {
  @Autowired
  AgentRepository agentRepository;

  @Autowired
  CustomerRepository customerRepository;

  @Autowired
  OrderRepository orderRepository;

  @GetMapping("agents")
  public List<Agent> allAgents() {
    return agentRepository.findAll();
  }
}
