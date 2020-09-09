package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Order;
import com.lambdaschool.javaorders.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service(value = "orderServices")
public class OrderServicesImplementation implements OrderServices{
    @Autowired
    OrdersRepository orderrepos;

    @Override
    public Order findOrderById(long value) {
        return orderrepos.findById(value)
                .orElseThrow(() -> new EntityNotFoundException("Order " + value + " was not found"));
    }

    @Override
    public Order save(Order order) {
        return orderrepos.save(order);
    }
}
