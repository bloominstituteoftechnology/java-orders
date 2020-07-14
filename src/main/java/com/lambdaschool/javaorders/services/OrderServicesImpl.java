package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.model.Orders;
//import com.lambdaschool.javaorders.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;


@Service(value = "orderServices")
public class OrderServiceImpl implements OrderServices
{

    @Autowired
    private OrdersRepository orderrepo;

    @Override
    public List<Orders> findAllOrders(){
        List<Orders> rtnOrders = new ArrayList<>();
        orderrepo.findAll()
                .iterator()
                .forEachRemaining(rtnOrders::add);
        return rtnOrders;
    }
    @Override
    public Orders findOrderById(long id){
        return orderrepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Order "+ id + " Not found"));
    }
}
