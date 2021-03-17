package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Agent;
import com.lambdaschool.orders.repositories.AgentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service(value="agentService")
public class AgentServicesImpl implements AgentServices{
    @Autowired
    private AgentsRepository agentsRepository;

    @Override
    public Agent findAgentById(long agentcode) {
        Agent agent = agentsRepository.findById(agentcode)
                .orElseThrow(()->new EntityNotFoundException("Agent "+agentcode+" not found"));
        return agent;
    }
}
