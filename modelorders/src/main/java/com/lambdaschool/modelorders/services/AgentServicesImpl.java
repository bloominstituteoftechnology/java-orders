package com.lambdaschool.modelorders.services;

import com.lambdaschool.modelorders.models.Agent;
import com.lambdaschool.modelorders.repositories.AgentsRepository;
import com.lambdaschool.modelorders.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgentServicesImpl implements AgentServices {

  @Autowired
  private AgentsRepository agentRepos;

  @Transactional
  @Override
  public Agent save(Agent agent) {
    return agentRepos.save(agent);
  }
}
