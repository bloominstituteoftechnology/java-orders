package com.lambda.orders.repositories;

import com.lambda.orders.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Order, Long> {
}
