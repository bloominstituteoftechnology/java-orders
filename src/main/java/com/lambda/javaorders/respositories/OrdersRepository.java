package com.lambda.javaorders.respositories;

import com.lambda.javaorders.models.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository <Orders, Long> {
}
