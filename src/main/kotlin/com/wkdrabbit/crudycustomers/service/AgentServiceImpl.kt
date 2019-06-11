package com.wkdrabbit.crudycustomers.service

import com.wkdrabbit.crudycustomers.model.Agents
import com.wkdrabbit.crudycustomers.model.Customers
import com.wkdrabbit.crudycustomers.repos.AgentsRepository
import org.springframework.stereotype.Service
import java.util.ArrayList
import org.springframework.beans.factory.annotation.Autowired
import javax.persistence.EntityNotFoundException


@Service(value = "agentService")

class AgentServiceImpl : AgentService {


    @Autowired
    private val agentRepos: AgentsRepository? = null


    override fun findAll(): ArrayList<Agents> {
       var list = arrayListOf<Agents>()

        //TODO:Fix this
        agentRepos!!.findAll().iterator().forEachRemaining(list:add)

        return list
    }

    override fun findAgentsById(id: Long): Agents {
        //TODO: fix this
        return agentRepos!!.findById(id).orElseThrow(() -> EntityNotFoundException(id.toString()))
    }

    override fun findAgentsByName(name: String): Agents {

        //TODO: Finish this up

        var agent : Agents = Agents()
        if(agentRepos.findByName(name) != null){
             =  agentRepos.findByName(name)
        }

        return agent
    }

    override fun delete(id: Long) {
        if(agentRepos!!.findById(id).isPresent){
            agentRepos!!.deleteById(id)
        }
        else{
            throw EntityNotFoundException(id.toString())
        }
    }

    override fun save(agent: Agents): Agents {
       var newAgent = Agents(agent.agentName, agent.workingArea, agent.commission, agent.phone, agent.country)

        for((counter, Customers) in agent.customers.withIndex()){
            var newCustomer = Customers(agent.customers[counter].customerName,
                    agent.customers[counter].customerCity,
                    agent.customers[counter].workingArea,
                    agent.customers[counter].customerCountry,
                    agent.customers[counter].grade,
                    agent.customers[counter].openingAmount,
                    agent.customers[counter].receiveAmount,
                    agent.customers[counter].paymentAmount,
                    agent.customers[counter].outstandingAmount,
                    agent.customers[counter].phone,
                    agent)

            newAgent.customers.add( newCustomer)
        }

        return agentRepos!!.save(agent)
    }

    override fun update(restaurant: Agents, id: Long): Agents {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}