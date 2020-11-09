package com.aldair.orders.services;

import com.aldair.orders.models.Customer;
import com.aldair.orders.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "customerService")
public class CustomerServiceImp implements CustomerService {
    @Autowired
    CustomerRepository customerrepo;

    @Override
    public Customer save(Customer customer) {
        return customerrepo.save(customer);
    }
}
