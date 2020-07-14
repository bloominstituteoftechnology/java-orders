package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.model.Agent;
import com.lambdaschool.javaorders.respositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;


@Service(value = "agentServices")
public class AgentServicesImpl implements AgentServices{
    @Autowired
    private AgentRepository agentrepository;

    @Override
    public Agent findAgentById(long id) {
        return agentrepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Agent "+id+" Not Found"));    }
}