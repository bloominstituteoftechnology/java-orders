//package com.lambdaschool.modelorders.controller;
//
//import com.lambdaschool.modelorders.models.Customer;
//import com.lambdaschool.modelorders.services.CustomerServicesImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/customers")
//public class CustomerController {
//
//  @Autowired
//  private CustomerServicesImpl customerServicesImpl;
//
//  @GetMapping(value = "/customers",
//  produces = "application/json")
//  public ResponseEntity<?> listAllCustomers() {
//    List<Customer> myCustomers = customerServicesImpl.findAllCustomers();
//    return new ResponseEntity<>(myCustomers,
//                                HttpStatus.OK);
//  }
//
//}
