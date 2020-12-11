package com.lambdaschool.lambdaorders.controllers;

import com.lambdaschool.lambdaorders.models.Agent;
import com.lambdaschool.lambdaorders.services.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agents")
public class AgentController
{
    @Autowired
    AgentService agentService;

    @GetMapping(value = "/agent{agentid}")
    public ResponseEntity<?> getAgentById(
            @PathVariable
                    long agentid)
    {
        Agent a = agentService.findAgentById(agentid);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }
}


