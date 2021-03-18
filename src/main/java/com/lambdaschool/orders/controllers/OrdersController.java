package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.models.Order;
import com.lambdaschool.orders.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

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

    // http://localhost:2019/orders/order
    @PostMapping(value = "/order", produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> addNewOrder(@RequestBody @Valid Order order){
        order.setOrdnum(0);

        Order newOrder = orderServices.save(order);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newOrderURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{ordnum}")
                .buildAndExpand(newOrder.getOrdnum())
                .toUri();
        responseHeaders.setLocation(newOrderURI);

        return new ResponseEntity<>(newOrder, responseHeaders, HttpStatus.CREATED);
    }

    // http://localhost:2019/orders/order/{ordnum}
    @PutMapping(value = "/order/{ordnum}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> replaceOrderByOrdnum(@PathVariable long ordnum, @RequestBody @Valid Order order){
        order.setOrdnum(ordnum);

        Order newOrder = orderServices.save(order);

        return new ResponseEntity<>(newOrder, HttpStatus.OK);
    }

    @DeleteMapping(value = "/order/{ordnum}")
    public ResponseEntity<?> deleteById(@PathVariable long ordnum){
        orderServices.delete(ordnum);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
