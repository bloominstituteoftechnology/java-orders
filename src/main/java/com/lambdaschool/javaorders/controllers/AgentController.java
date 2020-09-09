package com.lambdaschool.javaorders.controllers;


import com.lambdaschool.javaorders.models.Agent;
import com.lambdaschool.javaorders.services.AgentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agents")
public class AgentController {

    @Autowired
    AgentServices agentServices;

    // http://localhost:2019/agents/agent/9
    @GetMapping(value = "/agent/{agentId}", produces = "application/json")
    public ResponseEntity<?> findAgentById(@PathVariable long agentId)
    {
        Agent agent = agentServices.findAgentById(agentId);
        return new ResponseEntity<>(agent, HttpStatus.OK);
    }


    // DAY 3 STRETCH
    // DELETE /agents/unassigned/{agentcode}
    // http://localhost:2019/agents/unassigned/8
    @DeleteMapping(value = "/unassigned/{agentcode}")
    public ResponseEntity<?> deleteUnassignedAgentsById(@PathVariable long agentcode)
    {
        agentServices.delete(agentcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
