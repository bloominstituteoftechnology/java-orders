package com.lambda.javaorders.repositories;

import com.lambda.javaorders.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository <Order, Long> {
}
