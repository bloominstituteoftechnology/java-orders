package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.model.Orders;

import java.util.List;

public interface OrderServices {

    List<Orders> findAllOrders();

    Orders findOrderById(long id);
}