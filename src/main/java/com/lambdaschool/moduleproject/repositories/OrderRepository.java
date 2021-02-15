package com.lambdaschool.moduleproject.repositories;

import com.lambdaschool.moduleproject.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
