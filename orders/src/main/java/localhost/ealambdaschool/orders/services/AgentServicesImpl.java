package localhost.ealambdaschool.orders.services;

import localhost.ealambdaschool.orders.models.Agent;
import localhost.ealambdaschool.orders.repo.AgentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class AgentServicesImpl implements AgentServies {
@Autowired
    AgentsRepository agentsrepo;
    @Transactional
    @Override
    public Agent save(Agent agent)
    {
        return agentsrepo.save(agent);
    }
}
