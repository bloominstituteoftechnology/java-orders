package com.lambdaschool.lambdaorders.controllers;

import com.lambdaschool.lambdaorders.models.Customer;
import com.lambdaschool.lambdaorders.services.CustomerService;
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
public class CustomerController
{
    @Autowired
    private CustomerService customerSercice;
    @GetMapping(value = "/orders", produces = "application/json")
    public ResponseEntity<?> listAllCustomers()
    {
        List<Customer> myCustomerList = customerSercice.findAllCustomers();
        return new ResponseEntity<>(myCustomerList, HttpStatus.OK);
    }

    @GetMapping(value = "/customer/{customerid}", produces = "application/json")
    public ResponseEntity<?> getCustomerById(@PathVariable long customerid)
    {
        Customer c = customerSercice.findCustomerById(customerid);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @GetMapping(value = "/namelike/{customername}", produces = "application/json")
    public ResponseEntity<?> findCustomerByName(@PathVariable String customername)
    {
        List<Customer> myCustomerList = customerSercice.findByCustomerName(customername);
        return new ResponseEntity<>(myCustomerList, HttpStatus.OK);
    }
}
