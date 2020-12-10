package com.lambdaschool.lambdaorders.services;

import com.lambdaschool.lambdaorders.models.Order;

import java.util.List;

public interface OrderService
{
    List<Order>findOrdersWithAdvanceAmount();

    Order findOrderById(long id);

//    Order save(Order order);
//    void delete(long ordername);
//    Order update(Order order, long ordernum);
//    void deleteAll();
}
