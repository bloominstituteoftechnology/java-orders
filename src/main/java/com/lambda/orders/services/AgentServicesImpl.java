package com.lambda.orders.services;

import com.lambda.orders.models.Agent;
import com.lambda.orders.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service(value = "agentService")
public class AgentServicesImpl implements AgentServices
{
    @Autowired
    AgentRepository agentrepos;

    @Transactional
    @Override
    public Agent save(Agent agent)
    {
        return agentrepos.save(agent);
    }
}
