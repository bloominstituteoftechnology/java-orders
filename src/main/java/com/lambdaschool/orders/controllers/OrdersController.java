package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.models.Order;
import com.lambdaschool.orders.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrdersController {
    @Autowired
    private OrderServices orderServices;

    // http://localhost:2019/orders/order/{ordnum}
    @GetMapping(value="/order/{ordnum}", produces = "application/json")
    public ResponseEntity<?> findOrderById(@PathVariable long ordnum) {
        Order order = orderServices.findOrderByOrdnum(ordnum);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
