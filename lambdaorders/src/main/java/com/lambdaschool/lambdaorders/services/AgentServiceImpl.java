package com.lambdaschool.lambdaorders.services;

import com.lambdaschool.lambdaorders.models.Agent;
import com.lambdaschool.lambdaorders.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Transactional
@Service(value = "agentService")
public class AgentServiceImpl implements  AgentService
{
    @Autowired
    private AgentRepository agentrepos;

    @Override
    public Agent findAgentById(long id) throws EntityNotFoundException
    {
        return agentrepos.findById(id).orElseThrow(() -> new EntityNotFoundException("Agent Id " + id + " Not Found"));
    }
}
