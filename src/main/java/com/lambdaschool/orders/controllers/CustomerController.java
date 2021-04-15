package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private CustomerService customerservices;

    //http://localhost:2019/customers/orders
    @GetMapping(value = "/orders", produces = "application/json")
    public ResponseEntity<?> listAllCustomerOrders(){
        List<Customer> returnList = (List<Customer>) customerservices.findAllCustomerOrders();
        return new ResponseEntity<>(returnList, HttpStatus.OK);
    }

    //http://localhost:2019/customers/customer/{custID}
    @GetMapping(value = "customer/{custid}", produces = "application/json")
    public ResponseEntity<?> findACustomerById(@PathVariable long custid){
        Customer theReturn = customerservices.findCustomerById(custid);
        return new ResponseEntity<>(theReturn, HttpStatus.OK);
    }
    //http://localhost:2019/customers/namelike/{substring}
    @GetMapping(value = "namelike/{substring}", produces = "application/json")
    public ResponseEntity<?> findACustomerByNameLike(@PathVariable String substring){
        List<Customer> returnList = customerservices.findByNameLike(substring);
        return new ResponseEntity<>(returnList, HttpStatus.OK);
    }

    /*
    * Day 3
    * */

}
