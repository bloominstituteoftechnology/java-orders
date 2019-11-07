package com.stepasha.javaorders.controllers;


import com.stepasha.javaorders.models.Customers;
import com.stepasha.javaorders.services.CustomerService;
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
    private CustomerService customerService;

    // http://localhost:0138/customers/customer
    @GetMapping(value = "/customer",
            produces = {"application/json"})
    public ResponseEntity<?> listAllCustomers()
    {
        List<Customers> customers = customerService.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    // http://localhost:0138/customers/customer/3
    @GetMapping(value = "/customer/{id}",
            produces = {"application/json"})
    public ResponseEntity<?> findCustomerById(@PathVariable long id)
    {
        Customers myCustomers = customerService.findCustomerById(id);
        return new ResponseEntity<>(myCustomers, HttpStatus.OK);
    }


}
