package com.stepasha.javaorders.services;

import com.stepasha.javaorders.models.Customers;

import java.util.List;

public interface CustomerService {

    List<Customers> findAll();

    Customers findCustomerById(long id);


    List<Customers> getCustomerByNameLike(String likename);

}
