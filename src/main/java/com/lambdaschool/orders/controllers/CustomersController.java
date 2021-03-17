package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.services.CustomerServices;
import com.lambdaschool.orders.views.OrdersCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomersController {
    @Autowired
    private CustomerServices customerServices;

    //http:localhost:2019/customers/orders
    @GetMapping(value = "/orders", produces = "application/json")
    public ResponseEntity<?> findAllCustomers() {
        List<Customer> customerList = customerServices.findAllCustomers();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    //http:localhost:2019/customers/customer/{custcode}
    @GetMapping(value = "/customer/{custcode}", produces = "application/json")
    public ResponseEntity<?> findCustomerById(@PathVariable long custcode) {
        Customer customer = customerServices.findCustomerById(custcode);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    //http:localhost:2019/customers/namelike/{name}
    @GetMapping(value = "/namelike/{name}", produces = "application/json")
    public ResponseEntity<?> findCustomerByNameLike(@PathVariable String name) {
        List<Customer> customerList = customerServices.findCustomerByNameLike(name);
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    //  http://localhost:2019/customers/orders/count
    @GetMapping(value = "/orders/count", produces = "application/json")
    public ResponseEntity<?> getOrdersCount() {
        List<OrdersCount> ordersCounts = customerServices.getOrdersCount();
        return new ResponseEntity<>(ordersCounts, HttpStatus.OK);
    }

    //  http://localhost:2019/customers/customer
    @PostMapping(value = "/customer", produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> addCustomer(@RequestBody @Valid Customer customer) {
        customer.setCustcode(0);

        Customer newCustomer = customerServices.save(customer);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{custcode}")
                .buildAndExpand(newCustomer.getCustcode())
                .toUri();
        responseHeaders.setLocation(newCustomerURI);

        return new ResponseEntity<>(newCustomer, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = "/customer/{custcode}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> replaceCustomerByCustcode(@PathVariable long custcode, @RequestBody @Valid Customer customer) {
        customer.setCustcode(custcode);

        Customer newCustomer = customerServices.save(customer);

        return new ResponseEntity<>(newCustomer, HttpStatus.OK);
    }

    @PatchMapping(value = "/customer/{custcode}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> updateCustomerByCustcode(@PathVariable long custcode, @RequestBody Customer customer) {
        Customer updatedCustomer = customerServices.update(custcode, customer);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    @DeleteMapping(value = "/customer/{custcode}")
    public ResponseEntity<?> deleteByCustcode(@PathVariable long custcode){
        customerServices.delete(custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
