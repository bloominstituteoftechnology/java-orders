package com.lambdaschool.lambdaorders.services;

import com.lambdaschool.lambdaorders.models.Order;

import java.util.List;

public interface OrderService
{
    List<Order>findOrdersWithAdvanceAmount();

    Order findOrderById(long id);
}
