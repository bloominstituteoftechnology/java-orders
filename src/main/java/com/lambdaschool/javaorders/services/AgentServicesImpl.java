package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Agent;
import com.lambdaschool.javaorders.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "agentServices")
public class AgentServicesImpl implements AgentServices
{
    @Autowired
    AgentRepository agentrepos;

    @Override
    public Agent save(Agent agent)
    {
        return agentrepos.save(agent); // spring handles saving related customers to agents
    }
}
