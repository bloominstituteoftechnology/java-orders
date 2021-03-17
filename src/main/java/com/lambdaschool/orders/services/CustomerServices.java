package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customer;

import java.util.List;

public interface CustomerServices {
    List<Customer> findAllCustomers();

    Customer findCustomerById(long custcode);

    List<Customer> findCustomerByNameLike(String subname);
}
