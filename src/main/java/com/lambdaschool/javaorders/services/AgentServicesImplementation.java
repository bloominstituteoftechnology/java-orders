package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Agent;
import com.lambdaschool.javaorders.repositories.AgentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service(value = "agentServices")
public class AgentServicesImplementation implements AgentServices{
    @Autowired
    AgentsRepository agentrepos;

    @Override
    public Agent findAgentById(long agentId) {
        return agentrepos.findById(agentId)
                .orElseThrow(() -> new EntityNotFoundException("Agent " + agentId + " Was not found"));
    }

    @Override
    public Agent save(Agent agent) {
        return agentrepos.save(agent);
    }
}
