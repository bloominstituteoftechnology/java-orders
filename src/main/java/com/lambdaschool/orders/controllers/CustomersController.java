package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.services.CustomerServices;
import com.lambdaschool.orders.views.OrdersCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomersController {
    @Autowired
    private CustomerServices customerServices;

    //http:localhost:2019/customers/orders
    @GetMapping(value = "/orders", produces = "application/json")
    public ResponseEntity<?> findAllCustomers(){
        List<Customer> customerList = customerServices.findAllCustomers();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    //http:localhost:2019/customers/customer/{custcode}
    @GetMapping(value = "/customer/{custcode}", produces = "application/json")
    public ResponseEntity<?> findCustomerById(@PathVariable long custcode){
        Customer customer = customerServices.findCustomerById(custcode);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    //http:localhost:2019/customers/namelike/{name}
    @GetMapping(value = "/namelike/{name}", produces = "application/json")
    public ResponseEntity<?> findCustomerByNameLike(@PathVariable String name){
        List<Customer> customerList = customerServices.findCustomerByNameLike(name);
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    //  http://localhost:2019/customers/orders/count
    @GetMapping(value = "/orders/count", produces = "application/json")
    public ResponseEntity<?> getOrdersCount(){
        List<OrdersCount> ordersCounts = customerServices.getOrdersCount();
        return new ResponseEntity<>(ordersCounts, HttpStatus.OK);
    }



}
