package com.lamdaschool.orders.repositories;

import com.lamdaschool.orders.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository
    extends CrudRepository<Order, Long>
{
}
