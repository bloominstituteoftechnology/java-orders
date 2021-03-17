package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Order;
import com.lambdaschool.orders.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service(value = "orderService")
public class OrderServicesImpl implements OrderServices{
    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public Order findOrderByOrdnum(long ordnum){
        Order order = ordersRepository.findOrderByOrdnum(ordnum);
        return order;
    }

    @Override
    public Order save(Order order) {
        return null;
    }

    @Override
    public void delete(long ordnum) {

    }
}
