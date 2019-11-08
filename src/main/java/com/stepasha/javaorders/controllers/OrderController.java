package com.stepasha.javaorders.controllers;

import com.stepasha.javaorders.models.Orders;
import com.stepasha.javaorders.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

    //http://localhost:0138/orders//advanceamount/100
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
    //http://localhost:0138/orders/order
    @PostMapping(value = "/order",
    consumes = {"application/json"})
    public ResponseEntity<?> addNewReceipt(
            @Valid
            @RequestBody Orders newOrders){
        newOrders = orderService.save(newOrders);
        HttpHeaders responseHeader = new HttpHeaders();
        URI newOrderUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newOrders.getOrdnum())
                .toUri();
        responseHeader.setLocation(newOrderUri);
        //(order.getOrdnum(), responseHeaders, HttpStatus.CREATED);
        return new ResponseEntity<>(newOrders, responseHeader, HttpStatus.CREATED);


    }
    //http://localhost:0138/orders/order/11
    @PutMapping(value = "/order/{ordnum}",
            consumes = {"application/json"})
    public ResponseEntity<?> updateOrder(@RequestBody Orders updateOrder,
                                            @PathVariable long ordnum){
        orderService.update(updateOrder, ordnum);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //http://localhost:0138/orders/order/11
    @DeleteMapping(value = "/order/{ordnum}")
    public ResponseEntity<?> deleteOrder(@PathVariable long ordnum){
        orderService.delete(ordnum);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
