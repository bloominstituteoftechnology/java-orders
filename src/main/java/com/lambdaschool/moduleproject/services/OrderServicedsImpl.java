package com.lambdaschool.moduleproject.services;

import com.lambdaschool.moduleproject.models.Order;
import com.lambdaschool.moduleproject.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service(value = "orderService")
public class OrderServicedsImpl implements OrderServices{

    @Autowired
    private OrderRepository orderrepos;

    @Transactional
    @Override
    public Order save (Order order) {
        return orderrepos.save(order);
    }
}
