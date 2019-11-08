package com.stepasha.javaorders.controllers;


import com.stepasha.javaorders.models.Customers;
import com.stepasha.javaorders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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
    // http://localhost:0138/customers/namelike/{likename}
    @GetMapping(value = "/namelike/{namelike}", produces = {"application/json"})
    public ResponseEntity<?> getCustomersByNameLike(@PathVariable String namelike) {
        List<Customers> myCustomers = customerService.getCustomerByNameLike(namelike);
        return new ResponseEntity<>(myCustomers, HttpStatus.OK);
    }
    //CREATE
    //http://localhost:0138/customers/customers
    @PostMapping(value = "/customers",
    consumes = {"application/json"})
    public ResponseEntity<?> addNewCustomer(
            @Valid
            @RequestBody Customers newCustomer){
        newCustomer = customerService.save(newCustomer);
        HttpHeaders responseHeader = new HttpHeaders();
        URI newCustomerUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newCustomer.getCustcode())
                .toUri();
        responseHeader.setLocation(newCustomerUri);
        return new ResponseEntity<>(null, responseHeader, HttpStatus.CREATED);
    }

    //http://localhost:0138/customers/customer/11
    @PutMapping(value = "/customer/{customerid}",
    consumes = {"application/json"})
    public ResponseEntity<?> updateCustomer(@RequestBody Customers updateCustomer,
                                            @PathVariable long customerid){
        customerService.update(updateCustomer, customerid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
