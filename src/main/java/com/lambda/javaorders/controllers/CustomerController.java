package com.lambda.javaorders.controllers;

import com.lambda.javaorders.models.Customers;
import com.lambda.javaorders.models.Orders;
import com.lambda.javaorders.services.CustomerService;
import com.lambda.javaorders.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private OrderServices orderservices;

    @Autowired
    private CustomerService customerservice;

    //    http://localhost:2019/customers/orders
    @GetMapping(value ="/orders", produces = {"application/json"})
    public ResponseEntity<?>listAllOrders(){
        List<Orders> myOrders = orderservices.findAllOrders();
        return new ResponseEntity<>(myOrders, HttpStatus.OK);
    }

    // http://localhost:2019/customers/customer/7
    @GetMapping(value = "/customer/{id}", produces = {"application/json"})
    public ResponseEntity<?> singleCustomer(@PathVariable long id){
        Customers customer = customerservice.findCustomerById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    // http://localhost:2019/customers/namelike/mes
    @GetMapping(value = "/namelike/{thename}", produces = {"application/json"})
    public ResponseEntity<?> namelike(@PathVariable String thename){
        List<Customers> customer = customerservice.findByNameLike(thename);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }


}
