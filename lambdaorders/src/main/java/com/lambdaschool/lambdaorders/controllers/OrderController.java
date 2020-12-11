package com.lambdaschool.lambdaorders.controllers;

import com.lambdaschool.lambdaorders.models.Order;
import com.lambdaschool.lambdaorders.services.OrderService;
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
        Order o = orderService.findOrderById(ordernumber);
        return new ResponseEntity<>(o, HttpStatus.OK);
    }

    @PostMapping(value = "/order", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addOrder(@Valid @RequestBody Order newOrder)
    {
        newOrder.setOrdnum(0);
        newOrder = orderService.save(newOrder);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newOrderURI = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{custcode}")
                .buildAndExpand(newOrder.getOrdnum())
                .toUri();
        responseHeaders.setLocation(newOrderURI);
        return new ResponseEntity<>(newOrder, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = "/orders/{ordnum}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> replaceOrderByNum(@PathVariable long ordnum, @Valid @RequestBody Order updateOrder)
    {
        updateOrder.setOrdnum(ordnum);
        updateOrder = orderService.save(updateOrder);
        return new ResponseEntity<>(updateOrder, HttpStatus.OK);
    }

    @DeleteMapping(value = "/order/{ordnum}", consumes = "application/json")
    public ResponseEntity<?> deleteOrderById(@PathVariable long ordnum)
    {
        orderService.delete(ordnum);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
