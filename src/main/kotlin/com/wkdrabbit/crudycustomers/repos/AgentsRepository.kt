package com.wkdrabbit.crudycustomers.repos

import com.wkdrabbit.crudycustomers.model.Agents
import org.springframework.data.repository.CrudRepository

interface AgentsRepository : CrudRepository<Agents, Long>{
    //TODO: implement FindByName
}