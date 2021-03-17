package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Agent;
import org.springframework.web.bind.annotation.RestController;


public interface AgentServices {
    Agent findAgentById(long agentcode);
}
