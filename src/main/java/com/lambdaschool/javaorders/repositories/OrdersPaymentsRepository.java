package com.lambdaschool.javaorders.repositories;

import com.lambdaschool.javaorders.models.OrdersPayments;
import org.springframework.data.repository.CrudRepository;

public interface OrdersPaymentsRepository extends CrudRepository <OrdersPayments, Long>
{
}
