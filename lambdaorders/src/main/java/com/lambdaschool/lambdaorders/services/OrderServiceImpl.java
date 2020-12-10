package com.lambdaschool.lambdaorders.services;

import com.lambdaschool.lambdaorders.models.Order;
import com.lambdaschool.lambdaorders.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service(value = "orderService")
public class OrderServiceImpl implements OrderService
{
    @Autowired
    private OrderRepository orderrepos;

    @Override
    public List<Order> findOrdersWithAdvanceAmount()
    {
        return orderrepos.findAllByAdvanceamountGreaterThan(0.00);

    }

    @Override
    public Order findOrderById(long id) throws EntityNotFoundException
    {
        return orderrepos.findById(id).orElseThrow(() -> new EntityNotFoundException("Order " + id + " Not Found"));
    }

}
