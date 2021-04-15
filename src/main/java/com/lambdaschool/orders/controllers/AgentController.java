package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.models.Agent;
import com.lambdaschool.orders.services.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("agents")
public class AgentController {

    @Autowired
    private AgentService agentservices;

    //agent/{agentid}
    @GetMapping(value = "/agent/{agentid}", produces = "application/json")
    public ResponseEntity<?> findAnAgentById(@PathVariable long agentid){
        Agent theReturn = agentservices.findAgentById(agentid);
        return new ResponseEntity<>(theReturn, HttpStatus.OK);
    }
}
