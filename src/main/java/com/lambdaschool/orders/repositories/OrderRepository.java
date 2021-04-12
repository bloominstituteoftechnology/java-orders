package com.lambdaschool.orders.repositories;

import com.lambdaschool.orders.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long>
{
}
