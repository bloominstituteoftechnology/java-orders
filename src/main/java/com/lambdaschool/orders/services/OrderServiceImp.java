package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Order;
import com.lambdaschool.orders.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "OrderService")
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderRepository orderRepo;


    @Override
    public Order save(Order order) {
        return null;
    }

    @Override
    public Order findOrderById(long id) {
        return orderRepo.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Agent "+ id + " Not Found!"));
    }
}
