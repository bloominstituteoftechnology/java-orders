package lambda.orders.repos;

import lambda.orders.models.Agent;
import org.springframework.data.repository.CrudRepository;

public interface AgentsRepo extends CrudRepository<Agent, Long>
{
}
