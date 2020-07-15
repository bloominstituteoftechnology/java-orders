package com.lambdaschool.javaorders.controllers;

import com.lambdaschool.javaorders.models.Customer;
import com.lambdaschool.javaorders.services.CustomerService;
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
public class CustomerController
{
    @Autowired
    private CustomerService customerService;

    //http://localhost:2019/customers/order

    @GetMapping(value = "/orders", produces = {"application/json"})
    public ResponseEntity<?> listCustomerOrders(){
        List<Customer> rtn = customerService.listAllCustomersOrders();
        return new ResponseEntity<>(rtn, HttpStatus.OK);
    }

    //http://localhost:2019/customers/customer/7

    @GetMapping(value = "/customer/{id}", produces = {"application/json"})
    public ResponseEntity<?> getCustomerById(@PathVariable long id){
        Customer rtn = customerService.FindById(id);
        return new ResponseEntity<>(rtn, HttpStatus.OK);
    }

    //Http:localhost:2019/customers/namelike/mes
    @GetMapping(value = "/namelike/{subname}", produces = {"application/json"})
    public ResponseEntity<?> listAllCustomerBySubname(@PathVariable String subname){
        List<Customer> rtn = customerService.findBySubname(subname);
        return new ResponseEntity<>(rtn, HttpStatus.OK);
    }
}
