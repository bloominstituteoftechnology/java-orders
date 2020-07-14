package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Customer;
import com.lambdaschool.javaorders.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    private CustomerRepository customerrepos;

    @Override
    public Customer save(Customer customer)
    {
        return null;
    }
}
