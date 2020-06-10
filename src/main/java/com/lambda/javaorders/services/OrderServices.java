package com.lambda.javaorders.services;

import com.lambda.javaorders.models.Orders;

import java.util.List;

public interface OrderServices {

    List<Orders> findAllOrders();

    Orders findOrderById(long id);
}
