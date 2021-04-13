package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Customer;
import com.lambdaschool.javaorders.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class CustomerServicessImpl implements CustomerServices{

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    @Override
    public Customer save(Customer customer) {
      return  customerRepository.save(customer);
    }
}
