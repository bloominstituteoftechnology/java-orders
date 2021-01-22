package com.lambda.orders.servicers;

import com.lambda.orders.models.Agent;
import com.lambda.orders.repositories.AgentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "agentService")
public class AgentServicesImpl implements AgentServices{

    @Autowired
    AgentsRepository agentrepo;

    @Transactional
    @Override
    public Agent save(Agent agent) {
        return agentrepo.save(agent);
    }
}
