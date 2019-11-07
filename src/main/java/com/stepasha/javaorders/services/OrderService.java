package com.stepasha.javaorders.services;

import com.stepasha.javaorders.models.Orders;

import java.util.List;

public interface OrderService {

    Orders getOrderById(long ordnum);

    List<Orders> findAll();
}
