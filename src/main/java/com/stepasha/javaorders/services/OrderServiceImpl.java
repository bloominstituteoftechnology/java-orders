package com.stepasha.javaorders.services;

import com.stepasha.javaorders.models.Orders;
import com.stepasha.javaorders.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersRepository orderRepository;


    @Override
    public Orders getOrderById(long ordnum) {
        return orderRepository.findByOrdnum(ordnum);
    }

    @Override
    public List<Orders> findAll() {

        List<Orders> list = new ArrayList<>();
        orderRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
}
