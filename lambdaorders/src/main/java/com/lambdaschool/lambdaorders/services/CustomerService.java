package com.lambdaschool.lambdaorders.services;

import com.lambdaschool.lambdaorders.models.Customer;

import java.util.List;

public interface CustomerService
{
    List<Customer> findAllCustomers();
    List<Customer> findByCustomerName(String customername);
    Customer findCustomerById(long id);
}
