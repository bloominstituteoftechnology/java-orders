package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Customer;
import com.lambdaschool.javaorders.repositories.CustomersRepository;
import com.lambdaschool.javaorders.views.OrderCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "customerServices")
public class CustomerServicesImplementation implements CustomerServices{
    @Autowired
    CustomersRepository customerrepos;

    @Override
    public List<Customer> findAllCustomerOrders() {
        List<Customer> orderList = new ArrayList<>();
        customerrepos.findAll().iterator().forEachRemaining(orderList::add);
        return orderList;
    }

    @Override
    public Customer findCustomerByID(long customerID) {
        return customerrepos.findById(customerID)
                .orElseThrow(() -> new EntityNotFoundException("Customer " + customerID + " not found"));
    }

    @Override
    public List<Customer> findCustomerByKeyword(String keyword) {
        List<Customer> list = customerrepos.findByCustnameContainingIgnoringCase(keyword);
        return list;
    }

    @Override
    public List<OrderCount> findOrderCount() {
        List<OrderCount> list = customerrepos.findOrderCount();
        return list;
    }

    @Override
    public Customer save(Customer customer) {
        return customerrepos.save(customer);
    }
}
