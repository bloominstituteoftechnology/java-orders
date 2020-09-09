package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Customer;
import com.lambdaschool.javaorders.views.OrderCount;

import java.util.List;

public interface CustomerServices {
    Customer save(Customer customer);

    List<Customer> findAllCustomerOrders();

    Customer findCustomerByID(long customerID);

    List<Customer> findCustomerByKeyword(String keyword);

    List<OrderCount> findOrderCount();

    Customer update(Customer customer, long custcode);

    void delete(long custcode);
}
