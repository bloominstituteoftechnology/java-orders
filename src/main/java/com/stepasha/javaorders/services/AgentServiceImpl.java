package com.stepasha.javaorders.services;

import com.stepasha.javaorders.models.Agents;
import com.stepasha.javaorders.repository.AgentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//TODO 3
@Service(value = "agentService")
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentsRepository agentRepo;

    @Override
    public Agents getAgentById(long id) {
        return agentRepo.findById(id);
    }
}
