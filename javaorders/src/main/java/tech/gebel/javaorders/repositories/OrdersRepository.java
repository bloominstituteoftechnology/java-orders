package tech.gebel.javaorders.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import tech.gebel.javaorders.models.Order;

@Component
public interface OrdersRepository extends CrudRepository<Order, Long> {}
