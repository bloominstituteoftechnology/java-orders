package com.lambdaschool.modelorders.repositories;

import com.lambdaschool.modelorders.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Order, Long> {
}
