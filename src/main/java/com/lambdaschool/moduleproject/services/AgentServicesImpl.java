package com.lambdaschool.moduleproject.services;

import com.lambdaschool.moduleproject.models.Agent;
import com.lambdaschool.moduleproject.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service (value = " agentService")
public class AgentServicesImpl implements AgentServices{
    @Autowired
    private AgentRepository agentrepos;

    @Transactional
    @Override
    public Agent save(Agent agent){
        return agentrepos.save(agent);
    }
}
