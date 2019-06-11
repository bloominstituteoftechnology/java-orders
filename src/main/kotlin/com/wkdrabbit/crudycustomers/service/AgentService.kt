package com.wkdrabbit.crudycustomers.service

import com.wkdrabbit.crudycustomers.model.Agents
import java.util.ArrayList



interface AgentService {

    fun findAll(): ArrayList<Agents>

    fun findAgentsById(id: Long): Agents

    fun findAgentsByName(name: String): Agents

    fun delete(id: Long)

    fun save(agent: Agents): Agents

    fun update(agent: Agents, id: Long): Agents
}