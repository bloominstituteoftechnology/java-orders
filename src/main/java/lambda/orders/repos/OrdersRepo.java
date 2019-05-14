package lambda.orders.repos;

import lambda.orders.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepo extends CrudRepository<Order, Long>
{

}
