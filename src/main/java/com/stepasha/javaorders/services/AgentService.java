package com.stepasha.javaorders.services;
import com.stepasha.javaorders.models.Agents;
import org.aspectj.weaver.loadtime.Agent;
import org.springframework.data.repository.CrudRepository;
public interface AgentService {

        //TODO 2
        Agents getAgentById(long id);

        Agents save(Agents agents);
}
