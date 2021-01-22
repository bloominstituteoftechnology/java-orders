package com.lambda.orders.servicers;

import com.lambda.orders.models.Order;
import com.lambda.orders.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "orderService")
public class OrderServicesImpl implements OrderServices{

    @Autowired
    OrdersRepository ordersrepos;

    @Transactional
    @Override
    public Order save(Order order) {
        return ordersrepos.save(order);
    }
}
