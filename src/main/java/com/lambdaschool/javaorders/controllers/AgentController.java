package com.lambdaschool.javaorders.controllers;

import com.lambdaschool.javaorders.models.Agent;
import com.lambdaschool.javaorders.services.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/agents")
public class AgentController
{
    @Autowired
    private AgentService agentService;

    @GetMapping(value = "/agent/{id}", produces = {"application/json"})
    public ResponseEntity<?> getAgentById(@PathVariable long id){
        Agent rtn = agentService.getAgentById(id);

        return new ResponseEntity<>(rtn, HttpStatus.OK);
    }
}


