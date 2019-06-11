package com.wkdrabbit.crudycustomers.controller

import com.wkdrabbit.crudycustomers.model.Agents
import com.wkdrabbit.crudycustomers.service.AgentService
import jdk.internal.agent.Agent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import javax.validation.Valid


@RestController
@RequestMapping
class AgentController {

    @Autowired
    var agentService = AgentService

    @GetMapping(value = "/agents")
    fun listAllAgents():ResponseEntity<*>{
        var myList : arrayListOf<Agents> = agentService.findAll()
        return ResponseEntity(myList, HttpStatus.OK)
    }


    //TODO: add rest of endpoints

    @DeleteMapping(value = "/agent/{agentid}")
    fun deleteAgentById(@PathVariable agentid : Long) : ResponseEntity<*>{

        agentService.delete(agentid)
        return ResponseEntity(HttpStatus.OK)
    }

    @PutMapping(value = "/agent/{agentid}")
    fun updateAgentById(@PathVariable agentid : Long): ResponseEntity<*>{
        //TODO: implement this
    }

    @PostMapping(value = "/agent")
    fun addNewAgent(@Valid @RequestBody newAgent : Agents):ResponseEntity<*>{
       var newAgent = agentService.save(newAgent)

        //set location header for newly created resource

        var responseHeaders = HttpHeaders()
        newAgentUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{agentid]").buildAndExpand(newAgent.)
    }

}
