package com.stepasha.javaorders.services;

import com.stepasha.javaorders.models.Customers;
import com.stepasha.javaorders.models.Orders;

import java.util.List;

public interface OrderService {

    Orders getOrderById(long ordnum);

    List<Orders> findAll();

    Orders save(Orders orders);

    Orders update(Orders orders, long id);

    void delete(long id);

}
