package com.lambdaschool.lambdaorders.controllers;

import com.lambdaschool.lambdaorders.models.Customer;
import com.lambdaschool.lambdaorders.services.CustomerService;
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

    @PutMapping(value = "/customer", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addCustomer(@Valid @RequestBody Customer newCustomer)
    {
        newCustomer.setCustcode(0);
        newCustomer = customerService.save(newCustomer);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerURI = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{custcode}")
                .buildAndExpand(newCustomer.getCustcode())
                .toUri();
        responseHeaders.setLocation(newCustomerURI);
        return new ResponseEntity<>(newCustomer, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = "customer/{custcode}", consumes = "application/json")
    public ResponseEntity<?> replaceCustomerByCode(@PathVariable long custcode, @Valid @RequestBody Customer updateCustomer)
    {
        updateCustomer.setCustcode(custcode);
        updateCustomer = customerService.save(updateCustomer);
        return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
    }

    @PatchMapping(value = "customer/{custcode}", consumes = "application/json")
    public ResponseEntity<?> updateCustomerByCode(@PathVariable long custcode, @RequestBody Customer updateCustomer)
    {
        customerService.update(updateCustomer, custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/customer/{custcode}")
    public ResponseEntity<?> deleteCustomerByCode(@PathVariable long custcode)
    {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
