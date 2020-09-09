package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Agent;
import com.lambdaschool.javaorders.repositories.AgentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "agentServices")
public class AgentServicesImplementation implements AgentServices{
    @Autowired
    AgentsRepository agentrepos;

    @Override
    public Agent findAgentById(long agentId) {
        return agentrepos.findById(agentId)
                .orElseThrow(() -> new EntityNotFoundException("Agent " + agentId + " Was not found"));
    }

    @Transactional
    @Override
    public Agent save(Agent agent) {
        return agentrepos.save(agent);
    }

    @Transactional
    @Override
    public void delete(long agentcode) {
        if(agentrepos.findById(agentcode).isPresent())
        {
            Agent a = findAgentById(agentcode);
            if(a.getCustomers().size() == 0)
            {
                agentrepos.deleteById(agentcode);
            } else {
                throw new EntityExistsException("Found " + a.getCustomers().size() + " customers for agent " + agentcode + ". Agent cannot be removed.");
            }
        } else {
            throw new EntityNotFoundException("Agent " + agentcode + " not found!");
        }
    }
}
