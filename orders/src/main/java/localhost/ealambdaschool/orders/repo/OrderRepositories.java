package localhost.ealambdaschool.orders.repo;

import localhost.ealambdaschool.orders.models.Order;
import org.springframework.data.repository.CrudRepository;
public interface OrderRepositories extends CrudRepository<Order,Long>
{
}
