package com.stepasha.javaorders.services;
import com.stepasha.javaorders.models.Agents;
import org.springframework.data.repository.CrudRepository;
public interface AgentService {

        //TODO 2
        Agents getAgentById(long id);

}
