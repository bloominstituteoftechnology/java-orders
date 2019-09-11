package com.lambdaschool.javaorders.javaorders.repos;

import com.lambdaschool.javaorders.javaorders.models.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepo extends CrudRepository<Orders, Long>
{
    Orders findByOrdNum(Double number);
}
