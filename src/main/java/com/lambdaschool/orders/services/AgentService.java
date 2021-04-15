package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Agent;

public interface AgentService {

    Agent save(Agent agent);

    Agent findAgentById(long id);
}
