package lambda.orders.repos;

import lambda.orders.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer, Long>
{
	Customer findByCustname(String name);
}
