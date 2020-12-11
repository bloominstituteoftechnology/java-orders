package com.lambdaschool.lambdaorders.repositories;

import com.lambdaschool.lambdaorders.models.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long>
{
    List<Order> findAllByAdvanceamountGreaterThan(double amount);

    Order findByOrdnum(long ordnum);
}
