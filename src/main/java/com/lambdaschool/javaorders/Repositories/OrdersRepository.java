package com.lambdaschool.javaorders.repositories;

import com.lambdaschool.javaorders.model.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository <Orders, Long> {
}