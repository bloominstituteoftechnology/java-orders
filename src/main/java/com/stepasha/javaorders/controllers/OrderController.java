package com.stepasha.javaorders.controllers;

import com.stepasha.javaorders.models.Orders;
import com.stepasha.javaorders.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;


    // http://localhost:0138/orders/order/{id}
    @GetMapping(value = "/order/{ordnum}", produces = {"application/json"})
    public ResponseEntity<?> getOrderByOrdnum(@PathVariable long ordnum) {
        Orders myOrder = orderService.getOrderById(ordnum);
        return new ResponseEntity<>(myOrder, HttpStatus.OK);
    }

    @GetMapping(value = "/advanceamount/{advanceamount}", produces = {"application/json"})
    public ResponseEntity<?> getAllOrdersFilterByAdvanceAmount(@PathVariable double advanceamount){
        List<Orders> allOrders = orderService.findAll();
        List<Orders> returnOrders = new ArrayList<>();
        for (int i = 0; i < allOrders.size(); i++) {
            if (allOrders.get(i).getAdvanceamount() > advanceamount) {
                returnOrders.add(allOrders.get(i));
            }
        }
        return new ResponseEntity<>(returnOrders, HttpStatus.OK);
    }
}
