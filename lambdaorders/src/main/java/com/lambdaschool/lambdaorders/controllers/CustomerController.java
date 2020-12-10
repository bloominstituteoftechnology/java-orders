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
    private CustomerService customerService;

    @GetMapping(value = "/orders", produces = "application/json")
    public ResponseEntity<?> listAllCustomers()
    {
        List<Customer> myCustomerList = customerService.findAllCustomers();
        return new ResponseEntity<>(myCustomerList, HttpStatus.OK);
    }

    @GetMapping(value = "/customer/{custid}", produces = "application/json")
    public ResponseEntity<?> getCustomerByCode(@PathVariable long custid)
    {
        Customer c = customerService.findCustomersById(custid);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @GetMapping(value = "/namelike/{custname}", produces = {"application/json"})
    public ResponseEntity<?> findCustomerByName(@PathVariable String custname)
    {
        List<Customer> c = customerService.findByCustomername(custname);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
}
