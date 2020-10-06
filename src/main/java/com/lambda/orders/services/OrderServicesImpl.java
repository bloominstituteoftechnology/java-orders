package com.lambda.orders.services;

import com.lambda.orders.models.Order;
import com.lambda.orders.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "orderService")
public class OrderServicesImpl implements OrderServices
{
    @Autowired
    OrderRepository ordrepos;

    @Transactional
    @Override
    public Order save(Order order)
    {
        return ordrepos.save(order);
    }
}
