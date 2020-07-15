package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Customer;

import java.util.List;

public interface CustomerService
{
    Customer save(Customer customer);

    List<Customer> listAllCustomersOrders();

    Customer FindById(long id);

    List<Customer> findBySubname(String subname);
}
