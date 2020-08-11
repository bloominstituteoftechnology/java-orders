package localhost.ealambdaschool.orders.repo;


import localhost.ealambdaschool.orders.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long>
{
}
