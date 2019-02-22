package com.lambdaschool.orders;

import com.lambdaschool.orders.models.Agent;
import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.models.Order;
import com.lambdaschool.orders.repositories.AgentRepository;
import com.lambdaschool.orders.repositories.CustomerRepository;
import com.lambdaschool.orders.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class OrdersController {
  @Autowired
  AgentRepository agentRepository;

  @Autowired
  CustomerRepository customerRepository;

  @Autowired
  OrderRepository orderRepository;

  @GetMapping("customer/order")
  public List<Customer> allCustomers() {
    List<Customer> customers = customerRepository.findAll();

    customers = customers.stream()
      .map(customer -> {
        Set<Order> orders = new HashSet<>(
          orderRepository.customerOrders(customer.getId())
        );
        customer.setOrders(orders);
        return customer;
      })
      .collect(Collectors.toList());

    return customers;
  }

  @GetMapping("customer/name/{name}")
  public List<Order> customerOrdersByName(@PathVariable String name) {
    Customer customer = customerRepository.findByName(name);

    return orderRepository.customerOrders(customer.getId());
  }

  @GetMapping("customer/order/{id}")
  public List<Order> customerOrdersById(@PathVariable Long id) {
    return orderRepository.customerOrders(id);
  }

  @GetMapping("agents")
  public List<Agent> allAgents() {
    List<Agent> agents = agentRepository.findAll();

    agents = agents.stream()
      .map(agent -> {
        Set<Customer> customers = new HashSet<>(
          customerRepository
          .agentCustomers()
        );
        agent.setCustomers(customers);
        return agent;
      })
      .collect(Collectors.toList());

    return agents;
  }

  @GetMapping("agents/orders")
  public Map<String, List<Object[]>> agentsAndOrders() {
    List<Agent> agents = agentRepository.findAll();

    Map<String, List<Object[]>> agentsOrders = new HashMap<>();

    agents.stream()
      .forEach(agent -> {
        List<Object[]> orders = agentRepository.agentOrders(agent.getId());
        agentsOrders.put(agent.getName(), orders);
      });

    return agentsOrders;
  }

  @DeleteMapping("customer/{id}")
  public void deleteCustomer(@PathVariable Long id) {
    customerRepository.deleteById(id);
  }

  @DeleteMapping("agents/{id}")
  public void deleteAgent(@PathVariable Long id) {
    agentRepository.deleteById(id);
  }
}
