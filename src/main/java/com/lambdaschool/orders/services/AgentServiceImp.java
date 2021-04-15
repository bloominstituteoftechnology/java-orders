package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Agent;
import com.lambdaschool.orders.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "AgentService")
public class AgentServiceImp implements AgentService{

    @Autowired
    private AgentRepository agentRepo;

    @Override
    public Agent save(Agent agent) {
        return null;
    }

    @Override
    public Agent findAgentById(long id) {
        return agentRepo.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Agent "+ id + " Not Found!"));
    }
}
