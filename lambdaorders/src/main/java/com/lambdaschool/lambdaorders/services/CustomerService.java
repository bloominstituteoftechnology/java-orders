package com.lambdaschool.lambdaorders.services;

import com.lambdaschool.lambdaorders.models.Customer;

import java.util.List;

public interface CustomerService
{
    List<Customer> findAllCustomers();
    List<Customer> findByCustomername(String custname);
    Customer findCustomersById(long id);

    Customer save(Customer customer);
    Customer update(Customer customer, long custcode);
    void deleteAll();
    void delete(long custcode);

}
