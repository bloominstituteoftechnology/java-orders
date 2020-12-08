package com.lambdaschool.lambdaorders.repositories;

import com.lambdaschool.lambdaorders.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long>
{

}
