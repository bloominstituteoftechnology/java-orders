package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customer;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);

    List<Customer> findAllCustomerOrders();

    Customer findCustomerById(long id);

    List<Customer> findByNameLike(String substring);

    void delete(long id);

    Customer update(Customer customer, long id);


}
