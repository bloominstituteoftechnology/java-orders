package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Order;
import com.lambdaschool.javaorders.repositories.OrderRepository;
import com.lambdaschool.javaorders.view.Advanced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service(value = "orderService")
public class OrderServiceImpl implements OrderService
{
    @Autowired
    private OrderRepository orderrepos;

    @Override
    public Order save(Order order)
    {
        return orderrepos.save(order);
    }

    @Override
    public Order findOrderById(long id){
        return orderrepos.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Order Id " + id + " is not found."));
    }

    @Override
    public List<Advanced> listAdvanceOrders()
    {
        return orderrepos.getAdvanceOrders();
    }
}
