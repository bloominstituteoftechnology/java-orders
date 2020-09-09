package com.lambdaschool.javaorders.repositories;

import com.lambdaschool.javaorders.models.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrdersRepository extends CrudRepository<Order, Long> {
    List<Order> findByAdvanceamountGreaterThan(double amount);
}
