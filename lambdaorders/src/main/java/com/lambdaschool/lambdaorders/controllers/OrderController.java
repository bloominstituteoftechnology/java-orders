package com.lambdaschool.lambdaorders.controllers;

import com.lambdaschool.lambdaorders.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController
{
    @Autowired
    OrderService orderService;

    @GetMapping(value = "/advanceamount")
    public ResponseEntity<?> getOrderWithAdvanceAmount()
    {
        List<Order> myOrderList = orderService.findOrdersWithAdvanceAmount();
        return new ResponseEntity<>(myOrderList, HttpStatus.OK);
    }

    @GetMapping(value = "/order/{ordernumber}", produces = "application/json")
    public ResponseEntity<?> getOrderByNumber(@PathVariable long ordernumber)
    {
        Order o = ordernumber.findOrderById(ordernumber);
        return new ResponseEntity<>(o, HttpStatus.OK);
    }
}
