package com.stepasha.javaorders.repository;

import com.stepasha.javaorders.models.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders, Long> {

    Orders findByOrdnum(long ordnum);
}
