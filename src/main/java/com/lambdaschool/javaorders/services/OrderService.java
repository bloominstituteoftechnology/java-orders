package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Order;
import com.lambdaschool.javaorders.view.Advanced;

import java.util.List;

public interface OrderService
{
    Order save(Order order);
    Order findOrderById(long id);

    List<Advanced> listAdvanceOrders();
}
