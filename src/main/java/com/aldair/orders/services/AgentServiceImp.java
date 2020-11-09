package com.aldair.orders.services;

import com.aldair.orders.models.Agent;
import com.aldair.orders.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "agentService")
public class AgentServiceImp implements AgentService {
    @Autowired
    AgentRepository agentrepo;

    @Override
    public Agent save(Agent agent) {
        return agentrepo.save(agent);
    }
}
