package tech.gebel.javaorders.repositories;

import org.springframework.data.repository.CrudRepository;
import tech.gebel.javaorders.models.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {}
