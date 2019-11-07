package com.stepasha.javaorders.services;

import com.stepasha.javaorders.models.Customers;

import java.util.List;

public interface CustomerService {

    List<Customers> findAll();

    Customers findCustomerById(long id);


    List<Customers> getCustomerByNameLike(String likename);

    //todo 1
    Customers save(Customers customers);

    Customers update(Customers customers, long id);

    void delete(long id);

}
