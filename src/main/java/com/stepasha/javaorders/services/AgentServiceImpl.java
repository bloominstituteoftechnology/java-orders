package com.stepasha.javaorders.services;

import com.stepasha.javaorders.models.Agents;
import com.stepasha.javaorders.repository.AgentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;


//TODO 3
@Service(value = "agentService")
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentsRepository agentRepo;

    @Override
    public Agents getAgentById(long id) {
        return agentRepo.findById(id);
    }

    @Override
    public Agents save(Agents agents) {
      if (agents.getCustomers().size() > 0){
          throw new EntityNotFoundException("Agents are not added through customers");
      }
      Agents newAgent = new Agents();
      newAgent.setCustomers(new ArrayList<>());
      return agentRepo.save(newAgent);
    }
}
