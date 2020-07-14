package com.lambdaschool.javaorders.controllers;


import com.lambdaschool.javaorders.model.Agent;
import com.lambdaschool.javaorders.respositories.AgentRepository;
import com.lambdaschool.javaorders.services.AgentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agents")
public class AgentController {

    @Autowired
    private AgentServices agentservice;

    // http://localhost:2019/agents/agent/9

    @GetMapping(value = "/agent/{id}", produces = {"application/json"})
    public ResponseEntity<?> oneagent(@PathVariable long id){
        Agent agentman = agentservice.findAgentById(id);
        return new ResponseEntity<>(agentman, HttpStatus.OK);
    }
}