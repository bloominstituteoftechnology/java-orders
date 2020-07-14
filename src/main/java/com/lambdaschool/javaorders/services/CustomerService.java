package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.model.Customers;

import java.util.List;

public interface CustomerService {
    List<Customers> findAllCustomers();
    Customers findCustomerById(long id);
    List<Customers> findByNameLike(String thename);
}
