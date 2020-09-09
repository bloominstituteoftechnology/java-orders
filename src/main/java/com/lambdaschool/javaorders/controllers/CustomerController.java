package com.lambdaschool.javaorders.controllers;


import com.lambdaschool.javaorders.models.Customer;
import com.lambdaschool.javaorders.services.CustomerServices;
import com.lambdaschool.javaorders.views.OrderCount;
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


    // POST /customers/customer - Adds a new customer including any new orders
    // http://localhost:2019/customers/customer
    @PostMapping(value = "/customer", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addNewCustomer(@Valid @RequestBody Customer newCustomer)
    {
        newCustomer.setCustcode(0);
       newCustomer = customerServices.save(newCustomer);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{custcode}")
                .buildAndExpand(newCustomer.getCustcode())
                .toUri();
        responseHeaders.setLocation(newCustomerURI);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

   // PUT /customers/customer/{custcode} - completely replaces the customer record including associated orders with the provided data
   // PUT http://localhost:2019/customers/customer/19
    @PutMapping(value = "/customer/{custid}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateFullCustomer(@PathVariable long custid, @Valid @RequestBody Customer updateCustomer)
    {
        updateCustomer.setCustcode(custid);
        updateCustomer = customerServices.save(updateCustomer);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    // PATCH /customers/customer/{custcode} - updates customers with the new data. Only the new data is to be sent from the frontend client.
    // PATCH http://localhost:2019/customers/customer/19
    @PatchMapping(value = "/customer/{custcode}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updatePartRestaurant(@PathVariable long custcode, @RequestBody Customer updateCustomer)
    {
        updateCustomer = customerServices.update(updateCustomer, custcode);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    // DELETE /customers/customer/{custcode} - Deletes the given customer including any associated orders
    // DELETE http://localhost:2019/customers/customer/54
    @DeleteMapping(value = "/customer/{custcode}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable long custcode)
    {
        customerServices.delete(custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
