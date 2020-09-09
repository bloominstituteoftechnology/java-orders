package com.lambdaschool.javaorders.controllers;


import com.lambdaschool.javaorders.models.Customer;
import com.lambdaschool.javaorders.services.CustomerServices;
import com.lambdaschool.javaorders.views.OrderCount;
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
    CustomerServices customerServices;

    // http://localhost:2019/customers/orders
    @GetMapping(value = "/orders", produces = "application/json")
    public ResponseEntity<?> findAllCustomerOrders()
    {
        List<Customer> orderList = customerServices.findAllCustomerOrders();
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

//     http://localhost:2019/customers/customer/7
//     http://localhost:2019/customers/customer/77
    @GetMapping(value = "/customer/{customerID}", produces = "application/json")
    public ResponseEntity<?> findCustomerByID(@PathVariable long customerID)
    {
        Customer c = customerServices.findCustomerByID(customerID);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    // http://localhost:2019/customers/namelike/mes
    // http://localhost:2019/customers/namelike/cin
    @GetMapping(value = "/namelike/{keyword}", produces = "application/json")
    public ResponseEntity<?> findCustomerByName(@PathVariable String keyword)
    {
        List<Customer> customer = customerServices.findCustomerByKeyword(keyword);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    // http://localhost:2019/customers/orders/count
    @GetMapping(value = "/orders/count", produces = "application/json")
    public ResponseEntity<?> findOrdercount()
    {
        List<OrderCount> list = customerServices.findOrderCount();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


}
