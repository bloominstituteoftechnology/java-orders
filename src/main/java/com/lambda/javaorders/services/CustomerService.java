package com.lambda.javaorders.services;

import com.lambda.javaorders.models.Customers;

import java.util.List;

public interface CustomerService {
    List<Customers> findAllCustomers();
    Customers findCustomerById(long id);
    List<Customers> findByNameLike(String thename);
}

