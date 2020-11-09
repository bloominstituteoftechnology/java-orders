package com.aldair.orders.services;

import com.aldair.orders.models.Order;
import com.aldair.orders.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "orderService")
public class OrderServiceImp implements OrderService {
    @Autowired
    OrderRepository orderrepo;

    @Override
    public Order save(Order order) {
        return orderrepo.save(order);
    }
}
