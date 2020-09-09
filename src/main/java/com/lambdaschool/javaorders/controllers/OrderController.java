package com.lambdaschool.javaorders.controllers;

import com.lambdaschool.javaorders.models.Customer;
import com.lambdaschool.javaorders.models.Order;
import com.lambdaschool.javaorders.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderServices orderServices;

    // http://localhost:2019/orders/order/7
    @GetMapping(value = "/order/{value}", produces = "application/json")
    public ResponseEntity<?> findOrderById(@PathVariable long value)
    {
        Order order = orderServices.findOrderById(value);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    // Stretch Goals
    // http://localhost:2019/orders/advanceamount
    @GetMapping(value = "/advanceamount/{amount}", produces = "application/json")
    public ResponseEntity<?> getCustAdvanceAmt(@PathVariable double amount)
    {
        List<Order> list = orderServices.getCustAdvanceAmt(amount);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    // POST /orders/order - adds a new order to an existing customer
    // http://localhost:2019/orders/order
    @PostMapping(value = "order", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addNewOrder(@Valid @RequestBody Order newOrder)
    {
        newOrder.setOrdnum(0);
        newOrder = orderServices.save(newOrder);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newOrderURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{ordnum}")
                .buildAndExpand(newOrder.getOrdnum())
                .toUri();
        responseHeaders.setLocation((newOrderURI));
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    // PUT /orders/order/{ordernum} - completely replaces the given order record
    // PUT http://localhost:2019/orders/order/63
    @PutMapping(value = "/order/{ordernum}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateFullOrder(@PathVariable long ordernum, @Valid @RequestBody Order updateOrder)
    {
        updateOrder.setOrdnum(ordernum);
        updateOrder = orderServices.save(updateOrder);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    // DELETE /orders/order/{ordernum} - deletes the given order
    // DELETE http://localhost:2019/orders/order/58
    @DeleteMapping(value = "/order/{ordernum}")
    public ResponseEntity<?> deleteOrderById(@PathVariable long ordernum)
    {
        orderServices.delete(ordernum);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
