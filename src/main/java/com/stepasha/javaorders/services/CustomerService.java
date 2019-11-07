package com.stepasha.javaorders.services;

import com.stepasha.javaorders.models.Customers;

import java.util.List;

public interface CustomerService {

    List<Customers> findAll();

    Customers findCustomerById(long id);

   // Customers findCustomerById(String name);

   // List<Customers> findByState(String state);


    List<Customers> getCustomerByNameLike(String likename);

}
