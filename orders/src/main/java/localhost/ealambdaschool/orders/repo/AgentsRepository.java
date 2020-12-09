package localhost.ealambdaschool.orders.repo;

import localhost.ealambdaschool.orders.models.Agent;
import org.springframework.data.repository.CrudRepository;

public interface AgentsRepository extends CrudRepository<Agent, Long> {
}
