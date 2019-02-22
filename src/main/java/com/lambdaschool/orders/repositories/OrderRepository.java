package com.lambdaschool.orders.repositories;

import com.lambdaschool.orders.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
  @Query(
    value = "SELECT o.*" +
      " FROM orders o, customers c" +
      " WHERE c.custcode = o.custcode",
    nativeQuery = true
  )
  List<Order> customerOrders();
}
